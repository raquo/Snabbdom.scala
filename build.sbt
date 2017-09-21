enablePlugins(ScalaJSPlugin)

enablePlugins(ScalaJSBundlerPlugin)

name := "Snabbdom.scala"

normalizedName := "snabbdom"

organization := "com.raquo"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.11"

crossScalaVersions := Seq("2.11.11", "2.12.3")

homepage := Some(url("https://github.com/raquo/Snabbdom.scala"))

licenses += ("MIT", url("https://github.com/raquo/Snabbdom.scala/blob/master/LICENSE.txt"))

libraryDependencies ++= Seq(
  "com.raquo" %%% "domtypes" % "0.1.4-SNAPSHOT",
  "org.scala-js" %%% "scalajs-dom" % "0.9.3",
  "com.raquo" %%% "domtestutils" % "0.2-SNAPSHOT" % Test,
  "org.scalatest" %%% "scalatest" % "3.0.3" % Test
)

npmDependencies in Compile ++= Seq(
  "snabbdom" -> "0.6.7",
  "object-assign" -> "4.1.1"
)

useYarn := true

requiresDOM in Test := true

emitSourceMaps in fastOptJS := true

emitSourceMaps in fullOptJS := true

emitSourceMaps in Test := true
