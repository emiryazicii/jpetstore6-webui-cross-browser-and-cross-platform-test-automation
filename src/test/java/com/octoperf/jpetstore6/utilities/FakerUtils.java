package com.octoperf.jpetstore6.utilities;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

/**
 * FakerUtils provides utility methods for generating random data using the Faker library.
 * This class includes methods for generating various types of data such as usernames, passwords, and addresses.
 */
@Slf4j
@UtilityClass
public class FakerUtils {

    private static final Faker faker = new Faker();

    /**
     * Generates a random username composed of a first name, last name, and a random number.
     *
     * @return A random username.
     */
    public static String getRandomUsername() {
        return faker.name().firstName() + "_" + faker.name().lastName() + "_" + faker.numerify("###");
    }

    /**
     * Generates a random password with a length between 10 and 14 characters, including letters, digits, and special characters.
     *
     * @return A random password.
     */
    public static String getRandomPassword() {
        return faker.internet().password(10, 14, true, true, true);
    }

    /**
     * Generates a random email address based on the provided first and last names.
     *
     * @param firstName The first name to include in the email address.
     * @param lastName  The last name to include in the email address.
     * @return A random email address.
     */
    public static String getRandomEmail(String firstName, String lastName) {
        return firstName + lastName + faker.numerify("##") + "@" + faker.internet().domainName();
    }

    /**
     * Generates a random email address.
     *
     * @return A randomly generated email address.
     */
    public String getRandomEmail(){
        return faker.internet().emailAddress();
    }

    /**
     * Generates a random phone number.
     *
     * @return A random phone number.
     */
    public static String getRandomPhoneNumber() {
        return faker.numerify(faker.number().numberBetween(200, 900) + faker.numerify("-###-####"));
    }

    /**
     * Generates a random street address.
     *
     * @return A random street address.
     */
    public static String getRandomStreetAddress() {
        return faker.address().streetAddress();
    }

    /**
     * Generates a random building number with a prefix.
     *
     * @return A random building number.
     */
    public static String getRandomBuildingNumber() {
        return "No:" + faker.address().buildingNumber();
    }

    /**
     * Generates a random city name.
     *
     * @return A random city name.
     */
    public static String getRandomCity() {
        return faker.address().city();
    }

    /**
     * Generates a random state abbreviation.
     *
     * @return A random state abbreviation.
     */
    public static String getRandomState() {
        return faker.address().stateAbbr();
    }

    /**
     * Generates a random zip code based on the provided state.
     *
     * @param state The state for which the zip code should be generated.
     * @return A random zip code.
     */
    public static String getRandomZipCode(String state) {
        return faker.address().zipCodeByState(state).replace("##", faker.numerify("##"));
    }

    /**
     * Generates a random language preference, either "english" or "japanese".
     *
     * @return A random language preference.
     */
    public static String getRandomLanguagePreference() {
        int number = faker.number().numberBetween(100, 200);
        return number % 2 == 0 ? "english" : "japanese";
    }

    /**
     * Generates a random credit card type.
     *
     * @return A random credit card type.
     */
    public static String getRandomCardType() {
        int number = faker.number().numberBetween(100, 300);
        return number % 3 == 0 ? "Visa" : number % 3 == 1 ? "MasterCard" : "American Express";
    }

    /**
     * Generates a random credit card number.
     *
     * @return A random credit card number.
     */
    public static String getRandomCreditCardNumber() {
        return faker.numerify("### #### #### ####");
    }

    /**
     * Generates a random credit card expiration date.
     *
     * @return A random credit card expiration date.
     */
    public static String getRandomCardExpirationDate() {
        String fullDate = faker.business().creditCardExpiry().replace("-","");
        String year = fullDate.substring(2, 4);
        String month = fullDate.substring(4, 6);
        return month+"/"+year;
    }

    /**
     * Generates a random favorite category from a predefined set.
     *
     * @return A random favorite category.
     */
    public static String getRandomFavouriteCategory() {
        int number = faker.number().numberBetween(100, 500);
        return number % 5 == 0 ? "FISH" :
                number % 5 == 1 ? "DOGS" :
                        number % 5 == 2 ? "REPTILES" :
                                number % 5 == 3 ? "CATS" :
                                        "BIRDS";
    }

    /**
     * Randomly checks a checkbox based on a random number.
     *
     * @param checkbox The WebElement representing the checkbox.
     */
    public static void randomlyCheckCheckBox(WebElement checkbox) {
        int number = faker.number().numberBetween(100, 200);
        if (number % 2 != 0) {
            CheckboxAndRadioButtonUtils.checkCheckbox(checkbox);
        }
    }

    /**
     * Retrieves the first name from a username generated by {@link #getRandomUsername()}.
     *
     * @param username The username from which the first name should be extracted.
     * @return The first name.
     */
    public static String retrieveFirstName(String username) {
        return username.substring(0, username.indexOf("_"));
    }

    /**
     * Retrieves the last name from a username generated by {@link #getRandomUsername()}.
     *
     * @param username The username from which the last name should be extracted.
     * @return The last name.
     */
    public static String retrieveLastName(String username) {
        return username.substring(username.indexOf("_") + 1, username.lastIndexOf("_"));
    }
}
