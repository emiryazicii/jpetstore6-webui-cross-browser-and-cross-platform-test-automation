package com.octoperf.jpetstore6.stepDefs;

import com.octoperf.jpetstore6.pages.P03_CatalogPage;
import com.octoperf.jpetstore6.sharedData.ScenarioContextHolder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.Map;

/**
 * Step definitions for interactions with the Catalog page in the JPetStore application.
 * Provides methods to verify and interact with elements on the Catalog page using Cucumber scenarios.
 */
@RequiredArgsConstructor
@Slf4j
public class SD02_CatalogPage {

    private final P03_CatalogPage catalogPage;


    /**
     * Verifies that the welcome message on the Catalog page matches the expected value.
     * Retrieves the expected welcome message using the first name from the scenario context,
     * and compares it with the actual message displayed on the page.
     */
    @And("The text of the welcome message should match the expected value")
    public void the_text_of_the_welcome_message_should_match_the_expected_value() {
        String firstname = ScenarioContextHolder.getContext().getListOfMap("registrationData").get("firstName");
        String expectedWelcomeMessage = "Welcome " + firstname + "!";
        String actualWelcomeMessage = catalogPage.getText("welcome message");
        log.info("Expected message: |{}|", expectedWelcomeMessage);
        log.info("Actual message: |{}|", actualWelcomeMessage);
        Assert.assertEquals(expectedWelcomeMessage, actualWelcomeMessage);
        log.info("The welcome message matched the expected value");
    }

    /**
     * Verifies that the text in the "powered by" section of the Catalog page matches the expected value.
     *
     * @param expectedText the expected text for the "powered by" section.
     */
    @Then("The text of the powered by section should match the expected value")
    public void the_text_of_the_powered_by_section_should_match_the_expected_value(String expectedText) {
        String actualText = catalogPage.getPoweredByText();
        log.info("Expected text: |{}|", expectedText);
        log.info("Actual text: |{}|", actualText);
        Assert.assertEquals(expectedText, actualText);
        log.info("The text of the powered by section matched the expected value");
    }

    /**
     * Verifies that the text in the "hosted by" section of the Catalog page matches the expected value.
     *
     * @param expectedText the expected text for the "hosted by" section.
     */
    @Then("The text of the hosted by section should match the expected value")
    public void the_text_of_the_hosted_by_section_should_match_the_expected_value(String expectedText) {
        String actualText = catalogPage.getHostedByText();
        log.info("Expected text: |{}|", expectedText);
        log.info("Actual text: |{}|", actualText);
        Assert.assertEquals(expectedText, actualText);
        log.info("The text of the hosted by section matched the expected value");
    }

    /**
     * Verifies that the text of the links in the sidebar section matches the expected values.
     * Iterates through the provided data table to check each link's text.
     *
     * @param dataTable a map of category names to expected link texts.
     */
    @Then("The the text of the following links in the sidebar section should match the expected value")
    public void the_the_text_of_the_following_links_in_the_sidebar_section_should_match_the_expected_value(Map<String, String> dataTable) {
        dataTable.forEach((categoryName, expectedText) -> {
            String actualText = catalogPage.getTextInSideBarByCategoryName(categoryName);
            log.info("Expected text: |{}|", expectedText);
            log.info("Actual text: |{}|", actualText);
            Assert.assertEquals(expectedText, actualText);
            log.info("The text of the |{}| link matched the expected value", categoryName);
        });
    }

    /**
     * Clicks on a link in the sidebar section identified by its category name.
     *
     * @param categoryName the name of the category link to click.
     */
    @When("I click on the {string} in the sidebar section")
    public void i_click_on_the_in_the_sidebar_section(String categoryName) {
        catalogPage.clickLinkInSideBarByCategoryName(categoryName);
        log.info("Clicked on the |{}| in the sidebar section", categoryName);
    }

    /**
     * Clicks on a link in the quick links section identified by its category name.
     *
     * @param categoryName the name of the category link to click.
     */
    @When("I click on the {string} in the quick links section")
    public void i_click_on_the_in_the_quick_links_section(String categoryName) {
        catalogPage.clickLinkInQuickLinksByCategoryName(categoryName);
        log.info("Clicked on the |{}| in the quick links section", categoryName);
    }

    /**
     * Clicks on a link in the main image section identified by its category name.
     *
     * @param categoryName the name of the category link to click.
     */
    @When("I click on the {string} in the main image section")
    public void i_click_on_the_in_the_main_image_section(String categoryName) {
        catalogPage.clickLinkInMainImageByCategoryName(categoryName);
        log.info("Clicked on the |{}| in the main image section", categoryName);
    }

