package com.octoperf.jpetstore6.stepDefs;

import com.octoperf.jpetstore6.pages.P11_CartPage;
import com.octoperf.jpetstore6.sharedData.ScenarioContextHolder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Step definitions for interactions with the Cart page in the JPetStore application.
 * Provides methods for verifying and interacting with items in the cart.
 */
@RequiredArgsConstructor
@Slf4j
public class SD09_CartPage {

    private final P11_CartPage cartPage;

    /**
     * Verifies that the text of the remove button for a specific item ID matches the expected value.
     *
     * @param itemId                  the ID of the item for which the remove button text is being verified.
     * @param expectedRemoveButtonText the expected text of the remove button.
     */
    @Then("The text of the remove button for item ID {string} should match the expected value {string}")
    public void the_text_of_the_remove_button_for_item_id_should_match_the_expected_value(String itemId, String expectedRemoveButtonText) {
        String actualRemoveButtonText = cartPage.getRemoveButtonTextByItemId(itemId);
        log.info("Expected remove button text: |{}|", expectedRemoveButtonText);
        log.info("Actual remove button text: |{}|", actualRemoveButtonText);
        Assert.assertEquals(expectedRemoveButtonText, actualRemoveButtonText);
        log.info("The text of the remove button for item ID {} matched the expected value", itemId);
    }

    /**
     * Verifies that the href value of the remove button for a specific item ID matches the expected value.
     *
     * @param itemId                    the ID of the item for which the remove button href is being verified.
     * @param expectedRemoveButtonHrefValue the expected href value of the remove button.
     */
    @Then("The href value of the remove button for item ID {string} should match the expected value {string}")
    public void the_href_value_of_the_remove_button_for_item_id_should_match_the_expected_value(String itemId, String expectedRemoveButtonHrefValue) {
        String actualRemoveButtonHrefValue = cartPage.getHrefValueOfRemoveButtonByItemId(itemId);
        log.info("Expected remove button href value: |{}|", expectedRemoveButtonHrefValue);
        log.info("Actual remove button href value: |{}|", actualRemoveButtonHrefValue);
        Assert.assertEquals(expectedRemoveButtonHrefValue, actualRemoveButtonHrefValue);
        log.info("The href value of the remove button for item ID {} matched the expected value", itemId);
    }

    /**
     * Verifies that the item data for a specific item ID matches the expected values.
     *
     * @param itemId      the ID of the item for which data is being verified.
     * @param dataTable   a map containing the expected item data.
     */
    @Then("The item data for item ID {string} should match the expected value")
    public void the_item_data_for_item_id_should_match_the_expected_value(String itemId, Map<String, String> dataTable) {
        Map<String, String> expectedItemData = new HashMap<>(dataTable);
        expectedItemData.put("In Stock?", ScenarioContextHolder.getContext().getMap("stockInfo"));
        Map<String, String> actualItemData = cartPage.getItemsData().get(itemId);
        log.info("Expected item data: |{}|", expectedItemData);
        log.info("Actual item data: |{}|", actualItemData);
        Assert.assertEquals(expectedItemData, actualItemData);
        log.info("The item data for item ID {} matched the expected value", itemId);
    }

    /**
     * Enters the specified quantity for a specific item ID.
     *
     * @param quantity the quantity to be entered.
     * @param itemId   the ID of the item for which the quantity is being set.
     */
    @When("I enter the quantity {string} for item id {string}")
    public void i_enter_the_the_quantity_for_item_id(String quantity, String itemId) {
        cartPage.enterQuantity(itemId, quantity);
        log.info("Quantity: |{}| entered for the item: |{}|", quantity, itemId);
    }

    /**
     * Clicks on the remove button for a specific item ID.
     *
     * @param itemId the ID of the item for which the remove button is clicked.
     */
    @Then("I click on the remove button for item id {string}")
    public void i_click_on_the_remove_button_for_item_id(String itemId) {
        cartPage.clickRemoveButtonByItemId(itemId);
        log.info("Clicked on the remove button for item ID: |{}|", itemId);
    }

    /**
     * Verifies that the subtotal matches the expected value.
     *
     * @param expectedSubtotal the expected subtotal value.
     */
    @Then("The subtotal should match the expected value:")
    public void the_subtotal_should_match_the_expected_value(String expectedSubtotal) {
        String actualSubtotal = cartPage.getSubtotal();
        log.info("Expected subtotal: |{}|", expectedSubtotal);
        log.info("Actual subtotal: |{}|", actualSubtotal);
        Assert.assertEquals(expectedSubtotal, actualSubtotal);
        log.info("The subtotal matched the expected value");
    }

    /**
     * Retrieves and stores the item information for a specific item ID in the scenario context.
     *
     * @param itemId the ID of the item for which information is retrieved.
     */
    @And("I retrieve the item information for item ID {string}")
    public void i_retrieve_the_item_information_for_item_ID(String itemId) {
        Map<String,String> itemInformation = cartPage.getItemInfoByItemId(itemId);
        ScenarioContextHolder.getContext().setListOfMap("itemInformation", itemInformation);
        log.info("The item information: |{}| retrieved for the item: |{}|",itemInformation,itemId);
    }

    /**
     * Retrieves and stores the subtotal in the scenario context.
     */
    @And("I retrieve the subtotal")
    public void i_retrieve_the_subtotal(){
        String subtotal = cartPage.getSubtotal();
        ScenarioContextHolder.getContext().setMap("subtotal",subtotal);
        log.info("The subtotal retrieved: |{}|", subtotal);
    }
}