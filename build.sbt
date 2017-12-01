name := "little-scala-course"
version := "1.0"
scalaVersion := "2.11.8"

val sparkVersion = "2.2.0"

val lightbendDependencies = Seq(
  ("com.typesafe" % "config" % "1.3.2"),
  ("com.typesafe.play" %% "play-json" % "2.6.7")
    .exclude("org.scala-lang", "scala-library")
    .exclude("com.fasterxml.jackson.core", "jackson-core")
    .exclude("com.fasterxml.jackson.core", "jackson-annotations")
    .exclude("com.fasterxml.jackson.core", "jackson-databind")
    .exclude("com.fasterxml.jackson.datatype", "jackson-datatype-jdk8")
    .exclude("com.fasterxml.jackson.datatype", "jackson-datatype-jsr310"),
  ("com.typesafe.scala-logging" %% "scala-logging" % "3.7.2")
)

val sparkDependencies = Seq(
  ("org.apache.spark" %% "spark-core" % sparkVersion % "provided")
    .exclude("org.scalatest", "scalatest_2.11"),
  ("org.apache.spark" %% "spark-sql" % sparkVersion % "provided")
    .exclude("org.scalatest", "scalatest_2.11"),
  ("org.apache.spark" %% "spark-hive" % sparkVersion % "provided")
    .exclude("org.scalatest", "scalatest_2.11")
)

val miscDependencies = Seq(
  //match Spark jackson version
  ("com.fasterxml.jackson.core" % "jackson-databind" % "2.6.5"),
  ("com.fasterxml.jackson.core" % "jackson-annotations" % "2.6.5"),
  ("commons-io" % "commons-io" % "2.6"),
  ("com.jsuereth" %% "scala-arm" % "2.0")
)

val testDependencies = Seq(
  ("org.scalactic" %% "scalactic" % "3.0.4" % "it,test"),
  ("org.scalatest" %% "scalatest" % "3.0.4" % "it,test")
)

lazy val root = (project in file("."))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings: _*)
  .settings(libraryDependencies := lightbendDependencies ++
    sparkDependencies ++
    miscDependencies ++
    testDependencies)

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
