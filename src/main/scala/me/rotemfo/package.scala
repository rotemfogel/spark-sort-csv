package me

import org.apache.spark.sql.types._

/**
  * project: spark-app
  * package: me.rotemfo
  * file:    package
  * created: 2019-09-11
  * author:  rotem
  */
package object rotemfo {
  final private val aggregationsSchema = StructType(Array(
    StructField("timestamp", LongType, nullable = false),
    StructField("tenantid", LongType, nullable = false),
    StructField("serviceid", LongType, nullable = false),
    StructField("configurationid", LongType, nullable = false),
    StructField("modeid", IntegerType, nullable = false),
    StructField("dayid", IntegerType, nullable = false),
    StructField("hourid", IntegerType, nullable = false),
    StructField("recordid", LongType, nullable = false),
    StructField("name", StringType, nullable = false),
    StructField("stream", StringType, nullable = false),
    StructField("keys", StringType, nullable = false),
    StructField("data", StringType, nullable = false),
    StructField("func1", DoubleType, nullable = true),
    StructField("func2", DoubleType, nullable = true),
    StructField("func3", DoubleType, nullable = true),
    StructField("func4", DoubleType, nullable = true),
    StructField("windowtypeid", IntegerType, nullable = false),
    StructField("interval", IntegerType, nullable = false),
    StructField("advanceby", IntegerType, nullable = true),
    StructField("ingestiontime", LongType, nullable = false)
  ))

  final private val metricsSchema = StructType(Array(
    StructField("measuregroup", StringType, nullable = true),
    StructField("measuretype", StringType, nullable = true),
    StructField("measurename", StringType, nullable = false),
    StructField("measurecount", LongType, nullable = false),
    StructField("measuremin", DoubleType, nullable = true),
    StructField("measuremax", DoubleType, nullable = true),
    StructField("measuremean", DoubleType, nullable = true),
    StructField("measuremeanrate", DoubleType, nullable = true),
    StructField("timestamp", LongType, nullable = true),
    StructField("tenantid", LongType, nullable = true),
    StructField("serviceid", LongType, nullable = true),
    StructField("configurationid", LongType, nullable = true),
    StructField("entitytypeid", IntegerType, nullable = true),
    StructField("entityid", LongType, nullable = true)
  ))

  final private val servermetricsSchema = StructType(Array(
    StructField("timestamp", LongType, nullable = false),
    StructField("tenantid", LongType, nullable = false),
    StructField("serviceid", LongType, nullable = false),
    StructField("configurationid", LongType, nullable = false),
    StructField("modeid", IntegerType, nullable = false),
    StructField("host", StringType, nullable = false),
    StructField("metricname", StringType, nullable = false),
    StructField("dayid", IntegerType, nullable = false),
    StructField("hourid", IntegerType, nullable = false),
    StructField("recordid", LongType, nullable = false),
    StructField("serverhostuniqueid", StringType, nullable = false),
    StructField("metrictypeid", IntegerType, nullable = false),
    StructField("count", LongType, nullable = false),
    StructField("total", LongType, nullable = false),
    StructField("percentage", DoubleType, nullable = false)
  ))

  final private val transactionrecordsSchema = StructType(Array(
    StructField("timestamp", LongType, nullable = false),
    StructField("tenantid", LongType, nullable = false),
    StructField("serviceid", LongType, nullable = false),
    StructField("configurationid", LongType, nullable = false),
    StructField("modeid", IntegerType, nullable = false),
    StructField("recordid", LongType, nullable = false),
    StructField("transactionid", LongType, nullable = false)
  ))

  final private val transactionsSchema = StructType(Array(
    StructField("timestamp", LongType, nullable = false),
    StructField("tenantid", LongType, nullable = false),
    StructField("serviceid", LongType, nullable = false),
    StructField("configurationid", LongType, nullable = false),
    StructField("modeid", IntegerType, nullable = false),
    StructField("unitid", StringType, nullable = false),
    StructField("dayid", IntegerType, nullable = false),
    StructField("hourid", IntegerType, nullable = false),
    StructField("parserprotocol", StringType, nullable = true),
    StructField("transactionid", LongType, nullable = false),
    StructField("transaction", StringType, nullable = false),
    StructField("transactiontypeid", IntegerType, nullable = false),
    StructField("transactiontagid", IntegerType, nullable = false),
    StructField("transactionstarttime", LongType, nullable = false),
    StructField("transactionendtime", LongType, nullable = false),
    StructField("location", StringType, nullable = true)
  ))

  final private val recordsSchema = StructType(Array(
    StructField("tenantid", LongType, nullable = false),
    StructField("serviceid", LongType, nullable = false),
    StructField("recordid", LongType, nullable = false),
    StructField("parserprotocol", StringType, nullable = false),
    StructField("unitid", StringType, nullable = false),
    StructField("driverid", StringType, nullable = true),
    StructField("timestamp", LongType, nullable = false),
    StructField("ingestiontime", LongType, nullable = false),
    StructField("dayid", IntegerType, nullable = false),
    StructField("hourid", IntegerType, nullable = false),
    StructField("configurationid", LongType, nullable = false),
    StructField("modeid", IntegerType, nullable = false),
    StructField("recordsourceid", IntegerType, nullable = false),
    StructField("recordtargetid", IntegerType, nullable = false),
    StructField("recordtypeid", IntegerType, nullable = false),
    StructField("recordtagid", IntegerType, nullable = false),
    StructField("name", StringType, nullable = false),
    StructField("forbiddenrecord", StringType, nullable = true), // should be BooleanType
    StructField("sensitiverecord", StringType, nullable = true), // should be BooleanType
    StructField("reliablerecord", StringType, nullable = true), // should be BooleanType
    StructField("hasviolation", StringType, nullable = true), // should be BooleanType
    StructField("errorrecord", StringType, nullable = true), // should be BooleanType
    StructField("propertybag", StringType, nullable = true),
    StructField("sizebytes", LongType, nullable = true),
    StructField("alarm", StringType, nullable = true),
    StructField("battery", StringType, nullable = true),
    StructField("cellular", StringType, nullable = true),
    StructField("charger", StringType, nullable = true),
    StructField("configuration", StringType, nullable = true),
    StructField("doors", StringType, nullable = true),
    StructField("ecus", StringType, nullable = true),
    StructField("encryption", StringType, nullable = true),
    StructField("engine", StringType, nullable = true),
    StructField("gear", StringType, nullable = true),
    StructField("firmware", StringType, nullable = true),
    StructField("fuel", StringType, nullable = true),
    StructField("keys", StringType, nullable = true),
    StructField("lamps", StringType, nullable = true),
    StructField("location", StringType, nullable = true),
    StructField("message", StringType, nullable = true),
    StructField("motion", StringType, nullable = true),
    StructField("network", StringType, nullable = true),
    StructField("pedals", StringType, nullable = true),
    StructField("safety", StringType, nullable = true),
    StructField("tcu", StringType, nullable = true),
    StructField("temperature", StringType, nullable = true),
    StructField("tip", StringType, nullable = true),
    StructField("tires", StringType, nullable = true),
    StructField("user", StringType, nullable = true),
    StructField("wifi", StringType, nullable = true),
    StructField("windows", StringType, nullable = true),
    StructField("remotestart", StringType, nullable = true),
    StructField("drive", StringType, nullable = true),
    StructField("metadata", StringType, nullable = true),
    StructField("schemaversion", IntegerType, nullable = true),
    StructField("users", StringType, nullable = true)
  ))

  final private val violationsSchema = StructType(Array(
    StructField("timestamp", LongType, nullable = false),
    StructField("tenantid", LongType, nullable = false),
    StructField("serviceid", LongType, nullable = false),
    StructField("configurationid", LongType, nullable = false),
    StructField("modeid", IntegerType, nullable = false),
    StructField("unitid", StringType, nullable = true),
    StructField("dayid", IntegerType, nullable = false),
    StructField("hourid", IntegerType, nullable = false),
    StructField("recordid", LongType, nullable = false),
    StructField("propertybag", StringType, nullable = true),
    StructField("rawdata", StringType, nullable = true),
    StructField("parserprotocol", StringType, nullable = true),
    StructField("violationtypeid", IntegerType, nullable = false),
    StructField("violationtagid", IntegerType, nullable = false),
    StructField("violation", StringType, nullable = true),
    StructField("severityid", IntegerType, nullable = false),
    StructField("violationid", LongType, nullable = false),
    StructField("parentviolationid", LongType, nullable = false),
    StructField("violationstarttime", LongType, nullable = false),
    StructField("violationendtime", LongType, nullable = false),
    StructField("read", StringType, nullable = false),
    StructField("hidden", StringType, nullable = false),
    StructField("violationscopeid", IntegerType, nullable = false),
    StructField("originalviolation", StringType, nullable = true),
    StructField("violationsourceid", IntegerType, nullable = true),
    StructField("violationsubject", StringType, nullable = true),
    StructField("rulename", StringType, nullable = true),
    StructField("ruletypeid", IntegerType, nullable = true),
    StructField("ruleid", LongType, nullable = true),
    StructField("occurrences", IntegerType, nullable = true),
    StructField("encryption", StringType, nullable = true),
    StructField("messagevariables", StringType, nullable = true),
    StructField("location", StringType, nullable = true),
    StructField("messageformat", StringType, nullable = true),
    StructField("messagefactsavropropertybag", StringType, nullable = true),
    StructField("custommessageformat", StringType, nullable = true),
    StructField("multimessageformat", StringType, nullable = true),
    StructField("ruleuuid", StringType, nullable = true),
    StructField("affectedunits", IntegerType, nullable = true),
    StructField("highlights", StringType, nullable = true),
    StructField("aggregationstarttime", LongType, nullable = true),
    StructField("aggregationendtime", LongType, nullable = true),
    StructField("aggregationaffectedunits", IntegerType, nullable = true),
    StructField("aggregatedhighlights", StringType, nullable = true),
    StructField("aggregatedviolation", StringType, nullable = true),
    StructField("sessionviolationenabled", StringType, nullable = false),
    StructField("sessionviolationdurationoverrideseconds", IntegerType, nullable = true),
    StructField("aggregationenabled", StringType, nullable = false),
    StructField("aggregationdurationoverrideseconds", IntegerType, nullable = true),
    StructField("sessionviolationversion", IntegerType, nullable = true),
    StructField("ingestiontime", LongType, nullable = true),
    StructField("grouping", StringType, nullable = true),
    StructField("aggregationgrouping", StringType, nullable = true),
    StructField("profiletypeid", IntegerType, nullable = true),
    StructField("profileid", LongType, nullable = true),
    StructField("aggregationscopeid", IntegerType, nullable = false),
    StructField("violationunits", StringType, nullable = true),
    StructField("aggregationviolationunits", StringType, nullable = true),
    StructField("recordinfo", StringType, nullable = true),
    StructField("score", IntegerType, nullable = true)
  ))

  final val booleanFields = Map(
    "records" -> Array("forbiddenrecord", "sensitiverecord", "reliablerecord", "hasviolation", "errorrecord"),
    "violations" -> Array("read", "hidden", "sessionviolationenabled", "aggregationenabled")
  )

  final val schemaMap = Map(
    "aggregations" -> aggregationsSchema,
    "metrics" -> metricsSchema,
    "servermetrics" -> servermetricsSchema,
    "transactionrecords" -> transactionrecordsSchema,
    "transactions" -> transactionsSchema,
    "records" -> recordsSchema,
    "violations" -> violationsSchema
  )

  final val DAYID: String = "dayid"
  final val TIMESTAMP: String = "timestamp"
  final val CONFIGURATIONID: String = "configurationid"
  final val CSV: String = "com.databricks.spark.csv"
}
