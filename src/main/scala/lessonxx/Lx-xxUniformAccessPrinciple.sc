class Person(var name: String) {

	nameCheck(name)
	//nameCheck(newName)

	//private var myName = newName

	//uniform access principle
/*	def name_=(newName: String): Unit = {
		nameCheck(newName)
		myName = newName
	}

	def name = myName*/

	//Scala Cookbook 4.15
	def canEqual(a: Any) = a.isInstanceOf[Person]

	override def equals(that: Any): Boolean = {
		that match {
			case that: Person => {
				that.canEqual(this) &&
					this.hashCode == that.hashCode
			}
			case _ => false
		}
	}
	override def hashCode:Int = {
		val prime = 31
		val result = prime + (if (name == null) 0 else name.hashCode)
		result
	}

	private def nameCheck(newName: String): Unit = {
		if (newName.isEmpty) {
			throw new
					IllegalArgumentException("Empty name")
		}
	}
}

try {
	new Person("")
} catch {
	case e: IllegalArgumentException =>
		println(e)
}


val p1 = new Person("John Doe")
p1.name

try {
	p1.name = ""
} catch {
	case e: IllegalArgumentException =>
		println(e)
}

p1.name