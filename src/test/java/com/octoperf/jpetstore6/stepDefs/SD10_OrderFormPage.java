package com.octoperf.jpetstore6.stepDefs;

import com.octoperf.jpetstore6.pages.P12_OrderFormPage;
import com.octoperf.jpetstore6.sharedData.ScenarioContextHolder;
import com.octoperf.jpetstore6.utilities.FakerUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Step definitions for interactions with the Order Form page in the JPetStore application.
 * Provides methods for verifying and entering payment details, as well as managing address information.
 */
@RequiredArgsConstructor
@Slf4j
public class SD10_OrderFormPage {

    private final P12_OrderFormPage orderFormPage;

    /**
     * Verifies that the default values of the payment details on the order form match the expected values.
     *
     * @param expectedDefaultPaymentDetails a map containing the expected default payment details.
     */
    @Then("The default values of the payment details should match the expected values:")
    public void the_default_values_of_the_payment_details_should_match_the_expected_values(Map<String, String> expectedDefaultPaymentDetails) {
        Map<String, String> actualDefaultPaymentDetails = orderFormPage.getPaymentDetailsData();
        log.info("Expected payment details: |{}|", expectedDefaultPaymentDetails);
        log.info("Actual payment details: |{}|", actualDefaultPaymentDetails);
        Assert.assertEquals(expectedDefaultPaymentDetails, actualDefaultPaymentDetails);
        log.info("The default values of the payment details matched the expected values:");
    }

    /**
     * Verifies that the address information retrieved from the scenario context matches the default billing address information on the order form.
     */
    @Then("My address information and default billing address information should match")
    public void my_address_information_and_default_billing_address_information_should_match() {
        Map<String, String> expectedAddressInformation = ScenarioContextHolder.getContext().getListOfMap("addressData");
        Map<String, String> actualAddressInformation = orderFormPage.getBillingAddressData();
        log.info("Expected address information: |{}|", expectedAddressInformation);
        log.info("Actual address information: |{}|", actualAddressInformation);
        Assert.assertEquals(expectedAddressInformation, actualAddressInformation);
        log.info("My address information and default billing address information matched");
    }

    /**
     * Enters payment details into the order form. The details are randomly generated using FakerUtils.
     */
    @When("I enter the payment details")
    public void i_enter_the_payment_details() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("cardType", FakerUtils.getRandomCardType());
        paymentData.put("cardNumber", FakerUtils.getRandomCreditCardNumber());
        paymentData.put("expiryDate", FakerUtils.getRandomCardExpirationDate());

        orderFormPage.enterPaymentDetails(
                paymentData.get("cardType"),
                paymentData.get("cardNumber"),
                paymentData.get("expiryDate")
        );

        ScenarioContextHolder.getContext().setListOfMap("paymentData", paymentData);

        log.info("CardType entered: |{}|",paymentData.get("cardType"));
        log.info("CardNumber entered: |{}|",paymentData.get("cardNumber"));
        log.info("Expiry Date entered: |{}|",paymentData.get("expiryDate"));
        log.info("Payment information entered");
    }

    /**
     * Retrieves and stores the billing address information from the order form in the scenario context.
     */
    @And("I retrieve my billing address information")
    public void i_retrieve_my_billing_address_information() {
        Map<String,String> billingAddress = orderFormPage.getBillingAddressData();
        ScenarioContextHolder.getContext().setListOfMap("billingAddressData", billingAddress);
        log.info("My billing address retrieved: |{}|",billingAddress);
    }
}