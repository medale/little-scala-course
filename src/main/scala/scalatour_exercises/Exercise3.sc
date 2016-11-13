//Given the following triple quoted paragraph from Robert
//Glass' Facts and Fallacies of Software Engineering book
//let's do the big data canonical word count exercise just
//using handy methods and data structures from Scala's
//collection library.
val paragraph = """Robert Glass, Addison-Wesley, 2002,
  |Facts and Fallacies of Software Engineering
	|Fact 22:
	|For every 25 percent increase in problem complexity,
	|there is a 100 percent increase in complexity of the
	|software solution. That’s not a condition to try to
	|change (even though reducing complexity is always a
	|desirable thing to do); that’s just the way it is.
	""".stripMargin

// 1. Let's tokenize the paragraph into lower case words
// using split to break the paragraph into lines and
// then split each line on whitespace to tokenize out
// the words. The split method is from java.lang.String and
// gives us arrays of String. The final "words" val should
// be an Array[String] not Array[Array[String]].
val lines = ???
val words: Array[String] = ???

println(words.mkString(", "))

// 2. This leaves us with tokens like "Glass,","2002,", ... "22:"
// Let's first create an array lowerWords that contains toLowerCase
// versions of the original Strings.
val lowerWords = ???

// 3. Let's remove all non-letter characters (see hint below
// if desired). Write the following removeNonLetters function.
// It should return Some(word) if the filter resulted in a
// non-empty String or None if the filter removed all letters.
def removeNonLetters(word: String): Option[String] = {
	None
}

val tests = List(("glass,", Some("glass")), ("2002,", None))

//Make sure you see a true, true output!
tests.foreach { case (input, expected) =>
  val result = removeNonLetters(input)
	println(result == expected)
}

// 4. Now let's use our removeNonLetters method to
// clean each entry in lowerWords and create
// cleanLowerWords, which should have less entries
// than lowerWords
val cleanLowerWords = ???

// 5. Now we use an immutable map (hence the var) to compute
// the count for each word.
// The default Map is scala.collection.immutable.Map.
// http://www.scala-lang.org/api/current/scala/collection/immutable/Map.html
// Assign updated maps to the var wordCountMap.
var wordCountMap: Map[String, Int] = ???


// 6. Do the word count without var using the groupBy method
// and mapValues on the result.
val wordToWordsMap: Map[String, Array[String]] = ???

val wordCountMap2 = ???

// We will later use Spark to do word count at scale.





//Hints
// 3. We can treat a String as a collection of chars with
// filter and there's an .isLetter method on chars.
// 5. use + (key -> value) to create a new map with new value (same key replaces
// previous value) or define val newEntry = (key, value) and then
// add to map capturing newly created map reference.