import scala.sys.process._
import scala.sys.env
import scala.sys.props

val externalCommand = "tokenGenerator"
//s"./${externalCommand}"!

s"chmod +x ${externalCommand}"!

val myToken = s"./${externalCommand}"!

env

env("PATH")

props("user.name")



