package lessonxx

import common.BaseTest

import java.nio.charset.StandardCharsets

import org.apache.commons.io.IOUtils

import upickle.default._

//check auto-skip of fields in object - has firstName, lastName, age
case class Person(firstName: String, age: Int)

class JsonTest extends BaseTest {

  var jsonStr: String = null

  override def beforeAll() = {
    val inputStream = getClass().getResourceAsStream("/data/people.json")
    jsonStr = IOUtils.toString(inputStream, StandardCharsets.UTF_8)
  }

  describe("UJson API") {
    it("should return array with correct person objects") {
      val json = ujson.read(jsonStr)
      implicit val personReadWriter: ReadWriter[Person] = macroRW[Person]

      val people = json.arr.map(v => read(v)(personReadWriter))

      people.size should be(2)

      people(0).firstName should be("John")
      people(0).age should be(42)

      people(1).firstName should be("Jane")
      people(1).age should be(29)
    }
  }

}
