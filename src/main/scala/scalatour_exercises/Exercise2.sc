//We are running an hourly analytic that logs its runtime via
//log4j. We want to parse the runtime entries to determine
//trends and alert of anomalies. We want to parse
//the runtime out of the relevant log lines. Develop code
// using the following logEntry as a sample of what each entry looks like.
val logEntry =
"2016/11/12 15:12:12 INFO spark.Driver$: Total Runtime: 0 hours : 11 min : 08 sec"

// 1. Our first task is to create a case class Runtime that
// takes hours, min and sec integer values. To ensure that we
// have valid values the case class body should call the
// validate method in the Runtime companion singleton
// object given below (validate is like a static method in Java)
// to make sure we only generate valid Runtime objects.
object Runtime {
	def validate(hours: Int, min: Int, sec: Int): Unit = {
		if (hours < 0 || min < 0 || sec < 0) {
			throw new IllegalArgumentException("All parameters must be >= to 0")
		}
		if (min > 59) {
			val errMsg = "min must be <= 59 (add hour for every 60 min)"
			throw new IllegalArgumentException(errMsg)
		}
		if (sec > 59) {
			val errMsg = "sec must be <= 59 (add min for every 60 sec)"
			throw new IllegalArgumentException(errMsg)
		}
	}
}

//case class Runtime here

// 2. Create a Scala regex expression to match on runtime log entries
// The expression should have digit capture groups for hours, min and sec
// values (3 capture groups).
val RuntimeRegex = "implement".r

//Test your regex against logEntry if you get
//scala.MatchError you need to tweak regex.
val RuntimeRegex(hours, min, sec) = logEntry

// 3. Clearly the above approach is very brittle in
// case of bad entries so let's write a function that
// uses a pattern match clause on a logEntry. The
// getRuntime function takes a logEntry String argument
// and returns an Either[String,Runtime] as the result of the
// pattern match.
// See http://www.scala-lang.org/api/current/scala/util/Either.html
//
// If we have a good match, return Right(Runtime) otherwise
// (failure) Left("Non-runtime: <logEntry>") [use string interpolation!].

def getRuntime(logEntry: String): Either[String, Runtime] = {
	Left("implement me")
}

// 4. Run your getRuntime method against the following
// three test cases. Results should be:
// Right(Runtime(0,11,8))
// Left(min must be <= 59 (add hour for every 60 min))
// Left(Non-runtime: bad line)
val badMinTon =
 "2016/11/12 15:12:12 INFO spark.Driver$: Total Runtime: 0 hours : 66 min : 08 sec"
val tests = List(logEntry, badMinTon, "bad line")

tests.foreach { entry =>
	println(getRuntime(entry))
}

