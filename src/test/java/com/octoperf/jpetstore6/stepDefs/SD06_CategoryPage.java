package com.octoperf.jpetstore6.stepDefs;

import com.octoperf.jpetstore6.pages.P08_CategoryPage;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.Map;

/**
 * Step definitions for interactions with the Category page in the JPetStore application.
 * Provides methods for interacting with products and verifying their information and link attributes.
 */
@RequiredArgsConstructor
@Slf4j
public class SD06_CategoryPage {

    private final P08_CategoryPage categoryPage;

    /**
     * Clicks on a product specified by its ID.
     *
     * @param productId the ID of the product to click on.
     */
    @When("I click on the product {string}")
    public void i_click_on_the_product(String productId) {
        categoryPage.clickOnProductIdLink(productId);
        log.info("Clicked on the product: |{}|", productId);
    }

    /**
     * Verifies that the information of a product matches the expected values.
     *
     * @param productId the ID of the product to verify.
     * @param expectedProductInformation a map containing the expected product information.
     */
    @When("The information of the product {string} should match the expected value:")
    public void the_information_of_the_product_should_match_the_expected_value(String productId, Map<String, String> expectedProductInformation) {
        Map<String, String> actualProductInformation = categoryPage.getProductData(productId);
        log.info("Expected product information: |{}|", expectedProductInformation);
        log.info("Actual product information: |{}|", actualProductInformation);
        Assert.assertEquals(expectedProductInformation, actualProductInformation);
        log.info("The information of the product matched the expected value");
    }

    /**
     * Verifies that the href attribute of a product link matches the expected value.
     *
     * @param productId the ID of the product whose link href attribute is to be verified.
     * @param expectedHrefValue the expected href value of the product link.
     */
    @When("The href value of the product link {string} should match the expected value:")
    public void the_href_value_of_the_product_link_should_match_the_expected_value(String productId, String expectedHrefValue) {
        String actualHrefValue = categoryPage.getHrefByProductId(productId);
        log.info("Expected href value: |{}|", expectedHrefValue);
        log.info("Actual href value: |{}|", actualHrefValue);
        Assert.assertEquals(expectedHrefValue, actualHrefValue);
        log.info("The href value of the product link matched the expected value");
    }
}