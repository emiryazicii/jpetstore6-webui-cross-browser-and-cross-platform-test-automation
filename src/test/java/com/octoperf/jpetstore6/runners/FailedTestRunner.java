package com.octoperf.jpetstore6.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * FailedTestRunner is a test runner class for re-executing failed Cucumber test scenarios.
 * This class is configured to run only the tests that have failed previously by referring
 * to the list of failed scenarios stored in a rerun file.
 * It uses JUnit to run the Cucumber tests.
 */
@RunWith(Cucumber.class) // Indicates that this class should be run with JUnit
@CucumberOptions(
        // Specifies the location of the failed test scenarios list
        features = "@target/rerun.txt",
        // Specifies the package where step definitions are located
        glue= "com/octoperf/jpetstore6/stepDefs"
)
public class FailedTestRunner {
}
