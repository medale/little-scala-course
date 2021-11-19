package ecosystem

import com.typesafe.config.ConfigFactory

object TypesafeConfigLibraryExplorer {

  def main(args: Array[String]): Unit = {
    val configStr =
      """analytic {
				|   startTime = 2016103111,
				|   endTime = 2016103115
				|}
			""".stripMargin

    val appConfig = ConfigFactory.parseString(configStr)

    println(appConfig.hasPath("analytic.startTime"))
    println(appConfig.getString("analytic.startTime"))
  }

}
