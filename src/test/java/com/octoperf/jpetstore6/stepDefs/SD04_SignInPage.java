package com.octoperf.jpetstore6.stepDefs;

import com.octoperf.jpetstore6.pages.P06_SignInPage;
import com.octoperf.jpetstore6.sharedData.ScenarioContextHolder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

/**
 * Step definitions for interactions with the Sign In page in the JPetStore application.
 * Provides methods for logging in with valid credentials and verifying various text elements on the Sign In page.
 */
@RequiredArgsConstructor
@Slf4j
public class SD04_SignInPage {

    private final P06_SignInPage signInPage;

    /**
     * Logs in with valid credentials retrieved from the scenario context.
     * The credentials are obtained from the "registrationData" stored in the ScenarioContextHolder.
     */
    @Given("I log in with valid credentials")
    public void i_successfully_log_in_with_valid_credentials() {
        String username = ScenarioContextHolder.getContext().getListOfMap("registrationData").get("userId");
        String password = ScenarioContextHolder.getContext().getListOfMap("registrationData").get("password");
        log.info("Username : |{}| ", username);
        log.info("Password : |{}| ", password);
        signInPage.login(username, password);
        log.info("Successfully logged in with valid credentials");
    }

    /**
     * Verifies that the text of the registration helper message matches the expected value.
     *
     * @param expectedText the expected text of the registration helper message
     */
    @Then("The text of the registration helper message should match the expected value")
    public void the_text_of_the_registration_helper_message_should_match_the_expected_value(String expectedText) {
       String actualText = signInPage.getRegistrationHelperMessageText();
        log.info("Expected message text: |{}| ", expectedText);
        log.info("Actual message text: |{}| ", actualText);
        Assert.assertEquals(expectedText, actualText);
        log.info("The text of the registration helper message matched the expected value");
    }

    /**
     * Verifies that the text of the username input box name matches the expected value.
     *
     * @param expectedText the expected text of the username input box name
     */
    @Then("The text of the username input box name should match the expected value")
    public void the_text_of_the_username_input_box_name_should_match_the_expected_value(String expectedText) {
        String actualText = signInPage.getUsernameInputBoxName();
        log.info("Expected text: |{}| ", expectedText);
        log.info("Actual text: |{}| ", actualText);
        Assert.assertEquals(expectedText, actualText);
        log.info("The text of the username input box name matched the expected value");
    }

    /**
     * Verifies that the text of the password input box name matches the expected value.
     *
     * @param expectedText the expected text of the password input box name
     */
    @Then("The text of the password input box name should match the expected value")
    public void the_text_of_the_password_input_box_name_should_match_the_expected_value(String expectedText) {
        String actualText = signInPage.getPasswordInputBoxName();
        log.info("Expected text: |{}| ", expectedText);
        log.info("Actual text: |{}| ", actualText);
        Assert.assertEquals(expectedText, actualText);
        log.info("The text of the password input box name matched the expected value");
    }

    /**
     * Logs in with updated credentials where the password is retrieved from the "updatedAccountInformation"
     * stored in the ScenarioContextHolder.
     * The username remains the same as during the initial login.
     */
    @When("I login with updated password")
    public void i_login_with_updated_password() {
        String username = ScenarioContextHolder.getContext().getListOfMap("registrationData").get("userId");
        String password = ScenarioContextHolder.getContext().getListOfMap("updatedAccountInformation").get("newPassword");
        signInPage.login(username, password);
        log.info("Username entered: |{}|",username);
        log.info("Password entered: |{}|",password);
    }
}