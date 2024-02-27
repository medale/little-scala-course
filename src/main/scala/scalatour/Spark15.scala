package scalatour

import org.apache.spark.sql.SparkSession

case class Person(name: String, age: Int)

object Spark15 {

  def main(args: Array[String]): Unit = {

    val p1 = Person("John", 20)
    val p2 = Person("Jane", 30)
    val p3 = Person("John", 40)
    val p4 = Person("Jane", 20)
    val p5 = Person("John", 30)

    val people = List(p1, p2, p3, p4, p5)

    val spark = SparkSession.builder().master("local").appName("combined-age").getOrCreate()

    import spark.implicits._

    val peopleDs = spark.createDataset(people)

    // val youngerDs = peopleDs.filter(p => p.age < 40)

    val resultRows = peopleDs.groupBy($"name").avg("age").collect()

    resultRows.foreach { row =>
      println(s"Name: ${row.get(0)} Avg. age: ${row.get(1)}")
    }
  }

}
