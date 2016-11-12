import scala.collection.immutable.StringOps


//where do all these nice String methods come from?

"abcdef".diff("abef")

"abc".permutations.toList

"bi-grams".sliding(2).toList

"No earth without art".slice(4,7)

//http://www.scala-lang.org/api/current/#scala.Predef$
val stringOpsFoo: StringOps =
	Predef.augmentString("foo")

import java.util.{Map => JavaMap}
import java.util.HashMap
import scala.language.implicitConversions

val map = new HashMap[String,String]()
map.put("foo","bar")
map.get("baz")

class JavaMapOps[K,V](map: JavaMap[K,V]) {
	def getOpt(key: K): Option[V] = {
		if (map.containsKey(key)) {
			Some(map.get(key))
		} else {
			None
		}
	}
}

implicit def augmentJavaMap[K,V](map: JavaMap[K,V]): JavaMapOps[K,V] = {
	new JavaMapOps(map)
}

map.getOpt("foo")
map.getOpt("baz")


