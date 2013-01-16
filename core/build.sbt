name := "scautils"

organization := "com.nom"

crossScalaVersions := Seq("2.9.1", "2.9.2", "2.10.0")

scalacOptions ++= Seq("-deprecation", "-unchecked")

resolvers ++= Seq(
  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases"  at "http://oss.sonatype.org/content/repositories/releases",
  "typesafe" at "http://repo.typesafe.com/typesafe/ivy-releases/"
)

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "1.12.3" % "test")

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishTo := Some("Sonatype Snapshots Nexus" at "http://nexus.nomqueue.com:8081/nexus/content/repositories/snapshots/")
