import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    kotlin("jvm") version "2.3.21"
    `maven-publish`
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
        apiVersion.set(KotlinVersion.KOTLIN_1_9)
        languageVersion.set(KotlinVersion.KOTLIN_1_9)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("jakarta.validation:jakarta.validation-api:3.0.2")

    implementation("com.googlecode.libphonenumber:libphonenumber:9.0.41")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}