package com.octoperf.jpetstore6.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * CukesRunner is the test runner class for executing Cucumber tests with JUnit.
 * This class configures the Cucumber options, such as the location of feature files,
 * the path for reporting, and the plugins used for generating reports.
 * It uses JUnit to run the Cucumber tests.
 */
@RunWith(Cucumber.class) // Indicates that this class should be run with JUnit
@CucumberOptions(
        // Add any desired plugins for reporting here
        plugin = {
                // Generates HTML reports in the specified directory
                "html:target/cucumber-reports.html",
                // Generates rerun file in the specified directory
                "rerun:target/rerun.txt",
                // Enables Allure reporting
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                // Generates JSON report for Cucumber results in the specified directory
                "json:target/cucumber.json"
        },
        // Specifies the location of feature files
        features = "src/test/resources/features",
        // Specifies the package where step definitions are located
        glue = "com/octoperf/jpetstore6/stepDefs",
        // Whether to execute a dry run of the feature files
        dryRun = false,
        // Specifies the tags to include/exclude specific scenarios or features
        tags = "",
        // Whether to publish the results
        publish = true
)
public class CukesRunner {
}
