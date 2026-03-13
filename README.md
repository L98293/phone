# How to use

### Gradle
setting.gradle
```
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```

build.gradle
```
dependencies {
	        implementation 'com.github.L98293:phone:1.1.0'
	}
```


### Maven
pom.xml
```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

dependency
```
	<dependency>
	    <groupId>com.github.L98293</groupId>
	    <artifactId>phone</artifactId>
	    <version>Tag</version>
	</dependency>
```

A custom validation annotation for phone numbers based on ISO international standards.

You can easily validate phone numbers by applying the @Phone annotation to your fields. Specify the ISO 3166-1 alpha-2 country code (e.g., "KR", "US") in the region attribute.

ISO 국가 표쥰 코드를 이용해서 해당 국가의 전화번호 형식의 유효성을 검증할 수 있는 어노테이션 입니다.
아래 처럼 @Phone(region = Region.KR) 등으로 사용하시면 대한민국의 모든 전화번호 형식에 대해 유효성을 검증할 수 있습니다.

기본적으로 null값이 들어오면 true를 반환하기에, @NotNull, @NotBlank을 사용하셔야 합니다.

```
@Phone(region = Region.KR)
    String phoneNumber;

@Phone(region = Region.US)
    String phoneNumber;
```
