import scala.sys.process._
import scala.sys.env
import scala.sys.props
import scala.language.postfixOps

val externalCommand = "tokenGenerator"
//s"./${externalCommand}"!

//run command and get its status code
s"chmod +x ${externalCommand}"!

//run command and get its output
val myToken = s"./${externalCommand}"!!

env

env("PATH")

props("user.name")



