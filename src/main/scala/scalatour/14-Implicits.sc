import scala.collection.immutable.StringOps
import java.util.HashMap

//where do all these nice String methods come from?

"abcdef".diff("abef")

"abc".permutations.toList

"Great for n-grams".sliding(2).toList

"No earth without art".slice(4,7)

//http://www.scala-lang.org/api/current/#scala.Predef$
val stringOpsFoo: StringOps =
	Predef.augmentString("foo")


class FooMap extends HashMap[String,String]

val fooMap = new FooMap()
fooMap.put("foo","bar")

fooMap.get("foo")
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

val fooMap2 = new FooMap()
fooMap2.put("foo","bar")

fooMap.getOpt("foo")

fooMap.getOpt("baz")


