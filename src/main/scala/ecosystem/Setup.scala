package ecosystem

import java.io.{File, FileOutputStream}

import org.apache.commons.io.IOUtils

import scala.sys.props
/**
	* Worksheets set current working directory to the user's home
	* directory. We want to copy american-english dictionary there.
	*/
object Setup {

	def main(args: Array[String]): Unit = {
		val homeDir = props("user.home")
		val resources = List("/dictionary/american-english", "/scripts/tokenGenerator")
		resources.foreach { resource =>
			val in = getClass.getResourceAsStream(resource)
			val lastSlashIndex = resource.lastIndexOf("/")
			val fileName = resource.substring(lastSlashIndex + 1)
			val outputFile = new File(homeDir, fileName)
			val out = new FileOutputStream(outputFile)
			try {
				IOUtils.copy(in, out)
			} catch {
				case e: Exception => println(s"Unable to copy to ${outputFile} due to ${e}")
			} finally {
				in.close()
				out.close()
			}
		}
	}
}
