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

  def main(args: Array[String]): Unit = {
    val dir = args(0)
    val inputDir = dir.split(File.separator)
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

    val spark = SparkSession
      .builder()
      .appName("my-app")
      .master("local[*]")
      .config("spark.executor.cores", cores.toString)
      .config("spark.executor.memory", "16g")
      .getOrCreate()

    tables.foreach(table => {
      val customSchema = schemaMap(table)
      val path = s"$dir${File.separator}$table"
      val df = spark
        .read
        .option("compression", "gzip")
        .option("delimiter", "|")
        .schema(customSchema)
        .csv(path)

      df.printSchema()

      val outputDir = baseDir.mkString(File.separator)
      val tableOutputDir = s"$outputDir/sorted/$table"
      FileUtils.deleteQuietly(new File(tableOutputDir))
      df.sort("timestamp", "configurationid")
        .coalesce(1)
        .rdd
        .saveAsTextFile(tableOutputDir)
    })
    spark.stop()
  }
}
 
