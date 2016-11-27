import java.io.File

import scala.annotation.tailrec
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

allEntries.size

val entriesOfInterest = allEntries.
	filter(_.length <= 7)

entriesOfInterest.size

//notice var!
//default value if key does not exist - empty list
var entryMap = Map[String, Set[String]]().withDefaultValue(Set())

//iterate of entries for side-effect
entriesOfInterest.foreach { e =>
	val value = e.toLowerCase()
	val key = getAlphaSorted(value)
	val currSet = entryMap(key)
	val newSet = currSet + value
	entryMap = entryMap + (key -> newSet)
}

val wordsWithAelst = entryMap("aelst")

"aabc".combinations(3).toList