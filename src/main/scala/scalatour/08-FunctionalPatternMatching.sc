def getObject(): Any = {
	//some call to Java
	1234
	//BigInt(100000000)
	//3.14
	//"foo"
}

val myObj : Any = getObject

myObj match {
	case 1234 => println(s"Exact match on 1234")
	case n: BigInt => println(s"BigInt: ${n}")
	case d: Double => println(s"Double: ${d}")
	case default => println(s"Default: ${default.getClass}")
}

val l = List(2,3,5,8)

l match {
	case List(1,x,y) => println(s"List 1 with two elems ${x}, ${y}")
	case 1 :: x2 :: xs => println(s"List 1 with second elem ${x2} and tail ${xs}")
	case x :: xs => println(s"Head was ${x}, tail is ${xs}")
	case Nil => println("List was empty")
}

l match {
	case Nil => println("empty")
}

