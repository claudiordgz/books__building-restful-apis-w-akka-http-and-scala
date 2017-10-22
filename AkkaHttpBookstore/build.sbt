import sbt.Keys._
import sbt._
import sbtrelease.Version

name := "bookstore"

resolvers += Resolver.sonatypeRepo("public")
scalaVersion := "2.12.2"
releaseNextVersion := { ver => Version(ver).map(_.bumpMinor.string).getOrElse("Error") }
assemblyJarName in assembly := "bookstore.jar"

val serverlessDependencies = Seq(
  "com.amazonaws" % "aws-lambda-java-events" % "1.3.0",
  "com.amazonaws" % "aws-lambda-java-core" % "1.1.0"
)

val akkaHttpVersion = "10.0.10"
val akkaDependencies = Seq(
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.pauldijou" %% "jwt-core" % "0.14.0",
  "org.scalatest" % "scalatest_2.12" % "3.0.1" % "test",
  "com.typesafe.slick" %% "slick" % "3.2.1",
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.1",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "org.flywaydb" % "flyway-core" % "3.2.1",
  "com.github.t3hnar" %% "scala-bcrypt" % "3.0"
)

libraryDependencies ++= serverlessDependencies
libraryDependencies ++= akkaDependencies

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-Xfatal-warnings")
