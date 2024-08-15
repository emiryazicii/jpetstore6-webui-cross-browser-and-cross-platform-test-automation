package com.octoperf.jpetstore6.stepDefs;

import com.octoperf.jpetstore6.pages.P09_ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.Map;

/**
 * Step definitions for interactions with the Product page in the JPetStore application.
 * Provides methods for interacting with items and verifying their information and link attributes.
 */
@RequiredArgsConstructor
@Slf4j
public class SD07_ProductPage {

    private final P09_ProductPage productPage;

    /**
     * Clicks on the item link specified by its ID.
     *
     * @param itemId the ID of the item to click on.
     */
    @When("I click on the item link for item ID {string}")
    public void i_click_on_the_item_link_for_item_id(String itemId) {
        productPage.clickItemIdLink(itemId);
        log.info("Clicked on the item link for item ID {}",itemId);
    }

    /**
     * Verifies that the information of an item matches the expected values.
     *
     * @param itemId the ID of the item to verify.
     * @param expectedItemInformation a map containing the expected item information.
     */
    @Then("The information of the item {string} should match the expected value:")
    public void the_information_of_the_item_should_match_the_expected_value(String itemId, Map<String, String> expectedItemInformation) {
        Map<String, String> actualItemInformation = productPage.getItemData(itemId);
        log.info("Expected item information: |{}|", expectedItemInformation);
        log.info("Actual item information: |{}|", actualItemInformation);
        Assert.assertEquals(expectedItemInformation, actualItemInformation);
        log.info("The information of the item for the item ID {} matched the expected value", itemId);
    }

    /**
     * Verifies that the href attribute of an item link matches the expected value.
     *
     * @param itemId the ID of the item whose link href attribute is to be verified.
     * @param expectedHrefValue the expected href value of the item link.
     */
    @Then("The href value of the item link {string} should match the expected value:")
    public void the_href_value_of_the_item_link_should_match_the_expected_value(String itemId, String expectedHrefValue) {
        String actualHrefValue = productPage.getHrefByItemId(itemId);
        log.info("Expected href value: |{}|", expectedHrefValue);
        log.info("Actual href value: |{}|", actualHrefValue);
        Assert.assertEquals(expectedHrefValue, actualHrefValue);
        log.info("The href value of the item link {} matched the expected value", itemId);
    }

    /**
     * Verifies that the href attribute of the add-to-cart button for an item matches the expected value.
     *
     * @param itemId the ID of the item whose add-to-cart button href attribute is to be verified.
     * @param expectedHrefValue the expected href value of the add-to-cart button.
     */
    @Then("The href value of the add to cart button for item ID {string} should match the expected value:")
    public void the_href_value_of_the_add_to_cart_button_for_item_id_should_match_the_expected_value(String itemId, String expectedHrefValue) {
        String actualHrefValue = productPage.getHrefValueOfAddToCartButtonByItemId(itemId);
        log.info("Expected href value: |{}|", expectedHrefValue);
        log.info("Actual href value: |{}|", actualHrefValue);
        Assert.assertEquals(expectedHrefValue, actualHrefValue);
        log.info("The href value of the add to cart button for item ID {} matched the expected value", itemId);
    }
}