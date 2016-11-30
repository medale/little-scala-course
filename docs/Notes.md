# Programming in Scala, 3rd Edition - Odersky et al.

* [Odersky et al., Programming in Scala, 3rd Edition](https://www.safaribooksonline.com/library/view/programming-in-scala/9780981531687/)

## Sweet - Syntactic Sugar

```
val myList = List(1,4,6)
val myList2 = List.apply(1,4,6)

//Companion object:
//List.apply[A](xs: A*)

val myChars = Array('a','b','c')
myChars(0) 
myChars(0) = 'd'

//Predef.charArrayOps: Array[Char] to ArrayOps[Char]
//ArrayOps[T] Trait:
//abstract def apply(idx: Int): T
//abstract def update(idx: Int, elem: T): Unit

myChars.apply(0)
myChars.update(0, 'd')
```

General language principles - done by compiler: apply/update

# Sweet infix notation
```
1 + 4
//Int class: abstract def +(x: Int): Int
//can drop . operator for infix method
//can drop () around single argument parameter
1.+(4)

//RichInt: def to(end: Int): Inclusive
1 to 10

1 to (100,2)
```

# Prefix operators
* Only +, -, !, and ~
```
-42
42.unary_-

val isEasy = true
!isEasy
isEasy.unary_!
```

# Postfix operators
* if side-effects - use (), otherwise none
```
val stack = scala.collection.mutable.Stack(1,2,3)
stack.pop()
> res1: Int = 1

stack
> res2: scala.collection.mutable.Stack[Int] = Stack(2, 3)

"CamelCase".toLowerCase
```

```
import java.util.{List => JavaList}
//class from type
val stringClass = classOf[String]

//class from object
"hello".getClass

```