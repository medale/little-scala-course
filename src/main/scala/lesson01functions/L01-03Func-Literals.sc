val incr: (BigInt) => BigInt = {
	n => n + 1
}

incr(10000)


val myPow: (Int, Int) => Int = {
	(a, b) => Math.pow(a, b).toInt
}

myPow(2, 3)

myPow(3, 2)


val myPow2: Function2[Int, Int, Int] = {
	(a, b) => Math.pow(a, b).toInt
}

myPow2(3, 2)