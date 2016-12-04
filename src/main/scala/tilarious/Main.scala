package tilarious

/**
  * Make sure main method is defined on object or companion object.
  */
object Main {

  /**
    * Program entry point
    * sbt
    * > run tca
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {
    val myDict = new Dictionary(Dictionary.DefaultDictionaryWords)
    val wordGen = new WordGenerator(myDict)

    if (args.length > 0) {
      val tiles = args(0)
      val words = wordGen.getAllWords(tiles)
      println(s"Words generated from ${tiles} were:")
      println(words.mkString("\n"))
    } else {
      println("Main was run without args")
    }
  }
}
