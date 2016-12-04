case class OrderedPerson(name: String, age: Int)
	extends Ordered[OrderedPerson] {

	def compare(that: OrderedPerson): Int = {
		if (this == that) {
			0
		} else {
			val nameCompare = this.name.compare(that.name)
			if (nameCompare != 0) {
				nameCompare
			} else {
				this.age - that.age
			}
		}
	}

}

val p1 = OrderedPerson("Markus", 42)
val p2 = OrderedPerson("John", 25)
val p3 = OrderedPerson("Jane", 36)
val p4 = OrderedPerson("Markus",39)

val ps = List(p2,p3,p1,p4)

ps.sorted