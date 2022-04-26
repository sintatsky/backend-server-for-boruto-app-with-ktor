val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val koinVersion: String by project

plugins {
    application
    kotlin("jvm") version "1.6.20"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.20"
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:1.6.7")
    implementation("io.ktor:ktor-serialization:1.6.7")
    implementation("io.ktor:ktor-server-netty:1.6.7")
    implementation("ch.qos.logback:logback-classic:1.2.6")

    testImplementation("io.ktor:ktor-server-tests:1.6.7")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.6.20")

    // Koin for Ktor
    implementation("io.insert-koin:koin-ktor:3.2.0-beta-1")
// SLF4J Logger
    implementation("io.insert-koin:koin-logger-slf4j:3.2.0-beta-1")
}