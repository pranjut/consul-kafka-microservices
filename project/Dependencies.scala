import sbt._

object Dependencies {

  val scala = "2.11.6"

  val resolvers = DefaultOptions.resolvers(snapshot = true) ++ Seq(
    "scalaz-releases" at "http://dl.bintray.com/scalaz/releases"
  )

  object playframework {
    val version = play.core.PlayVersion.current

    val jdbc = "com.typesafe.play" %% "play-jdbc" % version
    val cache = "com.typesafe.play" %% "play-cache" % version
    val ws = "com.typesafe.play" %% "play-ws" % version
    val json = "com.typesafe.play" %% "play-json" % version
    val specs2 = "com.typesafe.play" %% "play-specs2" % version % "test"
  }


  val scalatest = "org.scalatest" %% "scalatest" % "2.2.4" % "test"
  val consulClient = "com.codacy" %% "scala-consul" % "1.1.0"
  val kafka  = "org.apache.kafka" %% "kafka" % "0.9.0.1"

  val playDependencies: Seq[ModuleID] = Seq(
    playframework.jdbc,
    playframework.cache,
    playframework.ws,
    playframework.json,
    playframework.specs2
  )

  val commonModuleDependencies: Seq[ModuleID] = playDependencies ++ Seq(kafka, consulClient)
}
