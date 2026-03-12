## How to use

gradle
```
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```
```
dependencies {
	        implementation 'com.github.L98293:phone:1.1.0'
	}
```

A custom validation annotation for phone numbers based on ISO international standards.

You can easily validate phone numbers by applying the @Phone annotation to your fields. Specify the ISO 3166-1 alpha-2 country code (e.g., "KR", "US") in the region attribute.

```
@Phone(region = "KR")
    String phoneNumber;

@Phone(region = "US")
    String phoneNumber;
```
