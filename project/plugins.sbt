// https://github.com/sbt/sbt-assembly
// invoke via: sbt assembly
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.1.5")

// https://github.com/rtimush/sbt-updates
// invoke via: dependencyUpdates
// invoke via: dependencyUpdatesReport (default output target/dependency-updates.txt)
// dependencyUpdatesFilter -= moduleFilter(organization = "org.scala-lang")
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.6.4")

// https://scalacenter.github.io/scalafix/
// invoke via: fix alias
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.11.1")

// https://github.com/scalameta/sbt-scalafmt
// invoke via: scalafmtAll
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.2")

