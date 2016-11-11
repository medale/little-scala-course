import scala.collection.immutable.StringOps


//where do all these nice String methods come from?

"abcdef".diff("abef")

"abc".permutations.toList

"Great for n-grams".sliding(2).toList

"No earth without art".slice(4,7)

//http://www.scala-lang.org/api/current/#scala.Predef$
val stringOpsFoo: StringOps =
	Predef.augmentString("foo")

import java.util.HashMap
import scala.language.implicitConversions

class FooMap extends HashMap[String,String]

val fooMap = new FooMap()
fooMap.put("foo","bar")
fooMap.get("baz")

class FooMapOps(fooMap: FooMap) {
	def getOpt(key: String): Option[String] = {
		if (fooMap.containsKey(key)) {
			Some(fooMap.get(key))
		} else {
			None
		}
	}
}

implicit def augmentFooMap(fooMap: FooMap): FooMapOps = {
	new FooMapOps(fooMap)
}

fooMap.getOpt("baz")


