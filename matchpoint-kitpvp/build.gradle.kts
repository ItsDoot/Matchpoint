plugins {
    java
}

group = "com.expansemc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.spongepowered.org/repository/maven-public/")
}

dependencies {
    implementation("org.spongepowered:spongeapi:8.0.0-SNAPSHOT")

    implementation(project(":matchpoint-api"))
}
