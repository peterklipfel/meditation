name := "Meditation"

version := "1.0"

scalaVersion := "2.11.8"

traceLevel := -1

logLevel := Level.Info

// Print test output as it's happening (don't buffer it)
logBuffered in Test := false

// disable printing timing information, but still print [success]
showTiming := false

// disable printing a message indicating the success or failure of running a task
showSuccess := false

// append -deprecation to the options passed to the Scala compiler
scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

// disable updating dynamic revisions (including -SNAPSHOT versions)
offline := true

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.0" withSources() withJavadoc(),
  "org.scalatest" %% "scalatest" % "3.0.0" % "test" withSources() withJavadoc()
)
