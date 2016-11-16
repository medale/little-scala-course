class Person(var name: String) {

	nameCheck(name)

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

p1.name = "John Smith"

p1.name







class Employee(name: String,
							 val id: String = "009")
	extends Person(name)

val e1 = new Employee("Jennifer Huston")

e1.name
e1.id

val uuid = "42"

val e2 = new Employee("Austin Martin", "123")

e2.id == uuid

val e3 = new Employee("Austin Martin", "123")

//by default - Object.equals
val areTheyEqual = e2 == e3

class Employee2(name: String,
								val id: String = "42")
	extends Person(name) {
	//override equals(that: Any): Boolean = ...
	//override hashCode: Int = ...
}










trait Audit {

	var auditLevel = "low"

	def audit(action: String): Unit = {
		val user = getUser()
		writeAudit(user, action)
	}

	def writeAudit(user: String,
								 action: String): Unit = {
		println(s"trait Audit: ${user}-${action}")
	}

	def getUser(): String = {
		//from login, cookie etc.
		val randomUser = "alice"
		randomUser
	}
}

trait LogAudit extends Audit {

	var logFile = "/var/log/audit"

	override def writeAudit(user: String,
													action: String): Unit = {
		println(s"trait LogAudit")
		super.writeAudit(user, action)
	}
}

trait CloudAudit extends Audit {
	var remoteHost = "host1"

	override def writeAudit(user: String,
													action: String): Unit = {
		println(s"trait CloudAudit")
		super.writeAudit(user, action)
	}
}

abstract class MyService extends Audit {

	def execute(): Unit = {
		audit("MyService.execute")
		//execute...
	}
}

val myService0 = new MyService with LogAudit
myService0.execute()

val myService1 = new MyService with LogAudit with CloudAudit
myService1.execute()

val myService2 = new MyService with CloudAudit with LogAudit
myService2.execute()