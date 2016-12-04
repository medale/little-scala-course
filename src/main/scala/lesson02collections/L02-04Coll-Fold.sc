//def reduce[A1 >: A](op: (A1, A1) ⇒ A1): A1
val l = 1 to 4
l.reduce((x,y) => x * y)

//def foldLeft[B](z: B)(op: (B, A) ⇒ B): B
val words = List("The","Great","Gatsby")
val zeroVal: Map[Char,Long] = Map().withDefaultValue(0)
val op: (Map[Char,Long], String) => Map[Char,Long] = {
  (map,word) =>
    var newCharMap = map
    val lower = word.toLowerCase
    lower.foreach { c =>
      val oldCount = newCharMap(c)
      val newCount = oldCount + 1
      newCharMap = newCharMap + (c -> newCount)
    }
    newCharMap
}

val countTotal = words.foldLeft(zeroVal)(op)