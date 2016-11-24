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
//enable2k.txt from http://www.morewords.com/enable2k.txt
val dictFile = new File(userHome, "enable2k.txt")
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
"ab".combinations(1).toList
"c".combinations(0).toList

def getAllWords(tiles: String): List[String] = {

	def getExactMatches(sortedMatchTiles: String): Set[String] = {
		entryMap(sortedMatchTiles)
	}

	@tailrec def getWordsForCombos(tileCombos: List[String],
												wordsSoFar: Set[String]): Set[String] = {
		tileCombos match {
			case headCombo :: tailCombos => {
				val wordsWithHeadCombo =
					getExactMatches(headCombo) ++ wordsSoFar
				getWordsForCombos(tailCombos, wordsWithHeadCombo)
			}
			case Nil => wordsSoFar
		}
	}

	def loop(tileCombos: List[String],
					 wordsSoFar: Set[String]
					): Set[String] = {
		tileCombos match {
			case headCombo :: tailCombos => {
				val oneTileShorterCombos = headCombo.combinations(headCombo.length - 1).toList
				val wordsForOneTileShorterCombos =
					getWordsForCombos(oneTileShorterCombos, Set())
				val newTileCombos = oneTileShorterCombos ++ tailCombos
				loop(newTileCombos, wordsForOneTileShorterCombos ++ wordsSoFar)
			}
			case Nil => wordsSoFar
		}
	}

	val sortedTiles = getAlphaSorted(tiles.toLowerCase)
	val wordsSoFar = getExactMatches(sortedTiles)
	loop(List(sortedTiles), wordsSoFar).toList.sortWith((s1,s2) => s1.length > s2.length)
}

println(getAllWords("eimvo").mkString("\n"))