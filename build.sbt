ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.13"

libraryDependencies += "com.twitter" %% "util-core" % "23.11.0"

lazy val root = (project in file("."))
  .settings(
    name := "scala-vs-twitter-future"
  )
