def toPower(exp: Int) = { (base: Int) =>
	Math.pow(base, exp).toInt
}

val squared = toPower(2)

squared(2)

squared(4)

val cubed = toPower(3)

cubed(2)

cubed(3)
