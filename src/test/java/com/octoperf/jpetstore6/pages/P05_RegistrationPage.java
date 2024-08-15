package com.octoperf.jpetstore6.pages;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import com.octoperf.jpetstore6.utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the Registration Page in the application. This page extends {@link P01_BasePage} and includes elements
 * specific to the user registration functionality.
 */
public class P05_RegistrationPage extends P01_BasePage {

    private final Map<String, WebElement> elementMap = new HashMap<>();
    private final Map<String, List<WebElement>> listElementsMap = new HashMap<>();

    /**
     * Initializes the Registration Page by setting up web elements using Selenium's PageFactory
     * and populating the element maps with page-specific elements.
     */
    public P05_RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        initializeElementMap();
    }

    @FindBy(css = "h3:nth-of-type(1)")
    private WebElement userInformationHeader;

    @FindBy(css = "h3:nth-of-type(2)")
    private WebElement accountInformationHeader;

    @FindBy(css = "h3:nth-of-type(3)")
    private WebElement profileInformationHeader;

    @FindBy(name = "username")
    private WebElement userIdInputBox;

    @FindBy(name = "password")
    private WebElement newPasswordInputBox;

    @FindBy(name = "repeatedPassword")
    private WebElement repeatPasswordInputBox;

    @FindBy(name = "account.firstName")
    private WebElement firstNameInputBox;

    @FindBy(name = "account.lastName")
    private WebElement lastNameInputBox;

    @FindBy(name = "account.email")
    private WebElement emailInputBox;

    @FindBy(name = "account.phone")
    private WebElement phoneInputBox;

    @FindBy(name = "account.address1")
    private WebElement address1InputBox;

    @FindBy(name = "account.address2")
    private WebElement address2InputBox;

    @FindBy(name = "account.city")
    private WebElement cityInputBox;

    @FindBy(name = "account.state")
    private WebElement stateInputBox;

    @FindBy(name = "account.zip")
    private WebElement zipInputBox;

    @FindBy(name = "account.country")
    private WebElement countryInputBox;

    @FindBy(name = "account.languagePreference")
    private WebElement languagePreferenceDropdown;

    @FindBy(name = "account.favouriteCategoryId")
    private WebElement favouriteCategoryDropdown;

    @FindBy(name = "account.listOption")
    private WebElement enableMyListCheckbox;

    @FindBy(name = "account.bannerOption")
    private WebElement enableMyBannerCheckbox;

    @FindBy(name = "newAccount")
    private WebElement saveAccountInformationButton;

    @FindBy(css = "tr > td:first-child")
    private List<WebElement> inputBoxNames;

    /**
     * Initializes the element maps with elements specific to the Registration Page.
     * It also calls the superclass method to initialize common elements.
     */
    @Override
    public void initializeElementMap() {
        super.initializeElementMap();
        elementMap.put("user information header", userInformationHeader);
        elementMap.put("account information header", accountInformationHeader);
        elementMap.put("profile information header", profileInformationHeader);
        elementMap.put("user id input box", userIdInputBox);
        elementMap.put("new password input box", newPasswordInputBox);
        elementMap.put("repeat password input box", repeatPasswordInputBox);
        elementMap.put("firstname input box", firstNameInputBox);
        elementMap.put("lastname input box", lastNameInputBox);
        elementMap.put("email input box", emailInputBox);
        elementMap.put("phone input box", phoneInputBox);
        elementMap.put("address1 input box", address1InputBox);
        elementMap.put("address2 input box", address2InputBox);
        elementMap.put("city input box", cityInputBox);
        elementMap.put("state input box", stateInputBox);
        elementMap.put("zip input box", zipInputBox);
        elementMap.put("country input box", countryInputBox);
        elementMap.put("language preference dropdown", languagePreferenceDropdown);
        elementMap.put("favourite category dropdown", favouriteCategoryDropdown);
        elementMap.put("enable my list checkbox", enableMyListCheckbox);
        elementMap.put("enable my banner checkbox", enableMyBannerCheckbox);
        elementMap.put("save account information button", saveAccountInformationButton);

        listElementsMap.put("input box names", inputBoxNames);
        listElementsMap.put("user information input box names", inputBoxNames.subList(0,3));
        listElementsMap.put("account information input box names", inputBoxNames.subList(3,13));
        listElementsMap.put("profile information dropdown and checkbox names", inputBoxNames.subList(13,17));
    }

    /**
     * Retrieves a web element based on the provided description. If the element is not found in the current page's map,
     * it falls back to the superclass map.
     *
     * @param elementDescription the description of the web element.
     * @return the WebElement corresponding to the description.
     */
    @Override
    public WebElement getElement(String elementDescription) {
        WebElement element = elementMap.get(elementDescription.trim().toLowerCase());
        if (element == null) {
            return super.getElement(elementDescription);
        }
        return element;
    }

    /**
     * Retrieves a list of web elements based on the provided description. If the elements are not found in the current
     * page's map, it falls back to the superclass map.
     *
     * @param elementDescription the description of the web elements.
     * @return a list of WebElements corresponding to the description.
     */
    @Override
    public List<WebElement> getElements(String elementDescription) {
        List<WebElement> elements = listElementsMap.get(elementDescription.trim().toLowerCase());
        if (elements == null) {
            return super.getElements(elementDescription);
        }
        return elements;
    }

    /**
     * Registers a new user by populating the registration form fields with the provided data and submitting the form.
     *
     * @param username the username for the new account.
     * @param password the password for the new account.
     * @param firstName the first name of the user.
     * @param lastName the last name of the user.
     * @param email the email address of the user.
     * @param phone the phone number of the user.
     * @param address1 the first line of the user's address.
     * @param address2 the second line of the user's address.
     * @param city the city where the user resides.
     * @param state the state where the user resides.
     * @param zip the ZIP code of the user's address.
     * @param country the country where the user resides.
     * @param languagePreference the preferred language for the user.
     * @param favouriteCategory the user's favorite category.
     */
    public void registerNewUser(
            String username,
            String password,
            String firstName,
            String lastName,
            String email,
            String phone,
            String address1,
            String address2,
            String city,
            String state,
            String zip,
            String country,
            String languagePreference,
            String favouriteCategory
    ) {
        WaitUtils.sendKeysAfterWait(userIdInputBox, username);
        WaitUtils.sendKeysAfterWait(newPasswordInputBox, password);
        WaitUtils.sendKeysAfterWait(repeatPasswordInputBox, password);
        WaitUtils.sendKeysAfterWait(firstNameInputBox, firstName);
        WaitUtils.sendKeysAfterWait(lastNameInputBox, lastName);
        WaitUtils.sendKeysAfterWait(emailInputBox, email);
        WaitUtils.sendKeysAfterWait(phoneInputBox, phone);
        WaitUtils.sendKeysAfterWait(address1InputBox, address1);
        WaitUtils.sendKeysAfterWait(address2InputBox, address2);
        WaitUtils.sendKeysAfterWait(cityInputBox, city);
        WaitUtils.sendKeysAfterWait(stateInputBox, state);
        WaitUtils.sendKeysAfterWait(zipInputBox, zip);
        WaitUtils.sendKeysAfterWait(countryInputBox, country);
        SelectUtils.selectByVisibleText(languagePreferenceDropdown, languagePreference);
        SelectUtils.selectByVisibleText(favouriteCategoryDropdown, favouriteCategory);
        FakerUtils.randomlyCheckCheckBox(enableMyListCheckbox);
        FakerUtils.randomlyCheckCheckBox(enableMyBannerCheckbox);
    }
}