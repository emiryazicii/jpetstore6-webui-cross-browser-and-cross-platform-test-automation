package com.octoperf.jpetstore6.stepDefs;

import com.octoperf.jpetstore6.pages.P13_ShippingAddressPage;
import com.octoperf.jpetstore6.sharedData.ScenarioContextHolder;
import com.octoperf.jpetstore6.utilities.FakerUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Step definitions for interactions with the Shipping Address page in the JPetStore application.
 * Provides methods for verifying and entering shipping address information.
 */
@RequiredArgsConstructor
@Slf4j
public class SD11_ShippingAddressPage {

    private final P13_ShippingAddressPage shippingAddressPage;

    /**
     * Verifies that the address information retrieved from the scenario context matches the default shipping address information on the Shipping Address page.
     */
    @And("My address information and default shipping address information should match")
    public void my_address_information_and_default_shipping_address_information_should_match() {
        Map<String, String> expectedAddressInformation = ScenarioContextHolder.getContext().getListOfMap("addressData");
        Map<String, String> actualAddressInformation = shippingAddressPage.getDefaultShippingAddressData();
        log.info("Expected address information: |{}|", expectedAddressInformation);
        log.info("Actual address information: |{}|", actualAddressInformation);
        Assert.assertEquals(expectedAddressInformation, actualAddressInformation);
        log.info("My address information and default shipping address information matched");
    }

    /**
     * Clears all input boxes on the Shipping Address page.
     */
    @When("I clear the shipping address input boxes")
    public void i_clear_the_shipping_address_input_boxes() {
        shippingAddressPage.clearShippingAddressBoxes();
        log.info("The shipping address input boxes are cleared");
    }

    /**
     * Enters shipping address information into the Shipping Address page. The address information is partly retrieved from the scenario context and partly generated using FakerUtils.
     */
    @And("I enter the shipping address information")
    public void i_enter_the_shipping_address_information() {
        Map<String, String> shippingAddressData = new HashMap<>();

        String firstName = ScenarioContextHolder.getContext().getListOfMap("addressData").get("firstName");
        String lastName = ScenarioContextHolder.getContext().getListOfMap("addressData").get("lastName");
        String country = ScenarioContextHolder.getContext().getListOfMap("addressData").get("country");

        shippingAddressData.put("firstName", firstName);
        shippingAddressData.put("lastName", lastName);
        shippingAddressData.put("address1", FakerUtils.getRandomStreetAddress());
        shippingAddressData.put("address2", FakerUtils.getRandomBuildingNumber());
        shippingAddressData.put("city", FakerUtils.getRandomCity());
        shippingAddressData.put("state", FakerUtils.getRandomState());
        shippingAddressData.put("zip",FakerUtils.getRandomZipCode(shippingAddressData.get("state")));
        shippingAddressData.put("country", country);

        shippingAddressPage.enterShippingAddress(
                shippingAddressData.get("address1"),
                shippingAddressData.get("address2"),
                shippingAddressData.get("city"),
                shippingAddressData.get("state"),
                shippingAddressData.get("zip")
        );

        ScenarioContextHolder.getContext().setListOfMap("shippingAddressData", shippingAddressData);

        log.info("Address1 entered: |{}|", shippingAddressData.get("address1"));
        log.info("Address2 entered: |{}|", shippingAddressData.get("address2"));
        log.info("City entered: |{}|", shippingAddressData.get("city"));
        log.info("State entered: |{}|", shippingAddressData.get("state"));
        log.info("Zip code entered: |{}|", shippingAddressData.get("zip"));
        log.info("Shipping address information entered");
    }
}