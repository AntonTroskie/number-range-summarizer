# Number Range Summarizer

## Background / Overview

User enters an integer array of an undefined length, separating each value with a comma as a delimiter. 

**Allowed characters**: '0' to '9'  and ','

Program produces a comma delimited list of numbers, grouping them into a range when they appear to be sequential.

## An Example of Usage

```powershell
User Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31"

Program Output: "1, 3, 6-8, 12-15, 21-24, 31"
```

## Features

- Robust

  - Prevention against faulty integer parsing in the presence of an incorrect character set.

- Format Auto-correction

  - Multiple accidental delimiters, randomly scattered spacing, and instances where identical integer values occur in different indexes of the array are handled accordingly.

  *~Any user input that sticks to the allowed character set will render an appropriate output.*

## Prerequisites

This project requires the following:

- [Java SE Runtime Environment 8](https://www.oracle.com/java/technologies/javase-jre8-downloads.html)

## Building

Navigate to the project directory and use [Gradle](https://gradle.org/) to build and run the project:

```sh
$ ./gradlew build
$ ./gradlew run
```

Unit tests are run using:

```sh
$ ./gradlew test
```

## Structure / Scaffolding

```text
numberrangesummarizer
├── build.gradle
├── doc
│   └── Documentation.pdf
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── lib
│   ├── apiguardian-api-1.0.0.jar
│   ├── junit-gradle-5.0.0-ALPHA.jar
│   ├── junit-jupiter-5.4.2.jar
│   ├── junit-jupiter-api-5.4.2.jar
│   ├── junit-jupiter-engine-5.4.2.jar
│   ├── junit-jupiter-params-5.4.2.jar
│   ├── junit-platform-commons-1.4.2.jar
│   ├── junit-platform-engine-1.4.2.jar
│   └── opentest4j-1.1.1.jar
├── README.md
├── settings.gradle
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── numberrangesummarizer
    │   │           ├── Main.java
    │   │           ├── NumberRangeSummarizer.java
    │   │           └── Summarizer.java
    │   └── resources
    └── test
        ├── java
        │   └── SummarizerTest.java
        └── resources
```

## Documentation

- [Documentation](https://github.com/AntonTroskie/numberrangesummarizer/blob/main/doc/Documentation.pdf) - Lightweight technical documentation.

## Bugs/Issues

If you have questions, feature requests or a bug you want to report, please click [here](https://github.com/AntonTroskie/numberrangesummarizer/issues) to file an issue.
