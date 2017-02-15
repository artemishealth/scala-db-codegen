lazy val `launaskil-codegen` =
  (project in file("."))
    .settings(packSettings)
    .settings(
      name := "scala-db-codegen",
      organization := "com.geirsson",
      scalaVersion := "2.11.8",
      version := com.geirsson.codegen.Versions.nightly,
      packMain := Map("scala-scala-db-codegen" -> "com.geirsson.codegen.Codegen"),
      libraryDependencies ++= Seq(
        "com.geirsson" %% "scalafmt-core" % "0.3.0",
        "io.getquill" %% "quill-core" % "0.8.0",
        "com.h2database" % "h2" % "1.4.192",
        "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
        "com.github.alexarchambault" %% "case-app" % "1.0.0-RC3",
        "org.scalatest" %% "scalatest" % "3.0.0" % "test"
      )
    )

publishTo := Some("Artifactory Realm" at
"https://maven.internal.artemishealth.com/artifactory/libs-release-local;build.timestamp=" + new
java.util.Date().getTime)
credentials += Credentials("Artifactory Realm", "maven.internal.artemishealth.com", sys.env("ARTIFACTORY_USER"),
sys.env("ARTIFACTORY_PASSWORD"))
