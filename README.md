# Waytous Framework

[![](https://jitpack.io/v/edeqa/waytous-framework.svg)](https://jitpack.io/#edeqa/waytous-framework)

Base framework for Waytous.

## How to add

### Gradle

Step 1. Add the JitPack repository in your root build.gradle at the end of repositories:

    allprojects {
        repositories {
            maven { url "https://jitpack.io" }
        }
    }

Step 2. Add the dependency in the app's build.gradle:

    dependencies {
        compile 'com.github.edeqa:waytous-framework:2.63'
    }

### Maven

Step 1. Add the JitPack repository to your build file:

    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
    
Step 2. Add the dependency:
 
    <dependency>
        <groupId>com.github.edeqa</groupId>
        <artifactId>waytous-framework</artifactId>
        <version>2.63</version>
    </dependency>

## How to use

See the [Javadoc](https://edeqa.github.io/Waytous-framework/) to learn more about the API.

## History

2.63 - fixes and improvements

1.61 - fixes and improvements

1.50 - SignProvider

1.41 - initial version for Waytous 1.41

## License

Waytous Framework is licensed under an MIT license. See the `LICENSE` file for specifics.
