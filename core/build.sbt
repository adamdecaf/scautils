name := "scautils"

scalaVersion := "2.10.0-M7"

libraryDependencies +=  "org.specs2" % "specs2_2.10.0-M7" % "1.12.1.1" % "test"

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

resolvers ++= Seq(
  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases"  at "http://oss.sonatype.org/content/repositories/releases",
  "typesafe" at "http://repo.typesafe.com/typesafe/ivy-releases/"
)
