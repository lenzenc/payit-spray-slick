Twirl.settings

name := "payit-spray-slick"

version := "0.0.1"

scalaVersion := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

//unmanagedResourceDirectories in Compile <++= baseDirectory { base =>
//  Seq( base / "src/main/webapp" )
//}

libraryDependencies ++= Seq(
  "io.spray"%"spray-can"% "1.3.1",
  "io.spray"%"spray-routing"% "1.3.1",
  "io.spray"%"spray-testkit"% "1.3.1",
  "io.spray"%%"spray-json"%"1.2.6",
  "com.typesafe.akka"%%"akka-actor"% "2.3.0",
  "com.typesafe.slick"%%"slick"%"2.0.1",
  "mysql"%"mysql-connector-java"%"5.1.29"
)

Revolver.settings

Twirl.settings

