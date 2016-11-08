val portOpt: Option[Int] = Some(5123)
val port2Opt: Option[Int] = None

portOpt.get

//port2Opt.get

port2Opt.getOrElse(3306)

portOpt.foreach(port => println(s"opening ${port}"))

Option(null)