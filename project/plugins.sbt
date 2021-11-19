// https://github.com/sbt/sbt-assembly
// invoke via: sbt assembly
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "1.1.0")

// https://github.com/rtimush/sbt-updates
// invoke via: dependencyUpdates
// invoke via: dependencyUpdatesReport (default output target/dependency-updates.txt)
// dependencyUpdatesFilter -= moduleFilter(organization = "org.scala-lang")
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.6.0")

// https://scalacenter.github.io/scalafix/
// invoke via: fix alias
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.9.32")

// https://github.com/scalameta/sbt-scalafmt
// invoke via: scalafmtAll
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.3")

