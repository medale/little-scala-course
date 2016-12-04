import java.io.File

import scala.io.Source
import scala.sys.props

/**
	* Return a string that represents
	* the characters of 'in' sorted in alphabetical
	* order. So 'goose' becomes 'egoos'.
	*
	* @param in
	*/
def getAlphaSorted(in: String): String = {
	//treat string as collection and use natural ordering
	in.sorted
}

getAlphaSorted("goose")

//Must run ecosystem.Setup to copy file to home dir
val userHome = props("user.home")
//https://github.com/elasticdog/yawl
val dictFile = new File(userHome, "yawlWords.list")
val allEntries = Source.fromFile(dictFile).getLines().toList

//notice var!
//default value if key does not exist - empty list
var entryMap = Map[String, Set[String]]().withDefaultValue(Set())

//iterate of entries for side-effect
allEntries.foreach { e =>
	val value = e.toLowerCase()
	val key = getAlphaSorted(value)
	val currSet = entryMap(key)
	val newSet = currSet + value
	entryMap = entryMap + (key -> newSet)
}

val wordsWithAelst = entryMap("aelst")

//OK, what three letter words could we
//make from the tiles aelst?
val threeLetterCombos = "aelst".combinations(3).toList

//What's a tes?
//dictionary.com:
//(in philosophical Taoism) the virtue or power inherent
// in a person or thing existing in harmony with the Tao.
val threeLetterWordsFromAelst =
	threeLetterCombos.flatMap(entryMap)