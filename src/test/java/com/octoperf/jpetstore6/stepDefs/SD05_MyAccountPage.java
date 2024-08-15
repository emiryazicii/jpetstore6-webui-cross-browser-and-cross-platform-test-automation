package com.octoperf.jpetstore6.stepDefs;

import com.octoperf.jpetstore6.pages.P07_MyAccountPage;
import com.octoperf.jpetstore6.sharedData.ScenarioContextHolder;
import com.octoperf.jpetstore6.utilities.FakerUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Step definitions for interactions with the My Account page in the JPetStore application.
 * Provides methods for retrieving account and address information and verifying that the account information matches the registration data.
 */
@RequiredArgsConstructor
@Slf4j
public class SD05_MyAccountPage {

    private final P07_MyAccountPage myAccountPage;

    /**
     * Retrieves the account information and stores it in the scenario context.
     * The retrieved information is stored under the key "accountData".
     */
    @When("I retrieve my account information")
    public void i_retrieve_my_account_information() {
        Map<String, String> accountData = myAccountPage.getMyAccountData();
        ScenarioContextHolder.getContext().setListOfMap("accountData", accountData);
        log.info("My account information retrieved and stored : |{}|", accountData);
    }

    /**
     * Retrieves the address information and stores it in the scenario context.
     * The retrieved information is stored under the key "addressData".
     */
    @Given("I retrieve my address information")
    public void i_retrieve_my_address_information() {
        Map<String, String> addressData = myAccountPage.getMyAddressData();
        ScenarioContextHolder.getContext().setListOfMap("addressData", addressData);
        log.info("My address information retrieved and stored : |{}|", addressData);
    }

    /**
     * Verifies that the account information matches the registration information.
     * The registration data is retrieved from the scenario context and compared with the account information,
     * excluding the password field.
     */
    @Then("My account information should match my registration information")
    public void my_account_information_should_match_my_registration_information() {
        Map<String, String> registrationData = ScenarioContextHolder.getContext().getListOfMap("registrationData");
        registrationData.remove("password");
        Map<String, String> accountData = ScenarioContextHolder.getContext().getListOfMap().get("accountData");
        log.info("Expected account data: |{}|", accountData);
        log.info("Actual account data: |{}|", registrationData);
        Assert.assertEquals(registrationData, accountData);
        log.info("My account information matched my registration information");
    }

    /**
     * Updates the account information with new data and stores the updated information in the scenario context under the key
     * "updatedAccountInformation". The updated data includes new values for various fields including password, email, phone,
     * and address.
     */
    @When("I update my account information")
    public void i_update_my_account_information() {
        Map<String, String> updatedAccountInformation = new HashMap<>();
        String firstName = ScenarioContextHolder.getContext().getListOfMap("registrationData").get("firstName");
        String lastName = ScenarioContextHolder.getContext().getListOfMap("registrationData").get("lastName");
        String state = FakerUtils.getRandomState();

        updatedAccountInformation.put("firstName", firstName);
        updatedAccountInformation.put("lastName", lastName);
        updatedAccountInformation.put("newPassword", FakerUtils.getRandomPassword());
        updatedAccountInformation.put("email", FakerUtils.getRandomEmail());
        updatedAccountInformation.put("phone", FakerUtils.getRandomPhoneNumber());
        updatedAccountInformation.put("address1", FakerUtils.getRandomStreetAddress());
        updatedAccountInformation.put("address2", FakerUtils.getRandomBuildingNumber());
        updatedAccountInformation.put("city", FakerUtils.getRandomCity());
        updatedAccountInformation.put("state", state);
        updatedAccountInformation.put("zip", FakerUtils.getRandomZipCode(state));

        ScenarioContextHolder.getContext().setListOfMap("updatedAccountInformation", updatedAccountInformation);

        myAccountPage.updateMyAccountInformation(
                updatedAccountInformation.get("newPassword"),
                updatedAccountInformation.get("email"),
                updatedAccountInformation.get("phone"),
                updatedAccountInformation.get("address1"),
                updatedAccountInformation.get("address2"),
                updatedAccountInformation.get("city"),
                updatedAccountInformation.get("state"),
                updatedAccountInformation.get("zip")
        );

        log.info("New password entered: |{}|", updatedAccountInformation.get("newPassword"));
        log.info("New email entered: |{}|", updatedAccountInformation.get("email"));
        log.info("New phone number entered: |{}|", updatedAccountInformation.get("phone"));
        log.info("New address1 entered: |{}|", updatedAccountInformation.get("address1"));
        log.info("New address2 entered: |{}|", updatedAccountInformation.get("address2"));
        log.info("New city entered: |{}|", updatedAccountInformation.get("city"));
        log.info("New state entered: |{}|", updatedAccountInformation.get("state"));
        log.info("New zip code entered: |{}|", updatedAccountInformation.get("zip"));
        log.info("Account information updated");
    }

    /**
     * Verifies that the account information retrieved after the update matches the updated account information stored in the
     * scenario context. The password field is excluded from the comparison.
     */
    @Then("My account information should match my updated account information")
    public void my_account_information_should_match_my_updated_account_information() {
        Map<String, String> actualAccountInformation = myAccountPage.getMyAddressData();
        String phone = ScenarioContextHolder.getContext().getListOfMap("registrationData").get("phone");
        String email = ScenarioContextHolder.getContext().getListOfMap("registrationData").get("email");

        actualAccountInformation.put("phone", phone);
        actualAccountInformation.put("email", email);
        actualAccountInformation.remove("country");

        Map<String, String> expectedAccountInformation = ScenarioContextHolder.getContext().getListOfMap("updatedAccountInformation");
        expectedAccountInformation.remove("newPassword");

        log.info("Expected account information: |{}|", expectedAccountInformation);
        log.info("Actual account information: |{}|", actualAccountInformation);
        Assert.assertEquals(expectedAccountInformation, actualAccountInformation);
        log.info("My account information matched my updated account information");
    }
}