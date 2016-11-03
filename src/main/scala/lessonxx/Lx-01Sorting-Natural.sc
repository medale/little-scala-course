//http://www.scala-lang.org/api/current/index.html#scala.math.Ordering
val nums = List(1,7,5,9,3)

nums.sorted
nums.sorted(Ordering.Int.reverse)

case class Person(name: String, age: Int)

val p1 = Person("Markus", 42)
val p2 = Person("Joe", 25)
val p3 = Person("Jane", 36)
val p4 = Person("Markus",39)

val ps = List(p2,p3,p1,p4)

//Error - no implicit natural ordering
//ps.sorted

ps.sortBy(_.age)

//sort by length of their name?
ps.sortWith((pa,pb) => pa.name.length < pb.name.length)