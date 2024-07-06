import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("java")
    application
}

application {
    mainClass.set("org.example.hexlet.HelloWorld")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.javalin:javalin:6.1.4")
    implementation("org.slf4j:slf4j-simple:2.0.13")
    implementation("io.javalin:javalin-rendering:6.1.6")
    implementation("gg.jte:jte:3.1.12")

    //JTE
    implementation("gg.jte:jte:3.1.12")
    implementation("io.javalin:javalin-rendering:6.1.6")

    testImplementation(platform("org.junit:junit-bom:5.11.0-M1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // https://mvnrepository.com/artifact/org.projectlombok/lombok
    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor ("org.projectlombok:lombok:1.18.34")

    // https://mvnrepository.com/artifact/org.apache.commons/commons-text
    implementation("org.apache.commons:commons-text:1.12.0")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.0")

    //H2 database
    implementation("com.h2database:h2:2.2.224")
    implementation("com.zaxxer:HikariCP:5.1.0")


}

tasks.test {
    useJUnitPlatform()

    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true
    }
}