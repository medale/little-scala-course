def getCanonical(e: String): String = {
	//treat string as collection and use natural ordering
	e.sorted
}

getCanonical("defaab")

//Must run ecosystem.Setup to copy file to home dir
val allEntries = io.Source.fromFile("american-english").getLines().toList
allEntries.size

val entriesOfInterest = allEntries.filter(_.length <= 6).filterNot(_.contains("'"))
entriesOfInterest.size

//notice var!
var entryMap = Map[String, List[String]]().withDefaultValue(Nil)

entriesOfInterest.foreach { e =>
	val value = e.toLowerCase()
	val key = getCanonical(value)
	val currList = entryMap(key)
	val newList = value :: currList
	entryMap = entryMap + (key -> newList)
}

println(entryMap.mkString(","))

val mappings = entryMap.toList

val ordered = mappings.sortWith { case ((_, l1),(_,l2)) => l1.length > l2.length }
println(ordered.take(2).mkString("Canonical,List(words)\n","\n",""))

val l = List("ACT", "ADEZ", "BET", "LOOT", "ACRS").map(_.toLowerCase())

val wordsFromList = l.flatMap { w =>
	val canonical = getCanonical(w)
	if (entryMap.contains(canonical)) {
		entryMap(canonical)
	} else {
		Nil
	}
}

println(wordsFromList.mkString(","))