package tilarious

class WordGeneratorTest extends UnitTest {

  "generateAllTileCombos with empty string" must "return empty set" in {
    val dict = new Dictionary(List())
    val wordGen = new WordGenerator(dict)
    assertResult(Set()) {
      wordGen.generateAllTileCombinations("")
    }
  }

  "generateAllTileCombos with abcd" must "return all combos" in {
    val dict = new Dictionary(List())
    val wordGen = new WordGenerator(dict)

    val expectedCombos = Set("abcd", "abc", "abd", "acd", "bcd", "ab", "ac", "ad", "bc", "bd", "cd")

    assertResult(expectedCombos) {
      wordGen.generateAllTileCombinations("dabc")
    }
  }

  "generateAllTileCombos with aacd" must "return all combos" in {
    val dict = new Dictionary(List())
    val wordGen = new WordGenerator(dict)

    val expectedCombos = Set("aacd", "aac", "aad", "acd", "aa", "ac", "ad", "cd")

    assertResult(expectedCombos) {
      wordGen.generateAllTileCombinations("daac")
    }
  }

  "getAllWords with act" must "return expected" in {
    val expectedWords = Set("act", "cat", "ta", "at")
    val dict = new Dictionary(Dictionary.DefaultDictionaryWords)
    val wordGen = new WordGenerator(dict)
    assertResult(expectedWords) {
      wordGen.getAllWords("act")
    }
  }
}
