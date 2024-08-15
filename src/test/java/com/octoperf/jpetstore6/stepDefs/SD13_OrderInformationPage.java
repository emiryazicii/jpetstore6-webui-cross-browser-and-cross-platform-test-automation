package com.octoperf.jpetstore6.stepDefs;

import com.octoperf.jpetstore6.pages.P15_OrderInformationPage;
import com.octoperf.jpetstore6.sharedData.ScenarioContextHolder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.Map;

/**
 * Step definitions for interactions with the Order Information page in the JPetStore application.
 * Provides methods for verifying and retrieving various details related to an order.
 */
@RequiredArgsConstructor
@Slf4j
public class SD13_OrderInformationPage {

    private final P15_OrderInformationPage orderInformationPage;

    /**
     * Retrieves the order ID from the Order Information page and stores it in the scenario context.
     */
    @And("I retrieve the order ID")
    public void i_retrieve_the_order_id_number() {
        String orderId = orderInformationPage.getOrderNumber();
        ScenarioContextHolder.getContext().setMap("orderId", orderId);
        log.info("Retrieved order ID: {}", orderId);
    }

    /**
     * Verifies that the href value of the item link for the specified item ID matches the expected value.
     *
     * @param itemId          The ID of the item.
     * @param expectedHrefValue The expected href value of the item link.
     */
    @Then("The href value of the item link for the item {string} should match the expected value:")
    public void the_href_value_of_the_item_link_for_the_item_should_match_the_expected_value(String itemId, String expectedHrefValue) {
        String actualHrefValue = orderInformationPage.getHrefValueByItemId(itemId);
        log.info("Expected href value: |{}|", expectedHrefValue);
        log.info("Actual href value: |{}|", actualHrefValue);
        Assert.assertEquals(expectedHrefValue, actualHrefValue);
        log.info("The href value of the item link matched the expected value");
    }

    /**
     * Verifies that the order date and time displayed on the Order Information page match the expected value.
     */
    @And("The order date and time should match the expected value")
    public void the_order_date_and_time_should_match_the_expected_value() {
        String actualOrderDateAndTime = orderInformationPage.getOrderDateAndTime();
        String expectedOrderDateAndTime = ScenarioContextHolder.getContext().getMap("orderDateAndTime");
        log.info("Expected order date and time: |{}|", expectedOrderDateAndTime);
        log.info("Actual order date and time: |{}|", actualOrderDateAndTime);
        Assert.assertEquals(expectedOrderDateAndTime, actualOrderDateAndTime);
        log.info("The order date and time matched the expected value");
    }

    /**
     * Verifies that the text of the card number warning message matches the expected value.
     *
     * @param expectedWarningMessage The expected text of the card number warning message.
     */
    @And("The text of the card number warning match the expected value")
    public void the_text_of_card_number_warning_match_the_expected_value(String expectedWarningMessage) {
        String actualCardNumberWarning = orderInformationPage.getCardNumberWarning();
        log.info("Expected warning message: |{}|", expectedWarningMessage);
        log.info("Actual warning message: |{}|", actualCardNumberWarning);
        Assert.assertEquals(expectedWarningMessage, actualCardNumberWarning);
        log.info("The text of the card number warning matched the expected value");
    }

    /**
     * Verifies that the courier information displayed on the Order Information page matches the expected value.
     *
     * @param expectedCourierInformation The expected courier information.
     */
    @And("The courier information should match the expected value")
    public void the_courier_information_should_match_the_expected_value(String expectedCourierInformation) {
        String actualCourierInformation = orderInformationPage.getCourier();
        log.info("Expected courier information: |{}|", expectedCourierInformation);
        log.info("Actual courier information: |{}|", actualCourierInformation);
        Assert.assertEquals(expectedCourierInformation, actualCourierInformation);
        log.info("The courier information matched the expected value");
    }

