import sbt._
import Keys._

object ProjectBuild extends Build {

    override lazy val settings = super.settings ++
        Seq(scalaVersion := "2.11.2", resolvers := Seq())

    val appDependencies = Seq(
        "org.codehaus.janino" % "janino" % "2.6.1",
        "ch.qos.logback" % "logback-classic" % "1.1.2",
        "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
        "net.logstash.logback" % "logstash-logback-encoder" % "3.0"
        )

    val appResolvers = Seq(
        "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
        )

    lazy val root = Project(
        id = "demo-logging",
        base = file("."),
        settings = Project.defaultSettings ++ Seq(
                libraryDependencies ++= appDependencies,
                resolvers ++= appResolvers)
    )
}
