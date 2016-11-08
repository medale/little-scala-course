val a : Array[Int] = Array(1,3,7,9)

a(0)

a.mkString(",")


val l = List("When", "shall", "we", "three")

val longWords = l.filter(s => s.length > 4)

l

val lowers = l.map(w => w.toLowerCase)

val perms = lowers.map(w => w.permutations)
perms.flatten

lowers.flatMap(w => w.permutations)

//how many letters in our list?
val lengths = l.map(w => w.length)
lengths.reduce((acc, i) => acc + i)
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


















val wordLengthTuples = l.map(s => (s, s.length))

val lengthMap = wordLengthTuples.groupBy { case (word, length) => length }

lengthMap(5)