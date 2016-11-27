import java.io.File

import scala.sys.process._
import scala.sys.env
import scala.sys.props
import scala.language.postfixOps

val homeDir = props("user.home")
val externalCommand = new File(homeDir, "tokenGenerator").getAbsolutePath
// s"${externalCommand}"!

//run command and get its status code
s"chmod +x ${externalCommand}"!

//run command and get its output
val myToken = s"${externalCommand}"!!

//pipe output of one command to another to a File
("ps -ef" #| "grep scala" #> new File(homeDir, "scala-procs.out"))!

val pythonExecOpt = "which python".lineStream_!.headOption

env

env("PATH")

props("user.name")



