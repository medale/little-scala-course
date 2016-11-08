val helloWorld = "Hello, Scala World!"

val helloWorld2: String =
	s"${helloWorld} explict type"

//vals are immutable
//helloWorld2 = "this is a different string"

val names = List("Markus", "Joe", "Jane")

//vars are mutable
var allHellos = ""

names.foreach(name =>
	allHellos += s"Hello, ${name}! ")

println(allHellos)

//or
names.mkString("Hello ", " and ", "!")