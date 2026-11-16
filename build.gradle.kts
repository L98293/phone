import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    kotlin("jvm") version "2.3.21"
    id("com.vanniktech.maven.publish") version "0.37.0"
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

mavenPublishing {
    publishToMavenCentral(automaticRelease = true)
    signAllPublications()

    coordinates(
        groupId = "io.github.l98293",
        artifactId = "phone",
        "2.2.0"
    )

    pom {
        name.set("phone")
        description.set("Bean Validation annotation for country-specific phone number formats")
        url.set("https://github.com/L98293/phone")

        licenses {
            license {
                name.set("Apache License 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0")
            }
        }

        developers {
            developer {
                id.set("L98293")
                name.set("김경윤")
                url.set("https://github.com/L98293")
                email.set("L982930009@gmail.com")
            }
        }

        scm {
            url.set("https://github.com/L98293/phone")
            connection.set("scm:git:https://github.com/L98293/phone.git")
            developerConnection.set("scm:git:ssh://git@github.com/L98293/phone.git")
        }
    }
}