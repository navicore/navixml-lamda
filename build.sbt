import sbt.Keys._
import sbt._
import sbtrelease.Version

name := "navixml-lambda"

resolvers += Resolver.sonatypeRepo("public")
scalaVersion := "2.12.2"
releaseNextVersion := { ver => Version(ver).map(_.bumpMinor.string).getOrElse("Error") }
assemblyJarName in assembly := "navixml.jar"

//val circeVersion = "0.9.1"
val circeVersion = "0.7.0"

libraryDependencies ++= Seq(
  "io.github.mkotsur" %% "aws-lambda-scala" % "0.0.10",
  "com.amazonaws" % "aws-lambda-java-events" % "1.3.0",
  "com.amazonaws" % "aws-lambda-java-core" % "1.1.0",
  "com.thoughtworks.xstream" % "xstream" % "1.4.10",
  "org.codehaus.jettison" % "jettison" % "1.3.8",
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
)

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-Xfatal-warnings")


assemblyMergeStrategy in assembly := {
  case PathList("META-INF", _ @ _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}
