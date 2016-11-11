val a : Array[Int] = Array(1,3,7,9)
//val b = Array.apply(1,3,7,9)

a(0)
//b.apply(0)

a(0) = 5
//b.update(0, 5)

a.mkString(",")

val ws = List("When", "shall", "we", "three")

val ws2 = "When" :: "shall" :: Nil

val longWords = ws.filter(s => s.length > 4)
ws
val lowers = ws.map(_.toLowerCase)

"abc".permutations
"abc".permutations.toList

val perms = lowers.map(_.permutations)
perms.flatten

lowers.flatMap(_.permutations)

//how many letters in our list?
val lengths = ws.map(_.length)
lengths.reduce(_ + _)
lengths.sum



var transMap = Map("when" -> "wann",
	"shall" -> "sollen", "we" -> "wir")


val entryTuple1 = ("three" -> "drei")
val entryTuple2 = ("meet", "treffen")

transMap = transMap + entryTuple1
transMap = transMap + entryTuple2

transMap("when")
//transMap("who")

transMap.get("when")
transMap.get("who")

val whenGerman = if (transMap.contains("when")) {
	transMap("when")
} else {
	"unbekannt"
}

val whenGerman2 = transMap.getOrElse("when", "unbekannt")

val transMap2 = transMap.withDefaultValue("unbekannt")

transMap2("when")
transMap2("who")





val wordLengthTuples = ws.map(s => (s, s.length))

val lengthMap = wordLengthTuples.groupBy { case (word, length) => length }

lengthMap(5)