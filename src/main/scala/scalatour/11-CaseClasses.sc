case class Person(name: String, age: Int)

//apply method - no new
val p1 = Person("John Doe", 42)

p1.name

p1.age

val p2 = Person("Jane Doe", 39)

val p3 = Person("Jane Doe", 39)

val areTheyEqual = p2 == p3
//and hashCode, toString, unapply

val people = List(p1,p2,p3)

val (youngPeople, olderPeople) =
	people.partition { person =>
	person match {
		case Person(_, age) if age < 40 => true
		case _ => false
	}
}

val Person(name, age) = p3

name
age

