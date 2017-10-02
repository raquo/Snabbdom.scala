enablePlugins(ScalaJSPlugin)

enablePlugins(ScalaJSBundlerPlugin)

libraryDependencies ++= Seq(
  "com.raquo" %%% "domtypes" % "0.2.1",
  "org.scala-js" %%% "scalajs-dom" % "0.9.3",
  "com.raquo" %%% "domtestutils" % "0.2" % Test,
  "org.scalatest" %%% "scalatest" % "3.0.3" % Test
)

npmDependencies in Compile ++= Seq(
  "snabbdom" -> "0.7.0",
  "object-assign" -> "4.1.1"
)

useYarn := true

requiresDOM in Test := true

emitSourceMaps in fastOptJS := true

emitSourceMaps in fullOptJS := true

emitSourceMaps in Test := true
