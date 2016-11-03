val input = "afed-123-ghi-45-67"


//if we did not have RichChar.isDigit...
def isDigit(c : Char): Boolean = {
	('0' to '9').contains(c)
}


var digits = ""
for (c <- input) {
	if (isDigit(c)) digits += c
}

digits



val digits2 = for(c <- input if isDigit(c)) yield c


