% The Scala programming ecosystem
% Leveraging functional, OO, libraries and frameworks
% Markus Dale, 2016

# Scala - The Bad and Ugly
![](graphics/garbage-can-1260832_1280.jpg)

# Scala - The Good
![](graphics/dom-1707634_960_720.jpg)

# The Scala Programming Language
* Martin Odersky, EPFL, Switzerland
     * Worked on javac (1.3)
     * Java Generics
* Lightbend (formerly Typesafe)
* Multi-paradigm language
     * Functional and Object-Oriented
* Statically typed
* Scalable language - script to large program
* Stretch your mind - functions and immutability


# Sca\(lable\) la\(nguage\)

* Apache Kafka (LinkedIn)
* Apache Spark (Databricks)
* Finagle (Twitter)
* Akka (Lightbend)
* Lucid Software - scala.js presentation
* Play Web Framework
     * [Lichess Online Chess](https://en.lichess.org/)
* Lightbend customers: Walmart, Verizon, Twitter, LinkedIn, Coursera, The Guardian, Airbnb...


# Scala to Java bytecode
* Leverage Java Virtual Machine (JVM)
     * Over 20 years of optimizations
     * Java Interpreter and Just-in-time (JIT) compilers
     * Portability and Security
     * Ever-evolving garbage collectors
* Full interoperability with Java and Java libraries

# Exploration - Scala Shell and Worksheet
![](graphics/snail-160313_960_720.png)

# Scala Tour
* Conciseness
* Mixed Paradigms
     * Object Oriented
     * Functional 
* Options, Collections
* Functional Pattern Matching
* Implicits
* Spark
     
# scalatour/01-NoSemicolons
* optional semicolons
* type inference
* vals vs. vars
* higher-order functions on collections
 
# scalatour/02-Functions
* Use def keyword to define function/method
* arg type declaration after variable name
* return type
* body of function
* expressions vs. statements - last expression is returned
* function literals
 
# scalatour/03-AllObjects
* Everything is an object (but might translate to Java primitive)
* Use == for testing equality (eq object reference)
 
# scalatour/04-Tuples
* Most useful as pair/two-tuple (up to 22)
* Strongly typed for each position
* access via _1, _2 methods or pattern matching
 
# scalatour/05-Options
* Avoid null and NullPointerException (NPE)
* Option\[T\] - Some\[T\] or None
     * sealed abstract class Option, class Some, object None
* Options act like a collection     
 
# scalatour/06-Collections
* Array
* Immutable, mutable data structures
     * List
     * Higher-order functions
          * filter, map, flatMap, reduce, fold... 
     * Map   
     * Set, Vector...
    
# Scala Docs
![](graphics/scala-docs.png)

# scalatour/07-MultilineStrings
* Triple quotes
* substitution (f for printf formatting)

# scalatour/08-FunctionalPatternMatching
* match construct
* match by type, structure
* default case or MatchError

# scalatour/09-ParsingConfig
* Match on regular expressions
* Go Options

# scalatour/10-ClassesTraitsMixins
* class - constructor/body
* constructor args - val, var, no modifier
* traits

# scalatour/11-CaseClasses
* provide val accessors
* apply/unapply, hashCode, toString
* pattern matching

# scalatour/12-Scripting
* In the small
* sys.process
* sys.env
* sys.props

# scalatour/13-JavaInterop
* to/from Java/Scala collections
* BeanProperty for getters/setters

# scalatour/14-Implicits
* Use sparingly!
* Powerful way to extend closed classes

# scalatour/Spark15
* Implemented in Scala
* Powerful functional primitives for scalable cluster processing

# Resources
* Coursera/EPFL [Functional Programming in Scala Specialization](https://www.coursera.org/specializations/scala)
* [Odersky et al., Programming in Scala, 3rd Edition](https://www.safaribooksonline.com/library/view/programming-in-scala/9780981531687/)
* [Payne, Wampler, Programming Scala, 2nd Edition](https://www.safaribooksonline.com/library/view/programming-scala-2nd/9781491950135/)
* [Alexander, Scala Cookbook](https://www.safaribooksonline.com/library/view/scala-cookbook/9781449340292/)
* [Chiusano, Bjarnason, Functional Programming in Scala](https://www.safaribooksonline.com/library/view/functional-programming-in/9781617290657/)
* [Twitter Scala School](http://twitter.github.io/scala_school/)
