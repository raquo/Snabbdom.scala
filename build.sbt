enablePlugins(ScalaJSPlugin)

enablePlugins(ScalaJSBundlerPlugin)

name := "Snabbdom.scala"

normalizedName := "snabbdom"

organization := "com.raquo"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.11.8", "2.12.1")

homepage := Some(url("https://github.com/raquo/snabbdom-scala"))

licenses += ("MIT", url("https://github.com/raquo/snabbdom-scala/blob/master/LICENSE.md"))

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1",
  "org.scalatest" %%% "scalatest" % "3.0.1" % "test"
)

persistLauncher in Test := false

npmDependencies in Compile ++= Seq(
  "snabbdom" -> "0.6.3",
  "object-assign" -> "4.1.1"
)

useYarn := true

requiresDOM in Test := true

enableReloadWorkflow in Test := false

// Webpack bundle is not being generated?
// Remember that you need to run `sbt fastOptJS::webpack`, not just `sbt fastOptJS`.

emitSourceMaps in fastOptJS := false
