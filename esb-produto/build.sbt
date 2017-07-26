name := """esb-produto"""
organization := "com.github.dsaouda"

version := "1.0.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.2"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.0" % Test
libraryDependencies += "org.jsoup" % "jsoup" % "1.10.3"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.github.dsaouda.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.github.dsaouda.binders._"
