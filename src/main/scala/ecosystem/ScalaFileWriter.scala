package ecosystem 

import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.charset.StandardCharsets
import java.nio.file.OpenOption
import java.nio.file.StandardOpenOption

/**
  * Utility to write a String or array of bytes to an output file . Will create necessary directories for output
  * file if they don't exist.
  * Adapted from Stackoverflow: https://stackoverflow.com/questions/4604237/how-to-write-to-a-file-in-scala
  *
  * Sample use:
  *  val outputString = "wrong=mistaken"
  *  val path = Paths.get("synonyms.txt")
  *  ScalaFileWriter.write(path, outputString)
  */
object ScalaFileWriter {

  val CreateTruncateOpenOption = Seq(StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)

  def writeBytes(destinationFile: Path,
                 fileContent: Array[Byte],
                 openOptions: Seq[OpenOption] = CreateTruncateOpenOption): Either[Exception, Path] = {
    try {
      val parentPath = destinationFile.getParent
      if (parentPath != null) {
        Files.createDirectories(parentPath)
      }
      // Return the path to the destinationFile if the write is successful
      Right(Files.write(destinationFile, fileContent, openOptions: _*))
    } catch {
      case exception: Exception => Left(exception)
    }
  }

  def writeString(destinationFile: Path,
            fileContent: String,
            encoding: Charset = StandardCharsets.UTF_8,
            openOptions: Seq[OpenOption] = CreateTruncateOpenOption): Either[Exception, Path] = {
    writeBytes(destinationFile, fileContent.getBytes(encoding), openOptions)
  }
}
