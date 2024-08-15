package com.octoperf.jpetstore6.stepDefs;

import com.octoperf.jpetstore6.pages.P05_RegistrationPage;
import com.octoperf.jpetstore6.sharedData.ScenarioContextHolder;
import com.octoperf.jpetstore6.utilities.FakerUtils;
import com.octoperf.jpetstore6.utilities.SelectUtils;
import com.octoperf.jpetstore6.utilities.WaitUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Step definitions for interactions with the Registration page in the JPetStore application.
 * Provides methods for verifying elements and registering a new user using randomly generated data.
 */
@RequiredArgsConstructor
@Slf4j
public class SD03_RegistrationPage {

    private final P05_RegistrationPage registrationPage;

    /**
     * Verifies that the status of a specified element matches the expected value.
     *
     * @param elementDescription the description of the element whose status is to be checked
     * @param expectedStatus the expected status of the element
     */
    @Given("The status of the {string} should match the expected value {string}")
    public void the_status_of_the_should_match_the_expected_value(String elementDescription, String expectedStatus) {
        String actualStatus = registrationPage.isChecked(elementDescription);
        log.info("Expected status: |{}|", expectedStatus);
        log.info("Actual status: |{}|", actualStatus);
        Assert.assertEquals(expectedStatus, actualStatus);
        log.info("The status of the |{}| matched the expected value", elementDescription);
    }

    /**
     * Verifies that the first selected option text of multiple dropdowns matches the expected values.
     *
     * @param dataTable a map where keys are dropdown descriptions and values are the expected first selected option texts
     */
    @Then("The first selected option text of the following dropdown should match the expected value")
    public void the_first_selected_option_text_of_the_following_dropdown_should_match_the_expected_value(Map<String,String> dataTable) {
        dataTable.forEach((dropdownDescription,expectedFirstSelectedOptionText)->{
            String actualFirstSelectedOptionText = WaitUtils.getTextAfterWait(SelectUtils.getFirstSelectedOption(registrationPage.getElement(dropdownDescription)));
            log.info("Expected first selected option text: |{}|", expectedFirstSelectedOptionText);
            log.info("Actual first selected option text: |{}|", actualFirstSelectedOptionText);
            Assert.assertEquals(expectedFirstSelectedOptionText, actualFirstSelectedOptionText);
            log.info("The first selected option text of the |{}| matched the expected value", dropdownDescription);
        });
    }

    /**
     * Verifies that all options texts of a specified dropdown match the expected values.
     *
     * @param dropdownDescription the description of the dropdown element
     * @param expectedOptionsTexts a list of expected option texts
     */
    @Then("The all options texts of the {string} should match the expected values:")
    public void the_all_options_texts_of_the_should_match_the_expected_values(String dropdownDescription, List<String> expectedOptionsTexts) {
        List<String> actualOptionsTexts = SelectUtils.getTextOfAllOptions(registrationPage.getElement(dropdownDescription));
        log.info("Expected all options texts: |{}|", expectedOptionsTexts);
        log.info("Actual all options texts: |{}|", actualOptionsTexts);
        Assert.assertEquals(expectedOptionsTexts, actualOptionsTexts);
        log.info("All options texts of the |{}| matched the expected values", dropdownDescription);
    }

    /**
     * Registers a new user with randomly generated data and stores registration details in the scenario context.
     */
    @When("I create a new user account using randomly generated data")
    public void i_create_a_new_user_account_using_randomly_generated_data() {

        Map<String, String> registrationData = new HashMap<>();
        registrationData.put("userId", FakerUtils.getRandomUsername());
        registrationData.put("password", FakerUtils.getRandomPassword());
        registrationData.put("firstName", FakerUtils.retrieveFirstName(registrationData.get("userId")));
        registrationData.put("lastName", FakerUtils.retrieveLastName(registrationData.get("userId")));
        registrationData.put("email", FakerUtils.getRandomEmail(registrationData.get("firstName"), registrationData.get("lastName")));
        registrationData.put("phone", FakerUtils.getRandomPhoneNumber());
        registrationData.put("address1", FakerUtils.getRandomStreetAddress());
        registrationData.put("address2", FakerUtils.getRandomBuildingNumber());
        registrationData.put("city", FakerUtils.getRandomCity());
        registrationData.put("state", FakerUtils.getRandomState());
        registrationData.put("zip", FakerUtils.getRandomZipCode(registrationData.get("state")));
        registrationData.put("country", "USA");
        registrationData.put("languagePreference", FakerUtils.getRandomLanguagePreference());
        registrationData.put("favouriteCategory", FakerUtils.getRandomFavouriteCategory());

        registrationPage.registerNewUser(
                registrationData.get("userId"),
                registrationData.get("password"),
                registrationData.get("firstName"),
                registrationData.get("lastName"),
                registrationData.get("email"),
                registrationData.get("phone"),
                registrationData.get("address1"),
                registrationData.get("address2"),
                registrationData.get("city"),
                registrationData.get("state"),
                registrationData.get("zip"),
                registrationData.get("country"),
                registrationData.get("languagePreference"),
                registrationData.get("favouriteCategory")
        );

        registrationData.put("enableMyListCheckboxStatus", registrationPage.isChecked("enable my list checkbox"));
        registrationData.put("enableMyBannerCheckboxStatus", registrationPage.isChecked("enable my banner checkbox"));

        ScenarioContextHolder.getContext().setListOfMap("registrationData", registrationData);

        log.info("Username entered: |{}|", registrationData.get("userId"));
        log.info("Password entered: |{}|", registrationData.get("password"));
        log.info("Password entered again: |{}|", registrationData.get("password"));
        log.info("Firstname entered: |{}|", registrationData.get("firstName"));
        log.info("Lastname entered: |{}|", registrationData.get("lastName"));
        log.info("Email entered: |{}|", registrationData.get("email") );
        log.info("Phone entered: |{}|", registrationData.get("phone"));
        log.info("Street address entered: |{}|", registrationData.get("address1"));
        log.info("Building number entered: |{}|", registrationData.get("address2"));
        log.info("City entered: |{}|", registrationData.get("city"));
        log.info("State entered: |{}|",  registrationData.get("state"));
        log.info("Zip entered: |{}|", registrationData.get("zip"));
        log.info("Country entered: |{}|", "USA");
        log.info("Language preference selected: |{}|", registrationData.get("languagePreference"));
        log.info("Favourite category selected: |{}|",  registrationData.get("favouriteCategory"));
        log.info("Enable MyListCheckbox status: |{}|", registrationData.get("enableMyListCheckboxStatus"));
        log.info("Enable MyBannerCheckbox status: |{}|", registrationData.get("enableMyBannerCheckboxStatus"));
        registrationPage.clickOn("save account information button");
        log.info("New user created");
    }
}