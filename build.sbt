import Dependencies._

lazy val commonSettings = Seq(
  organization := "fi.sn127",
  scalaVersion := "2.12.1",
  scalacOptions ++= Seq(
	"-Xlint",
	"-deprecation",
	"-feature",
	"-unchecked",
	"-Xfatal-warnings"),
  //wartremoverWarnings ++= Warts.allBut(
  wartremoverErrors ++= Warts.allBut(
    Wart.ListOps, // this is deprecated
    Wart.Throw //https://github.com/puffnfresh/wartremover/commit/869763999fcc1fd685c1a8038c974854457b608f
  )
)

lazy val utils = (project in file(".")).
  aggregate(fs).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val fs = (project in file("fs")).
  settings(commonSettings: _*).
  settings(
    name := "utils-fs",
    version := "0.5.3",
    isSnapshot := false,
    fork in run := true,
    libraryDependencies += scalaArm,
    libraryDependencies += scalatest % "test"
  )