    /**
     * Verifies that the order status displayed on the Order Information page matches the expected value.
     *
     * @param expectedOrderStatus The expected order status.
     */
    @And("The order status should match the expected value")
    public void the_order_status_should_match_the_expected_value(String expectedOrderStatus) {
        String actualOrderStatus = orderInformationPage.getOrderStatus();
        log.info("Expected order status: |{}|", expectedOrderStatus);
        log.info("Actual order status: |{}|", actualOrderStatus);
        Assert.assertEquals(expectedOrderStatus, actualOrderStatus);
        log.info("The order status matched the expected value");
    }

    /**
     * Verifies that the subtotal displayed on the Order Information page matches the expected value.
     */
    @And("The subtotal should match the expected value")
    public void the_subtotal_should_match_the_expected_value() {
        String actualSubtotal = orderInformationPage.getSubtotal();
        String expectedSubtotal = ScenarioContextHolder.getContext().getMap("subtotal");
        log.info("Expected subtotal: |{}|", expectedSubtotal);
        log.info("Actual subtotal: |{}|", actualSubtotal);
        Assert.assertEquals(expectedSubtotal, actualSubtotal);
        log.info("The subtotal matched the expected value");
    }

    /**
     * Verifies that the payment details displayed on the Order Information page match the expected value.
     */
    @And("The payment details should match the expected value")
    public void the_payment_details_should_match_the_expected_value() {
        Map<String, String> actualPaymentDetails = orderInformationPage.getPaymentDetails();
        Map<String, String> expectedPaymentDetails = ScenarioContextHolder.getContext().getListOfMap("paymentData");
        log.info("Expected payment details: |{}|", expectedPaymentDetails);
        log.info("Actual payment details: |{}|", actualPaymentDetails);
        Assert.assertEquals(expectedPaymentDetails,actualPaymentDetails);
        log.info("The payment details matched the expected value");
    }

    /**
     * Verifies that the billing address information displayed on the Order Information page matches the expected value.
     */
    @And("The billing address should match the expected value")
    public void the_billing_address_should_match_the_expected_value() {
        Map<String, String> actualBillingAddress = orderInformationPage.getBillingAddress();
        Map<String, String> expectedBillingAddress = ScenarioContextHolder.getContext().getListOfMap("addressData");
        log.info("Expected billing address: |{}|", expectedBillingAddress);
        log.info("Actual billing address: |{}|", actualBillingAddress);
        Assert.assertEquals(expectedBillingAddress,actualBillingAddress);
        log.info("The billing address matched the expected value");
    }

    /**
     * Verifies that the shipping address information displayed on the Order Information page matches the expected value.
     */
    @And("The shipping address should match the expected value")
    public void the_shipping_address_should_match_the_expected_value() {
        Map<String, String> actualShippingAddress = orderInformationPage.getShippingAddress();
        Map<String, String> expectedShippingAddress = ScenarioContextHolder.getContext().getListOfMap("shippingAddressData");
        log.info("Expected shipping address: |{}|", expectedShippingAddress);
        log.info("Actual shipping address: |{}|", actualShippingAddress);
        Assert.assertEquals(expectedShippingAddress,actualShippingAddress);
        log.info("The shipping address matched the expected value");
    }

    /**
     * Verifies that the item information for the specified item ID matches the expected value.
     *
     * @param itemId The ID of the item.
     */
    @And("The item information for item ID {string} should match the expected value")
    public void the_item_information_for_item_id_should_match_the_expected_value(String itemId) {
        Map<String,String> actualItemInformation = orderInformationPage.getItemInformationByItemId(itemId);
        Map<String, String> expectedItemInformation = ScenarioContextHolder.getContext().getListOfMap("itemInformation");
        log.info("Expected item information: |{}|", expectedItemInformation);
        log.info("Actual item information: |{}|", actualItemInformation);
        Assert.assertEquals(expectedItemInformation,actualItemInformation);
        log.info("The item information matched the expected value");
    }
}