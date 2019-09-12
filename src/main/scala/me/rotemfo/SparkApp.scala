package me.rotemfo

import java.io.File

import org.apache.commons.io.FileUtils
import org.apache.commons.io.filefilter.{DirectoryFileFilter, NotFileFilter, TrueFileFilter}
import org.apache.spark.sql.SparkSession
import org.slf4j.{Logger, LoggerFactory}

/**
  * project: my-app
  * package: me.rotemfo
  * file:    SparkApp
  * created: 2018-07-11
  * author:  rotem
  */
object SparkApp {

  private final val logger: Logger = LoggerFactory.getLogger(getClass)
  private final val sep: String = File.separator

  def main(args: Array[String]): Unit = {
    val dir = args(0)
    val inputDir = dir.split(sep)
    val filterDir = inputDir.last
    val baseDir = inputDir.dropRight(1)

    import scala.collection.JavaConverters._
    val tables = FileUtils.
      listFilesAndDirs(new File(dir), new NotFileFilter(TrueFileFilter.INSTANCE), DirectoryFileFilter.DIRECTORY)
      .asScala
      .map(_.getName)
      .filterNot(_.equals(filterDir))
      .toSeq
      .sorted

    logger.info(s"$tables")
    val runtime = Runtime.getRuntime
    val cores = BigDecimal(runtime.availableProcessors() * 0.9).setScale(0, BigDecimal.RoundingMode.HALF_UP)
    val max = BigDecimal(runtime.maxMemory() * 0.9 / 1024 / 1024 / 1024).setScale(0, BigDecimal.RoundingMode.HALF_UP).intValue()
    val mem = Math.max(max, 16)

    val spark = SparkSession
      .builder()
      .appName("spark-sort-csv")
      .master("local[*]")
      .config("spark.executor.cores", cores.toString)
      .config("spark.executor.memory", s"${mem}g")
      .getOrCreate()

    logger.info(s"${spark.conf.getAll}")

    tables.foreach(table => {
      val schema = schemaMap(table)
      logger.info(s"$table")
      val path = s"$dir$sep$table"

      val df = spark
        .read
        .format(CSV)
        .option("compression", "gzip")
        .option("delimiter", "|")
        .schema(schema)
        .load(path)

      val outputDir = baseDir.mkString(sep)
      val tableOutputDir = s"$outputDir${sep}sorted$sep$table"
      FileUtils.deleteQuietly(new File(tableOutputDir))

      val rows = df.count()

      if (rows > 0) {
        logger.info(s"table $table has $rows rows")

        df.sort(TIMESTAMP, CONFIGURATIONID)
          .repartition(1)
          .write
          .format(CSV)
          .option("header", "true")
          .option("delimiter", "|")
          .option("quoteMode", "NON_NUMERIC")
          .save(s"$tableOutputDir")
      }
    })
    spark.stop()
  }
}
 
