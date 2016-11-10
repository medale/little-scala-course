//words from http://www.pangloss.com/seidel/shake_rule.html

val columnsStr = """artless             base-court          apple-john
bawdy               bat-fowling         baggage
	beslubbering        beef-witted         barnacle
	bootless            beetle-headed       bladder
	churlish            boil-brained        boar-pig
cockered            clapper-clawed      bugbear
	clouted             clay-brained        bum-bailey
craven              common-kissing      canker-blossom
currish             crook-pated         clack-dish
dankish             dismal-dreaming     clotpole
	dissembling         dizzy-eyed          coxcomb
	droning             doghearted          codpiece
errant              dread-bolted        death-token
fawning             earth-vexing        dewberry
	fobbing             elf-skinned         flap-dragon
froward             fat-kidneyed        flax-wench
frothy              fen-sucked          flirt-gill
gleeking            flap-mouthed        foot-licker
goatish             fly-bitten          fustilarian"""

val lines = columnsStr.split("\n")

val columns = lines.map { line =>
	val trimmed = line.trim
	val cols = trimmed.split("\\s+")
	cols
}

val col0s = columns.map(_(0))
val col1s = columns.map(_(1))
val col2s = columns.map(_(2))

val r = scala.util.Random

val insults = for (i <- 0 to 3) yield {
	val col0 = r.nextInt(col0s.size)
	val col1 = r.nextInt(col1s.size)
	val col2 = r.nextInt(col2s.size)
	s"Thou ${col0s(col0)} ${col1s(col1)} ${col2s(col2)}"
}

insults

//Or
val random0 = r.shuffle(col0s.toList)

random0(0)

//https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html
val d = 100
val s = f"${d}%05d"