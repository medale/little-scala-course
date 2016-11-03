# Java Compatibility and extensions
* Scala compiler can infer data types - static typing with less typing
* Use underlying Java types (e.g. String)
* Expand through use of implicits (converts String to StringOps - Predef.augmentString)
* Predef - intArrayOps - ArrayOps[Int]

# Java <=> Scala
* Easily convert back and forth to leverage libraries

# Conciseness
* var/val, case class
* No semi-colons
* apply method
* toString, equals, hashCode, copy
* unapply method (Pattern matching)

# Scala Shell
```
:cp /home/medale/Downloads/config-1.3.1.jar

import com.typesafe.config.ConfigFactory

:paste
val configStr = """{ s3 :
  |{ inputBucket : my-input-bucket,
    |  outputBucket : my-output-bucket
    |}}""".stripMargin

val config = ConfigFactory.parseString(configStr)

val inputBucket = if (config.hasPath("s3.inputBucket")) {
      config.getString("s3.inputBucket")
} else {
        "my-input-bucket-default"
}
```

# Functional Programming
* declarative: expressions - operators, functions, constants (focus on what)
* imperative programming - statements that change program state (focus on how)
* first class: no restrictions on their use, anywhere in program, highest level
* can create and capture reference, pass around
* higher-order functions - function can take function args or return functions
* Pure functions - no side effects, eventually I/O is needed

# List
l.permutations, partition, groupBy
scala.io.StdIn.readLine
functional (immutable) data structures - no defensive copies
lazy evaluation

import sys.process._ - !
import java.util.{HashMap => JavaMap}

scala.sys.props env

Tour
* Scala Shells by the sea shore
* semicolons optional
* type after variable name (inference)
* val/var
* first-class functions
* no return - everything's a statement
* all objects - equality ==
* collections, range
* multiline strings with string interpolation (s,f,r)
* functional pattern matching
* options
* regular expressions
* mixin traits
* case classes
* scripting - process, sys
* Java interop
* Implicits
* collections to Spark
* actor concurrency with Akka
* Scala.js
