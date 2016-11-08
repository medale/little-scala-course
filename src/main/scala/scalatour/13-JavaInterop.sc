import scala.collection.JavaConverters._
import java.util.ArrayList
import scala.beans.BeanProperty
//import aliasing - very nice for name collisions!
import java.util.{List => JavaList}

val myJavaList = new ArrayList[String]()
myJavaList.add("hello")
myJavaList.add("world")

val buffer: scala.collection.mutable.Buffer[String] = myJavaList.asScala

val myScalaList: List[String] = buffer.toList

val capStrings = myScalaList.map { str =>
	str.capitalize
}

val javaCapStrings: JavaList[String] = capStrings.asJava




class Person(@BeanProperty var name: String,
						 @BeanProperty var age: Int) {}

val p1 = new Person("John Doe", 42)

p1.age = 43
p1.setAge(43)