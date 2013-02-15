name := "scautils"

organization := "org.decaf"

scalaVersion := "2.10.1-RC1"

crossScalaVersions := Seq("2.10.0", "2.10.1-RC1", "2.11.0-SNAPSHOT")

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

resolvers ++= Seq(
  "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/",
  "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases"  at "http://oss.sonatype.org/content/repositories/releases",
  "typesafe" at "http://repo.typesafe.com/typesafe/ivy-releases/"
)

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "1.2.3",
  "org.specs2" %% "specs2" % "1.13" % "test")

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishTo := Some("Sonatype Snapshots Nexus" at "http://nexus.nomqueue.com:8081/nexus/content/repositories/snapshots/")
