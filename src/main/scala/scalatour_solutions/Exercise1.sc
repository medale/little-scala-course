//Add up the vowel values in the following string
//using different techniques
//aA = 1, eE = 2, iI = 3, oO = 4, uU = 5, all other values should be 0
//For input:  e=2,o=4,i=3,e=2,a=1,e=2,o=4,e=2,a=1 => 21
val input = "The only thing we have to fear"
val vowels = List('a','e','i','o','u')

//Step 1: write a function vowelValue that takes a character (Char)
//input and returns its vowel value:
/**
	* Should disregard whether letter is upper or
	* lower case. aA = 1, eE = 2, iI = 3, oO = 4, uU = 5,
	* all other values should be 0
	*
	* @param c
	* @return  value of char as described above
	*/
def getVowelValue(c: Char): Int = {
	val index = vowels.indexOf(c.toLower)
	if (index < 0) {
		0
	} else {
		index + 1
	}
}

//Step 2: Write a for comprehension that iterates over
//the input string and outputs an IndexedSeq[Int] with
//the vowel value for each char value
//                         T  h  e     o  n  l...
//IndexedSeq[Int] = Vector(0, 0, 2, 0, 4, 0, 0...
val values = for (c <- input) yield getVowelValue(c)

//Step 3:
//Add up all the ints in the sequence using the reduce
//method - http://www.scala-lang.org/api/current/scala/collection/IndexedSeq.html
values.reduce((a, b) => a + b)
values.reduce(_ + _)
values.sum

//Step 4:
//Use map to translate each character in input to its vowelValue
//filter to only retain non-zero values
//add up the non-zero values

input.map(getVowelValue).filter(_ != 0).sum

//Step 5:
//Use the flatMap higher-order function applied to the input string to
//output an IndexedSeq[Int] with only the non-zero values
//Hint: flatMap requires a function with the following signature:
//      f: (A) => GenTraversableOnce[B]
//Option has an implicit transformation to Iterable in its companion class
//http://www.scala-lang.org/api/current/scala/Option$.html and Iterable
//eventually extends GenTraversableOnce... so think Some/None
val values2 = input.flatMap{ c =>
	val vowelValue = getVowelValue(c)
	if (vowelValue > 0) {
		Some(vowelValue)
	} else {
		None
	}
}

values2.sum
