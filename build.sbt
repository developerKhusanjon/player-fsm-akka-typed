version := "0.1"

scalaVersion := "2.13.14"

lazy val root = (project in file("."))
  .settings(
    name := "player-fsm-akka-typed",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" % "akka-actor-typed_2.13" % "2.8.5",
      "com.typesafe.akka" % "akka-stream-typed_2.13" % "2.8.5",
    )
  )
