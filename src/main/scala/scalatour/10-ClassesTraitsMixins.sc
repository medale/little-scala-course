import java.util.UUID

class Person(var name: String)

val p1 = new Person("John Doe")

p1.name

p1.name = "John Smith"

p1.name


class Employee(name: String,
							 val id: String = UUID.randomUUID().toString)
	extends Person(name) {

}

val e1 = new Employee("Jennifer Huston")

e1.name
e1.id

val uuid = UUID.fromString("28724680-0f51-4e0a-81c9-da161b96fee8").toString

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

val joe = new Person("Joe") with CoffeeDrinker

joe.drinkCoffee()

joe.minutesToDozingOff

joe.drinkCoffee()

joe.minutesToDozingOff



val sue = new Person("Sue") with CoffeeDrinker with Exerciser

sue.minutesToDozingOff

sue.drinkCoffee()

sue.minutesToDozingOff

sue.exercise()

sue.minutesToDozingOff