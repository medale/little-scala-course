class Person(var name: String) {
	if (name.isEmpty) throw new
			IllegalArgumentException("Empty name")
}

try {
	new Person("")
} catch {
	case e: IllegalArgumentException =>
		println(e)
}


val p1 = new Person("John Doe")

p1.name

p1.name = "John Smith"

p1.name


class Employee(name: String,
							 val id: String = "009")
	extends Person(name)

val e1 = new Employee("Jennifer Huston")

e1.name
e1.id

val uuid = "42"

val e2 = new Employee("Austin Martin", uuid)

e2.id == uuid

val e3 = new Employee("Austin Martin", uuid)

//by default - Object.equals
val areTheyEqual = e2 == e3




trait AwakenessReservoir {
	var minutesToDozingOff: Int = 0
}

trait CoffeeDrinker extends AwakenessReservoir {

	val r = scala.util.Random

	def drinkCoffee(): Unit = {
		val timeToBecomingTiredInMinutes = r.nextInt(120)
		minutesToDozingOff += timeToBecomingTiredInMinutes
	}
}

trait Exerciser extends AwakenessReservoir {

	def exercise(): Unit = {
		minutesToDozingOff += 120
	}
}

val joe = new Person("Joe")
	with CoffeeDrinker

joe.drinkCoffee()

joe.minutesToDozingOff

joe.drinkCoffee()

joe.minutesToDozingOff



val sue = new Person("Sue")
	with CoffeeDrinker
	with Exerciser

sue.minutesToDozingOff

sue.drinkCoffee()

sue.minutesToDozingOff

sue.exercise()

sue.minutesToDozingOff