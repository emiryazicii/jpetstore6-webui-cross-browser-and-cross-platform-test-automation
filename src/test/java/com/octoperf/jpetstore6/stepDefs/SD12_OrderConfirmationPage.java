package com.octoperf.jpetstore6.stepDefs;

import com.octoperf.jpetstore6.pages.P14_OrderConfirmationPage;
import com.octoperf.jpetstore6.sharedData.ScenarioContextHolder;
import io.cucumber.java.en.And;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.Map;

/**
 * Step definitions for interactions with the Order Confirmation page in the JPetStore application.
 * Provides methods for verifying and retrieving order confirmation details.
 */
@RequiredArgsConstructor
@Slf4j
public class SD12_OrderConfirmationPage {

    private final P14_OrderConfirmationPage orderConfirmationPage;

    /**
     * Verifies that the billing address information displayed on the Order Confirmation page matches the expected value.
     */
    @And("My billing address information should match the expected value")
    public void my_billing_address_information_should_match_the_expected_value() {
        Map<String,String> expectedBillingAddress = ScenarioContextHolder.getContext().getListOfMap("billingAddressData");
        Map<String,String> actualBillingAddress = orderConfirmationPage.getBillingAddressData();
        log.info("Expected billing address: |{}|",expectedBillingAddress);
        log.info("Actual billing address: |{}|",actualBillingAddress);
        Assert.assertEquals(expectedBillingAddress, actualBillingAddress);
        log.info("My billing address information matched the expected value");
    }

    /**
     * Verifies that the shipping address information displayed on the Order Confirmation page matches the expected value.
     */
    @And("My shipping address information should match the expected value")
    public void my_shipping_address_information_should_match_the_expected_value() {
        Map<String,String> expectedShippingAddress = ScenarioContextHolder.getContext().getListOfMap("shippingAddressData");
        Map<String,String> actualShippingAddress = orderConfirmationPage.getShippingAddressData();
        log.info("Expected shipping address: |{}|",expectedShippingAddress);
        log.info("Actual shipping address: |{}|",actualShippingAddress);
        Assert.assertEquals(expectedShippingAddress, actualShippingAddress);
        log.info("My shipping address information matched the expected value");
    }

    /**
     * Verifies that the confirmation instruction message text on the Order Confirmation page matches the expected value.
     *
     * @param expectedInstructionMessage The expected confirmation instruction message text.
     */
    @And("The confirmation instruction message text should match expected value")
    public void the_confirmation_instruction_message_should_match_the_expected_value(String expectedInstructionMessage) {
        String actualInstructionMessage = orderConfirmationPage.getConfirmationInstructionMessage();
        log.info("Expected instruction message: |{}|",expectedInstructionMessage);
        log.info("Actual instruction message: |{}|",actualInstructionMessage);
        Assert.assertEquals(expectedInstructionMessage, actualInstructionMessage);
        log.info("The confirmation instruction message text matched the expected value");
    }

    /**
     * Retrieves the order date and time from the Order Confirmation page and stores it in the scenario context.
     */
    @And("I retrieve the order date and time")
    public void i_retrieve_the_order_date_and_time() {
        String orderDateAndTime = orderConfirmationPage.getOrderDateAndTimeText();
        ScenarioContextHolder.getContext().setMap("orderDateAndTime", orderDateAndTime);
        log.info("The order date and time retrieved: |{}|",orderDateAndTime);
    }
}