import org.apache.commons.io.{FileUtils, IOUtils}

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


trait Audit {

	var auditLevel = "low"

	def audit(action: String): Unit = {
		val user = getUser()
		val message = getLogMessage(user, action)
		writeAudit(message)
	}

	def writeAudit(message: String): Unit

	def getUser(): String = {
		//from login, cookie etc.
		val randomUser = "alice"
		randomUser
	}

	def getLogMessage(user: String,
										action: String): String = {
		s"${user} - ${action}"
	}
}

trait LogAudit extends Audit {

	var logFile = "/var/log/audit"

	override def writeAudit(message: String): Unit = {
		//use log4j or Files to append to logFile
		println(message)
	}

	override def getLogMessage(user: String,
														 action: String): String = {
		val basicMessage = super.getLogMessage(action, user)
		s"${basicMessage} to ${logFile}"
	}
}

trait CloudAudit extends Audit {
	var remoteHost = "host1"

	override def writeAudit(message: String): Unit = {
		//write to remote host
		println(message)
	}

	override def getLogMessage(action: String,
														 user: String): String = {
		val basicMessage = super.getLogMessage(action, user)
		s"${basicMessage} to ${remoteHost}"
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