//http://www.scala-lang.org/api/current/#scala.collection.immutable.List
//List object apply method
val l = List("ACT", "ADEZ", "BET", "LOOT", "ACRS")

val threes = l.filter(_.length == 3)

val lengths = l.map(s => s.length)
lengths.reduce(_ + _)
lengths.sum

val (shorter, longer) = l.partition(_.length < 4)

//prepend or cons
val l2 = 3 :: 4 :: 7 :: Nil

val letters = List("a","d","u","n")
val permutations = letters.permutations.toList
val words = permutations.map { l1 => l1.mkString}
val sortedWords = words.sorted

words.sorted(Ordering.String.reverse)


