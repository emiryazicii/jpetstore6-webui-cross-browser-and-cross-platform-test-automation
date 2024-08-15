package com.octoperf.jpetstore6.stepDefs;

import com.octoperf.jpetstore6.pages.P16_MyOrdersPage;
import com.octoperf.jpetstore6.sharedData.ScenarioContextHolder;
import io.cucumber.java.en.And;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Step definitions for interactions with the My Orders page in the JPetStore application.
 * Provides methods for verifying the details of an order displayed on the My Orders page.
 */
@RequiredArgsConstructor
@Slf4j
public class SD14_MyOrdersPage {

    private final P16_MyOrdersPage myOrdersPage;

    /**
     * Verifies that the order information displayed on the My Orders page matches the expected values.
     * The order ID, date and time, and subtotal are retrieved from the scenario context and compared with
     * the actual order information displayed on the page.
     * The expected values are:
     * - Order ID: Retrieved from the scenario context under the key "orderId"
     * - Date and Time: Retrieved from the scenario context under the key "orderDateAndTime"
     * - Subtotal: Retrieved from the scenario context under the key "subtotal"
     * The actual values are fetched from the My Orders page using the order ID.
     * Logs the expected and actual values for debugging purposes and asserts that they are equal.
     */
    @And("The order information should match the expected value")
    public void the_order_information_should_match_the_expected_value() {
        String orderId = ScenarioContextHolder.getContext().getMap("orderId");
        String expectedDateAndTime = ScenarioContextHolder.getContext().getMap("orderDateAndTime");
        String expectedSubtotal = ScenarioContextHolder.getContext().getMap("subtotal");

        Map<String, String> actualOrderInformation = myOrdersPage.getOrderDataByOrderId(orderId);
        Map<String, String> expectedOrderInformation = new HashMap<>();
        expectedOrderInformation.put("Order ID", orderId);
        expectedOrderInformation.put("Date", expectedDateAndTime);
        expectedOrderInformation.put("Total Price", expectedSubtotal);

        log.info("Expected order information: |{}|", expectedOrderInformation);
        log.info("Actual order information: |{}|", actualOrderInformation);
        Assert.assertEquals(expectedOrderInformation, actualOrderInformation);
        log.info("The order information matched the expected value");
    }
}