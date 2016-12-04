val myArray = Array('z','d','f','a')

//create new, sorted array
//def sorted[Char](implicit ord: Ordering[Char])
//Char -> RichChar-IntegralProxy-ScalaWholeNumberProxy-
// ScalaNumberProxy-OrderedProxy-Ordered
//implicit from Ordered to Ordering
val sortedArray: Array[Char] = myArray.sorted

val revArray = myArray.sorted(Ordering.Char.reverse)

myArray.mkString(",")
sortedArray.mkString(",")
revArray.mkString(",")