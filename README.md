# Automated UI Test Suite for jpetstore6

Welcome to the Automated UI Test Suite for **jpetstore6**. This project is designed to provide comprehensive, efficient, and reliable testing for the jpetstore6 web application. It utilizes advanced tools and design patterns to ensure high-quality testing results. The suite employs **Selenium** for browser automation, **Cucumber** for behavior-driven development (BDD), and **JUnit** for managing test cases. Maven is used for dependency management and build automation. Additionally, the project includes the **Page Object Model** for enhanced maintainability, the **Singleton Design Pattern** for managing WebDriver instances, and **Allure** for generating detailed test reports.

The jpetstore6 application can be accessed at [petstore.octoperf.com](http://petstore.octoperf.com).

## Key Features

- **Cross-Browser Testing**: Tests are executed in parallel across multiple browsers (Chrome, Firefox, Edge) to ensure comprehensive coverage and faster feedback.
- **Cross-Platform(Operating System) Testing**: The tests are run across different operating systems (Ubuntu, Windows, macOS) to ensure compatibility and stability across environments.
- **Detailed Reporting**: Allure reports provide detailed and interactive test results, including execution statistics, screenshots, and logs.

## Advantages of Cross-Browser and Cross-Platform Testing

**Cross-Browser Testing** ensures that the application performs consistently across different web browsers. This is crucial because users may access your application using various browsers, each with its rendering engine and features. Testing across multiple browsers helps identify browser-specific issues, ensuring a seamless user experience regardless of the browser used.

**Cross-Platform Testing** involves testing the application on different operating systems to verify its compatibility and performance. Since users may access your application from various operating systems, including Windows, macOS, and Linux, it is essential to ensure that the application behaves as expected on each platform. Cross-platform testing helps uncover OS-specific issues and ensures a consistent user experience across different environments.

## GitHub Actions Workflow

The GitHub Actions workflow is defined in `.github/workflows/ci.yml` and automates the testing and reporting process.

Here’s the `ci.yml` file used for the GitHub Actions workflow:

```yaml
name: Run Parallel Tests And Generate Allure Report

on:
  push:
    branches:
      - main
  pull_request:
    branches:
      - main
  schedule:
    - cron: '0 7 * * *'  # Schedule to run at 3 AM EST daily

permissions:
  contents: write
  actions: write

jobs:
  test:
    strategy:
      matrix:
        include:
          - os: ubuntu-latest
            browser: headless-firefox
          - os: windows-latest
            browser: headless-chrome
          - os: macos-latest
            browser: headless-edge
    runs-on: ${{ matrix.os }}

    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Set up JDK 11
        uses: actions/setup-java@v3
        with:
          java-version: '11'
          distribution: 'temurin'
          cache: maven

      - name: Prepare configuration.properties
        run: |
          echo "browser=${{ matrix.browser }}" > configuration.properties

      - name: Ensure Allure results directory
        run: mkdir -p allure-results

      - name: Run Parallel Tests
        run: mvn -B clean test -Dbrowser=${{ matrix.browser }}

      - name: Upload Allure results
        uses: actions/upload-artifact@v4
        with:
          name: allure-results-${{ matrix.os }}-${{ matrix.browser }}
          path: allure-results

  generate-report:
    runs-on: ubuntu-latest
    needs: test

    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Download Allure results from Firefox
        uses: actions/download-artifact@v4
        with:
          name: allure-results-ubuntu-latest-headless-firefox
          path: allure-results-firefox

      - name: Download Allure results from Chrome
        uses: actions/download-artifact@v4
        with:
          name: allure-results-windows-latest-headless-chrome
          path: allure-results-chrome

      - name: Download Allure results from Edge
        uses: actions/download-artifact@v4
        with:
          name: allure-results-macos-latest-headless-edge
          path: allure-results-edge

      - name: Merge Allure results
        run: |
          mkdir -p merged-results
          cp -r allure-results-firefox/* merged-results/
          cp -r allure-results-chrome/* merged-results/
          cp -r allure-results-edge/* merged-results/

      - name: Generate Allure report
        uses: simple-elf/allure-report-action@master
        id: allure-report
        with:
          allure_results: merged-results
          allure_report: allure-report

      - name: Deploy report to GitHub Pages
        uses: peaceiris/actions-gh-pages@v4
        with:
          github_token: ${{ secrets.GITHUB_TOKEN }}
          publish_dir: allure-report
```
Here’s a step-by-step explanation of the workflow:

### Workflow Triggers

- **Push**: Triggers the workflow on any push to the `main` branch.
- **Pull Request**: Activates the workflow on pull requests targeting the `main` branch.
- **Scheduled**: Runs daily at 3 AM EST.

### Workflow Jobs

#### 1. `test` Job

- **Purpose**: Executes tests in parallel across different operating systems and browsers.
- **Strategy**: Uses a matrix strategy to run tests on:
  - Ubuntu with headless Firefox
  - Windows with headless Chrome
  - macOS with headless Edge

  **Steps:**

  1. **Checkout Code**: Retrieves the latest code from the repository using `actions/checkout@v4`.
  2. **Set Up JDK 11**: Configures JDK 11 with Maven caching using `actions/setup-java@v3`.
  3. **Prepare `configuration.properties`**: Creates a `configuration.properties` file with the browser configuration for the current job.
  4. **Ensure Allure Results Directory**: Creates the `allure-results` directory to store test results.
  5. **Run Parallel Tests**: Executes Maven tests with the specified browser configuration.
  6. **Upload Allure Results**: Uploads the test results as GitHub Actions artifacts for each OS and browser combination.

#### 2. `generate-report` Job

- **Purpose**: Aggregates and generates the Allure report from the test results uploaded by the `test` job.
  
  **Steps:**

  1. **Checkout Code**: Retrieves the latest code from the repository again to ensure the report generation has the most up-to-date context.
  2. **Download Allure Results from Firefox**: Downloads the test results for Firefox from GitHub Actions artifacts.
  3. **Download Allure Results from Chrome**: Downloads the test results for Chrome.
  4. **Download Allure Results from Edge**: Downloads the test results for Edge.
  5. **Merge Allure Results**: Combines all downloaded results into a single `merged-results` directory.
  6. **Generate Allure Report**: Uses `simple-elf/allure-report-action@master` to generate the Allure report from the merged results.
  7. **Deploy Report to GitHub Pages**: Deploys the generated Allure report to GitHub Pages using `peaceiris/actions-gh-pages@v4`.


# Project Documentation

## Tools and Design Patterns Used

- **Selenium**: Automates interactions with web browsers to simulate real user behavior.
- **Cucumber**: Facilitates behavior-driven development (BDD) by providing readable scenarios for testing.
- **JUnit**: Manages and executes test cases.
- **Page Object Model**: Enhances test maintainability by separating web page interactions into distinct classes.
- **Singleton Design Pattern**: Manages WebDriver instances to ensure a single instance is used throughout the test execution.
- **Allure Reports**: Generates detailed and interactive test reports for better insights into test execution and results.

## Dependencies

### Selenium WebDriver
- **Artifact**: `org.seleniumhq.selenium:selenium-java`
- **Version**: 4.23.0
- **Purpose**: Essential for automating web browser interactions.

### Cucumber
- **Artifacts**:
  - `io.cucumber:cucumber-junit` (Version: 7.16.0, Scope: test)
  - `io.cucumber:cucumber-java` (Version: 7.16.0)
  - `io.cucumber:cucumber-picocontainer` (Version: 7.16.0, Scope: test)
- **Purpose**: Supports behavior-driven development (BDD) style tests.

### PicoContainer
- **Artifact**: `io.cucumber:cucumber-picocontainer`
- **Version**: 7.16.0
- **Scope**: test
- **Purpose**: Manages the lifecycle of step definitions in Cucumber tests.

### JavaFaker
- **Artifact**: `com.github.javafaker:javafaker`
- **Version**: 1.0.2
- **Purpose**: Generates realistic test data for use in tests.

### Allure Reporting
- **Artifacts**:
  - `io.qameta.allure:allure-cucumber7-jvm` (Scope: test)
  - `io.qameta.allure:allure-bom` (Version: 2.28.0)
- **Purpose**: Provides detailed and interactive test reports.

### SLF4J and Logback
- **Artifacts**:
  - `org.slf4j:slf4j-api` (Version: 2.0.13)
  - `ch.qos.logback:logback-classic` (Version: 1.5.6, Scope: test)
- **Purpose**: Provides logging functionality for test execution.

### Lombok
- **Artifact**: `org.projectlombok:lombok`
- **Version**: 1.18.34
- **Scope**: provided
- **Purpose**: Reduces boilerplate code by automatically generating common methods.

### Maven Surefire Plugin
- **Artifact**: `org.apache.maven.plugins:maven-surefire-plugin`
- **Version**: 3.3.0
- **Purpose**: Manages the execution of tests and supports parallel execution.

### Maven Compiler Plugin
- **Artifact**: `org.apache.maven.plugins:maven-compiler-plugin`
- **Version**: 3.11.0
- **Purpose**: Compiles Java source files using Java 11.
