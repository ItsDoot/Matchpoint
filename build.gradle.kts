plugins {
    java
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "com.expansemc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.spongepowered.org/repository/maven-public/")
}

val shaded: Configuration by configurations.creating

dependencies {
    implementation("org.spongepowered:spongeapi:8.0.0-SNAPSHOT")

    shaded(implementation(project(":matchpoint-api"))!!)
}

tasks {
    shadowJar {
        archiveClassifier.set("dist")
        configurations = listOf(shaded)
    }
}

artifacts {
    archives(tasks.shadowJar)
}