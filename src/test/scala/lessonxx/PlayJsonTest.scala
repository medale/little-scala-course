package lessonxx

import java.nio.charset.StandardCharsets

import org.apache.commons.io.IOUtils
import org.scalatest.BeforeAndAfterAll
import org.scalatest.FunSpec
import org.scalatest.Matchers
import play.api.libs.json.JsValue
import play.api.libs.json.Json

//check auto-skip of fields in object - has firstName, lastName, age
case class Person(firstName: String, age: Int)

class PlayJsonTest extends FunSpec with Matchers with BeforeAndAfterAll {

  var jsonStr: String = null

  override def beforeAll() = {
    val inputStream = getClass().getResourceAsStream("/data/people.json")
    jsonStr = IOUtils.toString(inputStream, StandardCharsets.UTF_8)
  }

  describe("Play Json API") {
    it("should return array with correct person objects") {
      val json: JsValue = Json.parse(jsonStr)
      implicit val personReader = Json.reads[Person]

      val people = json.as[List[Person]]

      people.size should be(2)

      people(0).firstName should be("John")
      people(0).age should be(42)

      people(1).firstName should be("Jane")
      people(1).age should be(29)
    }
  }

}
