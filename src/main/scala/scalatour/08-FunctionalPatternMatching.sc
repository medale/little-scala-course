def getObject(): Any = {
	//some call to Java
	1234
	//3.14
	//"foo"
}

val myObj: Any = getObject

val result: Long = myObj match {
	case 1234 => {
		println("Constant pattern 1234")
		1234
	}
	case i: Int => {
		println(s"Typed pattern int: ${i}")
		i
	}
	case d: Double => {
		println(s"Typed pattern Double: ${d}")
		math.round(d)
	}
	case default => //or wildcard _ (can't reference)
		println(s"Variable pattern: ${default.getClass}")
		0
}

//Sequence patterns
val l = List(1, 3, 5, 8)

l match {
	case List(1, x, y) => {
		println(s"1, then ${x}, ${y}")
	}
	case List(1, x, _*) => {
		println(s"second element ${x}")
	}
	case 1 :: x :: xs => {
		println(s"head 1, ${x} and tail ${xs}")
	}
	case x :: xs => {
		println(s"Head ${x}, tail ${xs}")
	}
	case Nil => println("List was empty")
}

//MatchError
//l match {
//	case Nil => println("empty")
//}

