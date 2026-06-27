# How to use
[![](https://jitpack.io/v/L98293/phone.svg)](https://jitpack.io/#L98293/phone)

### Verified Versions
Spring Boot: 3.5.13<br>
Java: 21<br>
Kotlin: 2.3.21
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
format = Format.PLUS // 국가코드 포함(+82 10-1234-5678)
format = Format.IDD // IDD 포함 (0082 10-1234-5678)
format = Format.WITHOUT_PLUS // 국가코드 제외 (10-1234-5678)
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
The number formats are as follows:
```kotlin
format = Format.PLUS        // Includes country code (+1 123-456-7890)
format = Format.IDD         // Includes IDD (001 123-456-7890)
format = Format.WITHOUT_PLUS // Excludes country code (123-456-7890)
format = Format.LOCAL       // Local number format (123-456-7890)
format = Format.ANY         // Covers all of the above cases
```
It also supports numbers with or without hyphens (-).

Translate by Claude. If you find any issues with the translation, please let us know.
</details>

---

## Gradle
### setting.gradle.kts
```kotlin
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url = uri("https://jitpack.io") }
		}
	}
```

### build.gradle.kts
```kotlin
dependencies {
    implementation("com.github.L98293:phone:2.1.1-4")
}
```
---

### setting.gradle
```java
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS);
		repositories {
			mavenCentral();
			maven { url 'https://jitpack.io' }
		}
	}
```

### build.gradle
```java
dependencies {
	implementation 'com.github.L98293:phone:2.1.1-4'
}
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
