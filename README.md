# Automated UI Test Suite for jpetstore6

This project is an automated UI test suite designed for robust and efficient testing of the **jpetstore6** web application. It utilizes Selenium, Cucumber, and JUnit, and is configured with Maven for dependency management and build automation. The setup includes the Page Object Model, Singleton Design Pattern, and Allure for detailed test reporting.

The application is hosted at [petstore.octoperf.com](http://petstore.octoperf.com).

## Key Features

- **Parallel Cross-Browser Testing**: Tests are executed in parallel across multiple browsers (Chrome, Firefox, Edge) to ensure comprehensive coverage and faster feedback.
- **Cross-Operating System Testing**: The tests are run across different operating systems (Ubuntu, Windows, macOS) to ensure compatibility and stability across environments.
- **Detailed Reporting**: Allure reports provide detailed and interactive test results, including execution statistics, screenshots, and logs.

## GitHub Actions

The GitHub Actions workflow is defined in `.github/workflows/ci.yml` and includes:

- **Trigger**: Runs on `push` to `main`, `pull_request` to `main`, and at 2 AM EST daily.
- **Jobs**:
  - **Build**: Runs parallel tests across different operating systems and browsers, uploads results, and generates Allure reports.

### Matrix Strategy

The workflow uses a matrix strategy to run tests on multiple operating systems (Ubuntu, Windows, macOS) and browsers (headless-chrome, headless-firefox, headless-edge).

## Tools and Design Patterns Used

- **Selenium**: Automates browser interactions to simulate real user behavior.
- **Cucumber**: Facilitates behavior-driven development (BDD) style tests with readable scenarios.
- **JUnit**: Manages and runs the test cases.
- **Page Object Model**: Enhances test maintainability by creating separate classes for web pages.
- **Singleton Design Pattern**: Manages WebDriver instances to ensure a single instance throughout the tests.
- **Allure Reports**: Generates and hosts detailed test reports.

## Dependencies

This project uses several dependencies to support different aspects of the test suite. Here’s a brief overview of each and why it’s used:

### Selenium WebDriver
- **Artifact**: `org.seleniumhq.selenium:selenium-java`
- **Version**: `4.23.0`
- **Purpose**: Essential for automating web browser interactions.

### Cucumber
- **Artifacts**:
  - `io.cucumber:cucumber-junit` (Version: `7.16.0`, Scope: `test`)
  - `io.cucumber:cucumber-java` (Version: `7.16.0`)
  - `io.cucumber:cucumber-picocontainer` (Version: `7.16.0`, Scope: `test`)
- **Purpose**: Enables behavior-driven development (BDD) style tests.

### PicoContainer
- **Artifact**: `io.cucumber:cucumber-picocontainer`
- **Version**: `7.16.0`
- **Scope**: `test`
- **Purpose**: Manages the lifecycle of step definitions.

### JavaFaker
- **Artifact**: `com.github.javafaker:javafaker`
- **Version**: `1.0.2`
- **Purpose**: Generates realistic test data.

### Allure Reporting
- **Artifacts**:
  - `io.qameta.allure:allure-cucumber7-jvm` (Scope: `test`)
  - `io.qameta.allure:allure-bom` (Version: `2.28.0`)
- **Purpose**: Generates detailed and interactive test reports.

### SLF4J and Logback
- **Artifacts**:
  - `org.slf4j:slf4j-api` (Version: `2.0.13`)
  - `ch.qos.logback:logback-classic` (Version: `1.5.6`, Scope: `test`)
- **Purpose**: Provides logging functionality.

### Lombok
- **Artifact**: `org.projectlombok:lombok`
- **Version**: `1.18.34`
- **Scope**: `provided`
- **Purpose**: Reduces boilerplate code by generating common methods.

### Maven Surefire Plugin
- **Artifact**: `org.apache.maven.plugins:maven-surefire-plugin`
- **Version**: `3.3.0`
- **Purpose**: Runs tests and supports parallel execution.

### Maven Compiler Plugin
- **Artifact**: `org.apache.maven.plugins:maven-compiler-plugin`
- **Version**: `3.11.0`
- **Purpose**: Compiles Java source files using Java 11.