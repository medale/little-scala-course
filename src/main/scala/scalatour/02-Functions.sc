def startsWithUpperCase(input: String): Boolean = {
	(input != null) &&
		(!input.isEmpty) &&
		(input(0).isUpper)
}

def containsAtLeastThreeLetters(input: String): Boolean = {
	if ((input != null) && (!input.isEmpty)) {
		val letters = input.filter(c => c.isLetter)
		letters.size >= 3
	} else {
		false
	}
}

val testInputs = List(null, "", "lower", "Upper")

testInputs.map(input =>
	(startsWithUpperCase(input),
		containsAtLeastThreeLetters(input)))


val addBinary: (Int, Int) => String = { (a, b) =>
	(a + b).toBinaryString
}

addBinary(8,7)

val vowels = List('a','e','i','o','u')

val removeVowels: String => String = { str =>
	str.filter(c => !vowels.contains(c))
}

val removeNonLetters: String => String = { str =>
	str.filter(c => c.isLetter)
}

removeVowels("wabbit")

removeNonLetters("wabbit247 !!!&*$#")




val transforms = List(removeVowels, removeNonLetters)

val original = "wabbit234s%$rule"
val transformed = transforms.foldLeft(original)((currString, f) => f(currString))




