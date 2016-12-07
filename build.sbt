name := "little-scala-course"
version := "1.0"
scalaVersion := "2.11.8"

libraryDependencies += "commons-io" % "commons-io" % "2.5"
libraryDependencies += "com.typesafe" % "config" % "1.3.1"
libraryDependencies += "com.jsuereth" %% "scala-arm" % "1.4"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.0.1" exclude("org.scalatest", "scalatest_2.11")
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.0.1" exclude("org.scalatest", "scalatest_2.11")
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

//From scoverage examples
//coverageEnabled := true
//sbt clean coverage test
//sbt coverageReport
coverageExcludedPackages := "ecosystem.*;scalatour.*"
coverageMinimum := 70
coverageFailOnMinimum := false
coverageHighlighting := {
  if (scalaBinaryVersion.value == "2.11")
    true
  else
    false
}

publishArtifact in Test := false
parallelExecution in Test := false

//Solution to deduplicate error for Spark 2.0 for assembly task
//from http://queirozf.com/entries/creating-scala-fat-jars-for-spark-on-sbt-with-sbt-assembly-plugin
assemblyMergeStrategy in assembly := {
  case PathList("org","aopalliance", xs @ _*) => MergeStrategy.last
  case PathList("javax", "inject", xs @ _*) => MergeStrategy.last
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
  case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
  case PathList("org", "apache", xs @ _*) => MergeStrategy.last
  case PathList("com", "google", xs @ _*) => MergeStrategy.last
  case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
  case PathList("com", "codahale", xs @ _*) => MergeStrategy.last
  case PathList("com", "yammer", xs @ _*) => MergeStrategy.last
  case "about.html" => MergeStrategy.rename
  case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
  case "META-INF/mailcap" => MergeStrategy.last
  case "META-INF/mimetypes.default" => MergeStrategy.last
  case "plugin.properties" => MergeStrategy.last
  case "log4j.properties" => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
