//functions that take or return functions

def isEven(i: Int): Boolean = {
	i % 2 == 0
}

val myRange = (1 to 100)

myRange.filter(i => isEven(i))

//syntactic sugar 1
myRange.filter(isEven)

//function literal
myRange.filter ( i => i % 2 == 0)

//syntactic sugar 2: function literal with placeholder
myRange.filter(_ % 2 == 0)

val myOddRange = (1 to 100 by 2)