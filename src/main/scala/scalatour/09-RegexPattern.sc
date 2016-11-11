val HostPortRegex =
	"""http://([\w.]+):(\d+)""".r

val url = "http://es.host.com:9200"
val HostPortRegex(host,port) = url

val hostPortOpt = url match {
	case HostPortRegex(host, port) =>
		Some((host, port.toInt))
	case _ => None
}



