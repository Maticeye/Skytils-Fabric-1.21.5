plugins {
    kotlin("jvm") version "1.9.10"
    id("fabric-loom") version "1.6-SNAPSHOT"
}

group = "com.tvojepaketi"
version = "1.0.0"
java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
}

dependencies {
    minecraft("com.mojang:minecraft:1.21.5")
    mappings("net.fabricmc:yarn:1.21.5+build.0:v2")
    modImplementation("net.fabricmc:fabric-loader:0.18.0")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.87.0+1.21")
    modImplementation("me.shedaniel.cloth:cloth-config-fabric:6.10.54")
}

loom {
    runs {
        named("client") {
            client()
            runDir("run")
        }
        named("server") {
            server()
            runDir("run-server")
        }
    }
}
