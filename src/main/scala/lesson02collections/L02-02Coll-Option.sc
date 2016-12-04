//no more NPEs?

def makeConnection(connUrl: String) = {
	println(s"connecting to ${connUrl}...")
}

val prop0 = "jdbc:mysql://LOCALHOST:3306/test"
val prop1 = null

val s0Opt: Option[String] = Option(prop0)
val s1Opt: Option[String] = Option(prop1)

//idiomatic - treat like a collection
s0Opt.map(_.toLowerCase()).foreach { s0 =>
	val client = makeConnection(s0)
	//do your work
}

s1Opt.map { s1 =>
	val client = makeConnection(s1)
}

//default value
val connectionUrl = s0Opt.getOrElse(throw new RuntimeException("Must define connection URL!"))



