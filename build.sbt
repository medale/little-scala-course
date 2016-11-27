name := "little-scala-course"

version := "1.0"

scalaVersion := "2.11.8"

// https://mvnrepository.com/artifact/commons-io/commons-io
libraryDependencies += "commons-io" % "commons-io" % "2.5"

// https://mvnrepository.com/artifact/com.typesafe/config
libraryDependencies += "com.typesafe" % "config" % "1.3.1"

libraryDependencies += "com.jsuereth" %% "scala-arm" % "1.4"

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core_2.11
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.0.1" exclude("org.scalatest", "scalatest_2.11")

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql_2.11
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.0.1" exclude("org.scalatest", "scalatest_2.11")

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1" % "test"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
