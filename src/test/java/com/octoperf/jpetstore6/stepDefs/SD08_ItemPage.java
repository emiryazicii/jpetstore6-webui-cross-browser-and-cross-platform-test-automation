package com.octoperf.jpetstore6.stepDefs;

import com.octoperf.jpetstore6.pages.P10_ItemPage;
import com.octoperf.jpetstore6.sharedData.ScenarioContextHolder;
import io.cucumber.java.en.And;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Step definitions for interactions with the Item page in the JPetStore application.
 * Provides methods for verifying item details and managing stock information.
 */
@RequiredArgsConstructor
@Slf4j
public class SD08_ItemPage {

    private final P10_ItemPage itemPage;

    /**
     * Verifies that the detailed information of an item matches the expected values.
     *
     * @param dataTable a map containing the expected detailed item information.
     */
    @And("The detailed information of the item should match the expected value:")
    public void the_detailed_information_of_the_item_should_match_the_expected_value(Map<String, String> dataTable) {
        Map<String, String> expectedDetailedItemInformation = new HashMap<>(dataTable);
        expectedDetailedItemInformation.put("stockInfo", itemPage.getDetailedItemInformation().get("stockInfo"));
        Map<String, String> actualDetailedItemInformation = itemPage.getDetailedItemInformation();
        log.info("Expected item information: |{}|", expectedDetailedItemInformation);
        log.info("Actual item information: |{}|", actualDetailedItemInformation);
        Assert.assertEquals(expectedDetailedItemInformation, actualDetailedItemInformation);
        log.info("The detailed item information matched the expected value");
    }

    /**
     * Retrieves and stores the most recent stock information of the item.
     */
    @And("I retrieve the most recent stock information")
    public void i_retrieve_the_most_recent_stock_information() {
        String itemID = itemPage.getDetailedItemInformation().get("itemId");
        String theMostRecentStockInfo = itemPage.getDetailedItemInformation().get("stockInfo");
        ScenarioContextHolder.getContext().setMap("stockInfo", theMostRecentStockInfo);
        log.info("The most recent stock information: |{}| retrieved and stored for the item: |{}|", theMostRecentStockInfo, itemID);
    }
}