    /**
     * Verifies that the information of a product matches the expected values.
     * Retrieves the actual product information from the Catalog page and compares it with the provided expected values.
     *
     * @param searchInput                the search input used to find the product.
     * @param expectedProductInformation a map of expected product information.
     */
    @Then("The information of the product {string} should match the expected values:")
    public void the_information_of_the_product_should_match_the_expected_values(String searchInput, Map<String, String> expectedProductInformation) {
        Map<String, String> actualProductInformation = catalogPage.getProductData(searchInput);
        log.info("Expected product information: |{}|", expectedProductInformation);
        log.info("Actual product information: |{}|", actualProductInformation);
        Assert.assertEquals(expectedProductInformation, actualProductInformation);
        log.info("The information of the product |{}| matched the expected values", searchInput);
    }

    /**
     * Clicks on the product image for the specified product.
     *
     * @param productName the name of the product whose image to click.
     */
    @When("I click on the product image for {string}")
    public void i_click_on_the_product_image_for(String productName) {
        catalogPage.clickProductImageByProductName(productName);
        log.info("Clicked on the product image for |{}|", productName);
    }

    /**
     * Clicks on the product description for the specified product.
     *
     * @param productName the name of the product whose description to click.
     */
    @When("I click on the product description for {string}")
    public void i_click_on_the_product_description_for(String productName) {
        catalogPage.clickProductDescriptionByProductName(productName);
        log.info("Clicked on the product description for |{}|", productName);
    }

    /**
     * Clicks on the product ID for the specified product.
     *
     * @param productName the name of the product whose ID to click.
     */
    @When("I click on the product ID for {string}")
    public void i_click_on_the_product_id_for(String productName) {
        catalogPage.clickProductIdByProductName(productName);
        log.info("Clicked on the product ID for |{}|", productName);
    }

    /**
     * Verifies that there is exactly one warning message displayed.
     */
    @Then("There should be only one warning message")
    public void there_should_be_only_one_warning_message() {
        int expectedWarningMessageCount = 1;
        int actualWarningMessageCount = catalogPage.getElements("empty search warning messages").size();
        log.info("Expected warning message count: |{}|", expectedWarningMessageCount);
        log.info("Actual warning message count: |{}|", actualWarningMessageCount);
        Assert.assertEquals(expectedWarningMessageCount, actualWarningMessageCount);
        log.info("The warning message count matched the expected value");
    }

    /**
     * Verifies that there is exactly one product image displayed.
     */
    @Then("There should be only one product image")
    public void there_should_be_only_one_product_image() {
        int expectedProductImageCount = 1;
        int actualProductImageCount = catalogPage.getElements("product images").size();
        log.info("Expected product image count: |{}|", expectedProductImageCount);
        log.info("Actual product image count: |{}|", actualProductImageCount);
        Assert.assertEquals(expectedProductImageCount, actualProductImageCount);
        log.info("The product image count matched the expected value");
    }

    /**
     * Verifies that there is exactly one product description displayed.
     */
    @Then("There should be only one product description")
    public void there_should_be_only_one_product_description() {
        int expectedProductDescriptionCount = 1;
        int actualProductDescriptionCount = catalogPage.getElements("product descriptions").size();
        log.info("Expected product description count: |{}|", expectedProductDescriptionCount);
        log.info("Actual product description count: |{}|", actualProductDescriptionCount);
        Assert.assertEquals(expectedProductDescriptionCount, actualProductDescriptionCount);
        log.info("The product description count matched the expected value");
    }

    /**
     * Verifies that there is exactly one product name displayed.
     */
    @Then("There should be only one product name")
    public void there_should_be_only_one_product_name() {
        int expectedProductNameCount = 1;
        int actualProductNameCount = catalogPage.getElements("product names").size();
        log.info("Expected product name count: |{}|", expectedProductNameCount);
        log.info("Actual product name count: |{}|", actualProductNameCount);
        Assert.assertEquals(expectedProductNameCount, actualProductNameCount);
        log.info("The product name count matched the expected value");
    }

    /**
     * Verifies that there is exactly one product ID displayed.
     */
    @Then("There should be only one product ID")
    public void there_should_be_only_one_product_id() {
        int expectedProductIdCount = 1;
        int actualProductIdCount = catalogPage.getElements("product id texts").size();
        log.info("Expected product ID count: |{}|", expectedProductIdCount);
        log.info("Actual product ID count: |{}|", actualProductIdCount);
        Assert.assertEquals(expectedProductIdCount, actualProductIdCount);
        log.info("The product ID count matched the expected value");
    }

    /**
     * Verifies that the 'src' attribute value of the image for a specified product name matches the expected value.
     *
     * @param productName      the name of the product whose image 'src' value to verify.
     * @param expectedSrcValue the expected 'src' value of the product image.
     */
    @Then("The src value of the image for product name {string} should match the expected value:")
    public void the_src_value_of_the_image_for_product_name_should_match_the_expected_value(String productName, String expectedSrcValue) {
        String actualSrcValue = catalogPage.getSrcValueByProductName(productName);
        log.info("Expected src value: |{}|", expectedSrcValue);
        log.info("Actual src value: |{}|", actualSrcValue);
        Assert.assertEquals(expectedSrcValue, actualSrcValue);
        log.info("The src value of the image matched the expected value");
    }
}