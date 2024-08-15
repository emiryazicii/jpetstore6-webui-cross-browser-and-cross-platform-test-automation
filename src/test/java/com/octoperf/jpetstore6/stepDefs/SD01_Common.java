package com.octoperf.jpetstore6.stepDefs;

import com.octoperf.jpetstore6.pageManager.PageManager;
import com.octoperf.jpetstore6.pages.P01_BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

/**
 * Step Definitions for common actions and verifications used across multiple Cucumber scenarios.
 * This class interacts with the page objects and performs various actions and validations.
 */
@RequiredArgsConstructor
@Slf4j
public class SD01_Common {

    private final PageManager pageManager;
    private P01_BasePage currentPage;

    /**
     * Initializes the page object corresponding to the specified page name.
     * This method uses the PageManager to retrieve and initialize the page object for the given page name.
     * It then sets the current page to the initialized page object.
     *
     * @param pageName the name of the page to initialize (e.g., "Welcome", "Catalog")
     */
    @Given("I am on the {string} page")
    public void i_am_on_the_page(String pageName) {
        currentPage = pageManager.getPage(pageName);
        log.info("Current page is: |{}|", pageName);
    }

    /**
     * Clicks on an element specified by its description.
     *
     * @param elementDescription the description of the element to click
     */
    @When("I click on the {string}")
    public void i_click_on_the(String elementDescription) {
        currentPage.clickOn(elementDescription);
        log.info("Clicked on the |{}|", elementDescription);
    }

    /**
     * Verifies that the page title and URL match the expected values.
     *
     * @param expectedPageTitle the expected title of the page
     * @param expectedUrl       the expected URL of the page
     */
    @Then("The page title {string} and the URL {string} should match the expected value")
    public void the_page_title_and_the_url_should_match_the_expected_value(String expectedPageTitle, String expectedUrl) {
        log.info("Expected page title: |{}|", expectedPageTitle);
        log.info("Expected url: |{}|", expectedUrl);
        Assert.assertTrue(currentPage.verifyTitleAndUrl(expectedPageTitle, expectedUrl));
        log.info("The page title and the URL are as expected.");
    }

    /**
     * Verifies the visibility of single elements specified in a list.
     *
     * @param elementDescriptions a list of descriptions of elements to verify
     */
    @And("I should see the following single elements:")
    public void i_should_see_the_following_single_elements(List<String> elementDescriptions) {
        elementDescriptions.forEach(elementDescription -> {
            Assert.assertTrue(currentPage.verifyVisibilityOfElement(elementDescription));
            log.info("The |{}| visible on the page", elementDescription);
        });
    }

    /**
     * Verifies the visibility of a list of elements specified in a list.
     *
     * @param elementDescriptions a list of descriptions of elements to verify
     */
    @And("I should see the following list of elements:")
    public void i_should_see_the_following_list_of_elements(List<String> elementDescriptions) {
        elementDescriptions.forEach(elementDescription -> {
            Assert.assertTrue(currentPage.verifyVisibilityOfElements(elementDescription));
            log.info("The |{}| visible on the page", elementDescription);
        });
    }

    /**
     * Verifies that the text of elements matches the expected values.
     *
     * @param dataTable a map of element descriptions to their expected text values
     */
    @And("The text of the element should match the expected value:")
    public void the_text_of_the_element_should_match_the_expected_value(Map<String, String> dataTable) {
        dataTable.forEach((elementDescription, expectedElementText) -> {
            String actualElementText = currentPage.getText(elementDescription);
            log.info("Expected text: |{}|", expectedElementText);
            log.info("Actual text: |{}|", actualElementText);
            Assert.assertEquals(expectedElementText, actualElementText);
            log.info("The text of the |{}| matched the expected value", elementDescription);
        });
    }

    /**
     * Verifies that the attribute values of elements match the expected values.
     *
     * @param attributeName           the name of the attribute to verify
     * @param elementDescription      the description of the element to verify
     * @param expectedAttributeValues a list of expected attribute values
     */
    @Then("The {string} values of the {string} should match the expected values:")
    public void the_values_of_the_should_match_the_expected_values(String attributeName, String elementDescription, List<String> expectedAttributeValues) {
        List<String> actualAttributeValues = currentPage.getAttributeValues(elementDescription, attributeName);
        log.info("Expected attribute value: |{}|", expectedAttributeValues);
        log.info("Actual attribute value: |{}|", actualAttributeValues);
        Assert.assertEquals(expectedAttributeValues, actualAttributeValues);
        log.info("The |{}| values of the |{}| matched the expected values", attributeName, elementDescription);
    }

    /**
     * Verifies that a specific attribute value of an element matches the expected value.
     *
     * @param attributeName the name of the attribute to verify
     * @param dataTable     a map of element descriptions to their expected attribute values
     */
    @Then("The {string} value of the element should match the expected value:")
    public void the_value_of_the_element_should_match_the_expected_value(String attributeName, Map<String, String> dataTable) {
        dataTable.forEach((elementDescription, expectedAttributeValue) -> {
            String actualAttributeValue = currentPage.getAttributeValue(elementDescription, attributeName);
            log.info("Expected attribute value: |{}|", expectedAttributeValue);
            log.info("Actual attribute value: |{}|", actualAttributeValue);
            Assert.assertEquals(expectedAttributeValue, actualAttributeValue);
            log.info("The |{}| value of the |{}| matched the expected value", attributeName, elementDescription);
        });
    }

    /**
     * Verifies that the texts of elements match the expected values.
     *
     * @param elementDescription the description of the element
     * @param expectedTexts      a list of expected text values for the elements
     */
    @Given("The texts of the {string} should match the expected values:")
    public void the_texts_of_the_should_match_the_expected_values(String elementDescription, List<String> expectedTexts) {
        List<String> actualTexts = currentPage.getTexts(elementDescription);
        log.info("Expected texts: |{}|", expectedTexts);
        log.info("Actual texts: |{}|", actualTexts);
        Assert.assertEquals(expectedTexts, actualTexts);
        log.info("The texts of the |{}| matched the expected values", elementDescription);
    }

    /**
     * Clears the input text of a specified element.
     *
     * @param elementDescription the description of the input element to clear
     */
    @When("I clear the {string}")
    public void i_clear_the(String elementDescription) {
        currentPage.clearInputBox(elementDescription);
        log.info("The text of the |{}| is cleared", elementDescription);
    }

    /**
     * Enters the specified input text into a given element.
     *
     * @param input              the text to enter
     * @param elementDescription the description of the element where the text will be entered
     */
    @When("I enter the {string} in the {string}")
    public void i_enter_the(String input, String elementDescription) {
        currentPage.sendInput(input, elementDescription);
        log.info("|{}| entered in the: |{}|", input, elementDescription);
    }
}