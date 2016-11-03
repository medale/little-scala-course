//recursive but not tail recursive
def factorial(n: BigInt): BigInt = {
	if (n == 1) {
		1
	} else {
		n * factorial(n-1)
	}
}

//Stack overflow for 10000
val b = BigInt("5000")
factorial(b)



















