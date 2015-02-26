name := """frontliners-api"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "com.novus" %% "salat" % "1.9.9",
  "org.slf4j" % "slf4j-api" % "1.7.9",
  "org.slf4j" % "slf4j-nop" % "1.7.9",
  "org.twitter4j" % "twitter4j-core" % "4.0.2"
)
