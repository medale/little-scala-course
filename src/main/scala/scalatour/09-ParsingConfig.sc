val portRegex = """port=(\d+)""".r

def getPortOpt(config: String): Option[Int] = {

	def loop(remainingLines: List[String]): Option[Int] = {
		remainingLines match {
			case Nil => None
			case x :: xs => {
				x match {
					case portRegex(port) => Some(port.toInt)
					case default => loop(xs)
				}
			}
		}
	}
	val lines = config.split("\n").toList
	loop(lines)
}

val configStr = """host=myhost.com
	|port=3306
  |username=foo""".stripMargin

val portOpt = getPortOpt(configStr)

val badConfig = """foo=bar"""

val noPortOpt = getPortOpt(badConfig)