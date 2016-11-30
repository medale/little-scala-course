package tilarious

import org.scalatest.FlatSpec

class DictionaryTest extends FlatSpec {

  "Default Dictionary words" must "have size > 0" in {
    assume(Dictionary.DefaultDictionaryFile.exists() &&
      Dictionary.DefaultDictionaryFile.canRead)
    assert(Dictionary.DefaultDictionaryWords.size > 0)
  }

  "Default dict" must "return expected words" in {
    assume(Dictionary.DefaultDictionaryFile.exists() &&
      Dictionary.DefaultDictionaryFile.canRead)
    val wordDict = new Dictionary(Dictionary.DefaultDictionaryWords)
    val expectedWords = Set("marle", "realm", "lamer")
    assertResult(expectedWords) {
      wordDict.getWordsMatchingAllGivenTiles("maelr")
    }
  }

  "Default dict" must "return empty set for tiles with no associated words" in {
    assume(Dictionary.DefaultDictionaryFile.exists() &&
      Dictionary.DefaultDictionaryFile.canRead)
    val wordDict = new Dictionary(Dictionary.DefaultDictionaryWords)
    assertResult(Set()) {
      wordDict.getWordsMatchingAllGivenTiles("xyz")
    }
  }

}
