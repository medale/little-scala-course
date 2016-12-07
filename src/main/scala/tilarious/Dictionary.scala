package tilarious

import java.io.{File, FileInputStream, IOException}
import java.nio.charset.StandardCharsets
import java.util.{List => JavaList}

import com.typesafe.scalalogging.LazyLogging
import org.apache.commons.io.IOUtils

import scala.sys.props
import scala.collection.JavaConverters._
import resource._

/**
  * Companion object - defined in same file as class.
  * Static convenience methods around word dictionary.
  */
object Dictionary extends LazyLogging {

  //run ecosystem.Setup to download/URL
  lazy val DefaultDictionaryFile = {
    val userHome = props("user.home")
    new File(userHome, "yawlWords.list")
  }

  lazy val DefaultDictionaryWords: List[String] = {
    var words: List[String] = null
    try {
      for (dictIn <- managed(new FileInputStream(DefaultDictionaryFile))) {
        val lines: JavaList[String] = IOUtils.readLines(dictIn, StandardCharsets.UTF_8)
        words = lines.asScala.toList
      }
    } catch {
      case e: IOException => {
        val errMsg = s"Unable to read ${DefaultDictionaryFile.getAbsolutePath}. Please download by running ecosystem.Setup"
        logger.error(errMsg)
        throw new IllegalStateException(errMsg)
      }
    }
    words
  }

  /**
    * Return the characters of the param string
    * sorted by alphabetical order.
    *
    * @param tiles
    * @return tiles in alpha sort
    */
  def getAlphaSorted(tiles: String): String = {
    tiles.sorted
  }
}

/**
  * A dictionary of allowable words.
  */
class Dictionary(words: List[String]) {

  //create a map with alphaSorted chars key and
  //all the words that can be made by exactly using
  //the chars in the key in any order
  private val wordMap: Map[String, Set[String]] = {
    var entryMap = Map[String, Set[String]]().withDefaultValue(Set())
    words.foreach { e =>
      val value = e.toLowerCase.trim
      val key = Dictionary.getAlphaSorted(value)
      val currSet = entryMap(key)
      val newSet = currSet + value
      entryMap = entryMap + (key -> newSet)
    }
    entryMap
  }

  /**
    * Get exact matches for param tiles.
    *
    * @param tiles
    * @return Set of words or empty Set if no matching words
    */
  def getWordsMatchingAllGivenTiles(tiles: String): Set[String] = {
    val key = Dictionary.getAlphaSorted(tiles.toLowerCase)
    wordMap(key)
  }
}
