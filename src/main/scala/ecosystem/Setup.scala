package ecosystem

import java.io.{File, FileOutputStream}
import java.nio.charset.StandardCharsets

import com.typesafe.scalalogging.LazyLogging
import org.apache.commons.io.IOUtils

import scala.io.Source
import scala.util.Using
import scala.sys.props

/**
 * Worksheets execute from different locations depending on OS.
 * So we copy everything to the user's home directory and then
 * explicity load resources from there.
 */
object Setup extends LazyLogging {

  def main(args: Array[String]): Unit = {
    val homeDir = props("user.home")
    copyResourcesToUserHome(homeDir)
    downloadYawl(homeDir)
  }

  private def copyResourcesToUserHome(homeDir: String) = {
    val resources = List("/scripts/tokenGenerator")
    resources.foreach { resource =>
      val in = getClass.getResourceAsStream(resource)
      val lastSlashIndex = resource.lastIndexOf("/")
      val fileName = resource.substring(lastSlashIndex + 1)
      val outputFile = new File(homeDir, fileName)
      Using(new FileOutputStream(outputFile)) { out =>
        IOUtils.copy(in, out)
        logger.debug(s"Wrote ${resource} to ${outputFile.getAbsolutePath}")
      }
    }
  }

  def downloadYawl(homeDir: String) = {
    val yawlUrl = "https://raw.githubusercontent.com/elasticdog/yawl/master/yawl-0.3.2.03/word.list"
    val yawl = Source.fromURL(yawlUrl, StandardCharsets.UTF_8.toString).mkString
    val wordListFile = new File(homeDir, "yawlWords.list")
    Using(new FileOutputStream(wordListFile)) { yawlOut =>
      IOUtils.write(yawl, yawlOut, StandardCharsets.UTF_8)
      logger.debug(s"Wrote yawl url content to ${wordListFile.getAbsolutePath}")
    }
  }

}
