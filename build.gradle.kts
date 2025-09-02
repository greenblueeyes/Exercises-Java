plugins {   
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    mavenCentral()
}

dependencies {  
    // Use JUnit Jupiter for testing. 
    testImplementation(platform("org.junit:junit-bom:5.13.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation(libs.guava)
}

application {   
    // Define the main class for the application.

    //https://docs.gradle.org/current/userguide/application_plugin.html#ex-configure-the-modular-applications-main-module
    mainClass = "code.Exercise1Main"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()

testing {
    suites {
        named<JvmTestSuite>("test") {
            useJUnitJupiter("5.13.4")
        }
    }
}
