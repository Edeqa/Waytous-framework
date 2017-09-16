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
        compile 'com.github.edeqa:waytous-framework:1.41'
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
        <version>1.41</version>
    </dependency>

## How to use

See the [Javadoc](https://edeqa.github.io/waytous-framework/javadoc/) for more details about the API.


## Troubleshooting


## History

1.41 - initial version for Waytous 1.41

## License

Waytous Framework is licensed under an MIT license. See the `LICENSE` file for specifics.
