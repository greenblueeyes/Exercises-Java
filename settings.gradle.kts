plugins {   
    // Apply the application plugin to add support for building a CLI application in Java.
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "exercises"
include("app")
