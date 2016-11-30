package tilarious

import scala.annotation.tailrec

/**
  * WordGenerator companion object
  * Define constants.
  */
object WordGenerator {
  val MinimumTileCount = 2
}

/**
  * Generate words according to a dictionary
  * of legal words.
  */
class WordGenerator(dictionary: Dictionary) {

  /**
    * Return all words that can be formed with the given
    * tiles for the given dictionary.
    *
    * @param tiles
    * @return
    */
  def getAllWords(tiles: String): Set[String] = {
    val allTileCombos = generateAllTileCombinations(tiles)
    allTileCombos.flatMap(dictionary.getWordsMatchingAllGivenTiles)
  }

  private[tilarious] def generateAllTileCombinations(tiles: String): Set[String] = {

    @tailrec def loop(newCombos: List[String],
                      existingCombos: Set[String]): Set[String] = {

      newCombos match {
        case headCombo :: tailCombos => {
          val newComboLength = headCombo.length - 1
          val newExistingCombos = existingCombos + headCombo
          if (newComboLength >= WordGenerator.MinimumTileCount) {
            val oneTileShorterCombos =
              headCombo.combinations(newComboLength).toList
            val newTileCombos = oneTileShorterCombos ++ tailCombos
            loop(newTileCombos, newExistingCombos)
          } else {
            loop(tailCombos, newExistingCombos)
          }
        }
        case Nil => existingCombos
      }
    }

    if (!tiles.isEmpty) {
      val lowerTiles = tiles.toLowerCase
      val alphaSortedTiles = Dictionary.getAlphaSorted(lowerTiles)
      loop(List(alphaSortedTiles), Set())
    } else {
      Set()
    }
  }
}
