# How to use
[![Maven Central](https://img.shields.io/maven-central/v/io.github.l98293/phone)](https://central.sonatype.com/artifact/io.github.l98293/phone)

Supports Spring Boot 3.x.x and 4.x.x<br>

### Verified Versions
Spring Boot: 3.5.16, 4.1.2<br>
Java: 17, 21<br>
Kotlin: 1.9.25, 2.3.21
---
## explain
<details>
<summary>한국어</summary>
ISO 3166-1를 이용해서 해당 국가의 전화번호 형식의 유효성을 검증할 수 있는 어노테이션 입니다.

사용방법은 아래와 같습니다.

@Phone을 선언 후 지역과 번호 형식을 지정하시면 됩니다. 한국을 예시로 들었을 때

@Phone(region = Region.KR, format = Format.LOCAL)형태로 사용할 수 있습니다.


번호 형식은 아래와 같습니다.

```kotlin
format = Format.PLUS // 국가코드 포함 (+82 10-1234-5678)
format = Format.IDD // 국제전화 식별번호 포함 (001 82 10-1234-5678, 00700 82 10-1234-5678)
format = Format.WITHOUT_PLUS // + 없이 국가코드 포함 (82 10-1234-5678)
format = Format.LOCAL // 현지 번호 형식 (010-1234-5678)
format = Format.ANY // 위 모든 경우 포함
```

하이픈(-)을 포함하거나, 포함하지 않는 경우에도 사용 가능합니다.
</details>

<details>
<summary>English</summary>
This is an annotation that validates phone number formats for the corresponding country using ISO 3166-1.
Usage is as follows:

Declare @Phone and specify the region and number format. Using South Korea as an example, it can be used in the form of @Phone(region = Region.KR, format = Format.LOCAL).
The number formats are as follows (US examples):
```kotlin
format = Format.PLUS         // Includes country code with + (+1 650-253-0000)
format = Format.IDD          // Includes the international dialing prefix (011 1 650-253-0000)
format = Format.WITHOUT_PLUS // Includes country code without + (1 650-253-0000)
format = Format.LOCAL        // Local number format (650-253-0000)
format = Format.ANY          // Covers all of the above cases
```
It also supports numbers with or without hyphens (-).

Translate by Claude. If you find any issues with the translation, please let us know.
</details>

---

## Gradle
### build.gradle.kts
```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.l98293:phone:2.2.0")
}
```

### build.gradle
```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'io.github.l98293:phone:2.2.0'
}
```

## Maven
### pom.xml
```xml
<dependency>
    <groupId>io.github.l98293</groupId>
    <artifactId>phone</artifactId>
    <version>2.2.0</version>
</dependency>
```
---

### example
```kotlin
@field:NotBlank
@field:Phone(region = Region.KR, format = Format.LOCAL)
val phone: String
```
```kotlin
@field:NotBlank
@field:Phone(region = Region.US, format = Format.PLUS)
val phone: String
```
