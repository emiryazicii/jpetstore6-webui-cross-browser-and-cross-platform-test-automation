package com.octoperf.jpetstore6.stepDefs;

import com.octoperf.jpetstore6.sharedData.ScenarioContextHolder;
import com.octoperf.jpetstore6.singletonDriver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.MDC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Hooks class containing setup and teardown methods for Cucumber scenarios.
 * This class handles operations before and after each scenario execution, such as setting up the environment,
 * capturing screenshots on failure, closing the WebDriver, and attaching logs to the Allure report.
 */
@Slf4j
public class Hooks {

    /**
     * Initializes the WebDriver and navigates to the welcome page before each scenario.
     * This method also logs the operating system information using MDC.
     */
    @Before
    public void setupMethod() {
        String os = System.getProperty("os.name");
        MDC.put("os", os);
        log.info("Starting scenario execution on {}", MDC.get("os"));
        Driver.getDriver().get("https://petstore.octoperf.com");
    }

    /**
     * Takes a screenshot if the scenario fails, and performs cleanup actions after each scenario.
     * This method also clears the MDC, attaches logs to the Allure report, and clears the ScenarioContextHolder.
     *
     * @param scenario the Cucumber scenario object representing the current scenario
     */
    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                takeScreenshot(scenario);
            }
        } finally {
            closeDriver();
            MDC.clear();
            attachLogs();
            ScenarioContextHolder.clear();
        }
    }

    /**
     * Captures a screenshot of the current state of the WebDriver and attaches it to the scenario in Allure report.
     *
     * @param scenario the Cucumber scenario object representing the current scenario
     */
    private void takeScreenshot(Scenario scenario) {
        try {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            log.info("Screenshot captured for scenario: {}", scenario.getName());
        } catch (Exception e) {
            log.error("Failed to take screenshot for scenario: {}", scenario.getName(), e);
        }
    }

    /**
     * Closes the WebDriver after the scenario execution.
     * This method ensures proper cleanup of the WebDriver instance.
     */
    private void closeDriver() {
        try {
            Driver.closeDriver();
        } catch (Exception e) {
            log.error("Failed to close WebDriver", e);
        }
    }

    /**
     * Attaches the test log file to the Allure report.
     * This method reads the log file and adds it as an attachment in the Allure report.
     */
    private void attachLogs() {
        File logFile = new File("logs/test-log.log");
        try (FileInputStream logFileStream = new FileInputStream(logFile)) {
            Allure.addAttachment("Test Log", logFileStream);
            log.info("Attached logs to Allure report.");
        } catch (FileNotFoundException e) {
            log.error("Log file not found: {}", logFile.getPath(), e);
        } catch (IOException e) {
            log.error("Failed to read log file: {}", logFile.getPath(), e);
        }
    }
}