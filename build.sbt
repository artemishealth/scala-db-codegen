lazy val publishSettings = Seq(
  publishMavenStyle := true,
  publishMavenStyle := true,
  publishArtifact := true,
  publishTo := {
    val nexus = "https://maven.internal.artemishealth.com/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "ext-snapshot-local")
    else
      Some("releases" at nexus + "libs-release-local")
  },
  publishArtifact in Test := false,
  licenses := Seq(
    "MIT" -> url("http://www.opensource.org/licenses/mit-license.php")),
  homepage := Some(url("https://github.com/artemishealth/scala-db-codegen")),
  autoAPIMappings := true,
  apiURL := Some(url("https://github.com/artemishealth/scala-db-codegen")),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/artemishealth/scala-db-codegen"),
      "scm:git:git@github.com:artemishealth/scala-db-codegen.git"
    )
  ),
  pomExtra :=
    <developers>
        <developer>
          <id>artemishealth</id>
          <name>Ólafur Páll Geirsson</name>
          <url>https://geirsson.com</url>
        </developer>
      </developers>
)

lazy val `launaskil-codegen` =
  (project in file("."))
    .settings(packSettings)
    .settings(publishSettings)
    .settings(
      name := "scala-scala-db-codegen",
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
