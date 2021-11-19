inThisBuild(
  List(
    version := "2.0-SNAPSHOT",
    organization := "org.uebercomputing",
    scalaVersion := "2.13.7",
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision,
    scalacOptions := Seq("-target:jvm-1.8",
    "-encoding", "UTF-8",
    "-unchecked",
    "-deprecation",
    "-feature",
    "-Yrangepos",
    "-Ywarn-unused",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen"
    )
  )
)

val scalaTestVersion = "3.2.10"
val sparkVersion = "3.2.0"

val lightbendDependencies = Seq(
  ("com.typesafe" % "config" % "1.4.1"),
  ("com.typesafe.scala-logging" %% "scala-logging" % "3.9.4")
)

val sparkDependencies = Seq(
  ("org.apache.spark" %% "spark-core" % sparkVersion % "provided")
    .exclude("org.scalatest", "scalatest_2.13"),
  ("org.apache.spark" %% "spark-sql" % sparkVersion % "provided")
    .exclude("org.scalatest", "scalatest_2.13"),
  ("org.apache.spark" %% "spark-hive" % sparkVersion % "provided")
    .exclude("org.scalatest", "scalatest_2.13")
)

val miscDependencies = Seq(
  ("commons-io" % "commons-io" % "2.11.0")
)

val testDependencies = Seq(
  ("org.scalatest" %% "scalatest" % scalaTestVersion % "it,test")
)

lazy val littleScalaCourse = (project in file("."))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings: _*)
  .settings(libraryDependencies := lightbendDependencies ++
    sparkDependencies ++
    miscDependencies ++
    testDependencies)

ThisBuild / assemblyMergeStrategy := {
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
    val oldStrategy = (ThisBuild / assemblyMergeStrategy).value
    oldStrategy(x)
}
