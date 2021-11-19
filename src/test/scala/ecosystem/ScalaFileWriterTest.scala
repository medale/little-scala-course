package ecosystem

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import org.scalatest.BeforeAndAfter
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import scala.jdk.CollectionConverters._

/**
 *
  */
class ScalaFileWriterTest extends AnyFunSpec with BeforeAndAfter with Matchers {

  var baseDir: Path = null

  before {
    baseDir = Files.createTempDirectory("scalawritertest")
  }

  after {
    Files.delete(baseDir)
  }

  describe("writeString") {
    it("should return same string when directory exists") {
      val outString = "Hello, writer world!"
      val filePath = Paths.get(baseDir.toString, "out.txt")
      val resultEither = ScalaFileWriter.writeString(filePath, outString)

      resultEither match {
        case Right(path) => path === filePath
        case Left(ex)    => fail(s"Test failed due to $ex")
      }

      val lines = Files.readAllLines(filePath).asScala
      lines.size === 1
      lines(0) === outString

      Files.deleteIfExists(filePath)
    }

    it("should return same string and create parent directory") {
      val outString = "Hello, writer world!"
      val filePath = Paths.get(baseDir.toString, "myParent", "out.txt")
      val resultEither = ScalaFileWriter.writeString(filePath, outString)

      resultEither match {
        case Right(path) => path === filePath
        case Left(ex)    => fail(s"Test failed due to $ex")
      }

      val lines = Files.readAllLines(filePath).asScala
      lines.size === 1
      lines(0) === outString

      //delete file and extra parent directory
      Files.deleteIfExists(filePath)
      Files.deleteIfExists(filePath.getParent)
    }
  }
}
