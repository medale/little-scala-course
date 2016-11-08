def hasAtLeastThreeLetters(input: String): Boolean = {
	if ((input != null) && (!input.isEmpty)) {
		val letters = input.filter(c => c.isLetter)
		letters.size >= 3
	} else {
		false
	}
}

val testInputs = List(null, "", "lower", "Upper")

testInputs.map((input: String) =>
	hasAtLeastThreeLetters(input))

testInputs.map((input) =>
		hasAtLeastThreeLetters(input))

testInputs.map(input =>
		hasAtLeastThreeLetters(input))

testInputs.map(hasAtLeastThreeLetters(_))

testInputs.map(hasAtLeastThreeLetters)


val threeLs: String => Boolean = hasAtLeastThreeLetters

threeLs("abcd")

val vowels = List('a','e','i','o','u')

val removeVowels: (String) => String = { (str) =>
	str.filter(c => !vowels.contains(c))
}

removeVowels("wabbit")




val removeNonLetters: String => String = { str =>
	str.filter(c => c.isLetter)
}

removeNonLetters("wabbit247 !!!&*$#")

val transforms = List(removeVowels, removeNonLetters)

val original = "wabbit234s%$rule"
val transformed = transforms.foldLeft(original)((currString, f) => f(currString))




