plugins {
    kotlin("jvm") version "2.3.21"
    id("io.spring.dependency-management") version "1.1.7"
    `maven-publish`
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:4.1.0") {
            bomProperty("kotlin.version", "2.3.21")
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("jakarta.validation:jakarta.validation-api")

    implementation("com.googlecode.libphonenumber:libphonenumber:9.0.41")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}