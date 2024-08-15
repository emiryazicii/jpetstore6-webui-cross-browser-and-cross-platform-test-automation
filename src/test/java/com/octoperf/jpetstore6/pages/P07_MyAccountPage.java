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
 * Represents the My Account Page in the application. This page extends {@link P01_BasePage} and includes elements and methods
 * specific to the user's account management functionality.
 */
public class P07_MyAccountPage extends P01_BasePage {

    private final Map<String, WebElement> elementMap = new HashMap<>();
    private final Map<String, List<WebElement>> listElementsMap = new HashMap<>();

    /**
     * Initializes the My Account Page by setting up web elements using Selenium's PageFactory
     * and populating the element map with page-specific elements.
     */
    public P07_MyAccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        initializeElementMap();
    }

    @FindBy(css = "h3:nth-of-type(1)")
    private WebElement userInformationHeader;

    @FindBy(css = "table:nth-of-type(1) tr:nth-of-type(1) td:nth-of-type(2)")
    private WebElement usernameCell;

    @FindBy(name = "password")
    private WebElement newPasswordInputBox;

    @FindBy(name = "repeatedPassword")
    private WebElement repeatPasswordInputBox;

    @FindBy(css = "h3:nth-of-type(2)")
    private WebElement accountInformationHeader;

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

    @FindBy(css = "h3:nth-of-type(3)")
    private WebElement profileInformationHeader;

    @FindBy(name = "account.languagePreference")
    private WebElement languagePreferenceDropdown;

    @FindBy(name = "account.favouriteCategoryId")
    private WebElement favouriteCategoryDropdown;

    @FindBy(name = "account.listOption")
    private WebElement enableMyListCheckbox;

    @FindBy(name = "account.bannerOption")
    private WebElement enableMyBannerCheckbox;

    @FindBy(name = "editAccount")
    private WebElement saveAccountInformationButton;

    @FindBy(css = "#Catalog > a")
    private WebElement myOrdersLink;

    @FindBy(css = "tr td:nth-of-type(1)")
    private List<WebElement> inputBoxNames;

    /**
     * Initializes the element map with elements specific to the My Account Page.
     * It also calls the superclass method to initialize common elements.
     */
    @Override
    public void initializeElementMap() {
        super.initializeElementMap();
        elementMap.put("user information header", userInformationHeader);
        elementMap.put("username cell", usernameCell);
        elementMap.put("new password input box", newPasswordInputBox);
        elementMap.put("repeat password input box", repeatPasswordInputBox);
        elementMap.put("account information header", accountInformationHeader);
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
        elementMap.put("profile information header", profileInformationHeader);
        elementMap.put("language preference dropdown", languagePreferenceDropdown);
        elementMap.put("favourite category dropdown", favouriteCategoryDropdown);
        elementMap.put("enable my list checkbox", enableMyListCheckbox);
        elementMap.put("enable my banner checkbox", enableMyBannerCheckbox);
        elementMap.put("save account information button", saveAccountInformationButton);
        elementMap.put("my orders link", myOrdersLink);

        listElementsMap.put("input box names", inputBoxNames);
        listElementsMap.put("user information input box names", inputBoxNames.subList(0, 3));
        listElementsMap.put("account information input box names", inputBoxNames.subList(3, 13));
        listElementsMap.put("profile information dropdown and checkbox names", inputBoxNames.subList(13, 17));
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
     * Retrieves a list of web elements based on the provided description. If the elements are not found in the current page's map,
     * it falls back to the superclass map.
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
     * Retrieves the data from the My Account page and returns it as a map of key-value pairs.
     *
     * @return a Map containing account data with keys such as "userId", "firstName", "lastName", etc.
     */
    public Map<String, String> getMyAccountData() {
        Map<String, String> myAccountData = new HashMap<>();
        myAccountData.put("userId", WaitUtils.getTextAfterWait(usernameCell));
        myAccountData.put("firstName", WaitUtils.getAttributeValueAfterWait(firstNameInputBox, "value"));
        myAccountData.put("lastName", WaitUtils.getAttributeValueAfterWait(lastNameInputBox, "value"));
        myAccountData.put("email", WaitUtils.getAttributeValueAfterWait(emailInputBox, "value"));
        myAccountData.put("phone", WaitUtils.getAttributeValueAfterWait(phoneInputBox, "value"));
        myAccountData.put("address1", WaitUtils.getAttributeValueAfterWait(address1InputBox, "value"));
        myAccountData.put("address2", WaitUtils.getAttributeValueAfterWait(address2InputBox, "value"));
        myAccountData.put("city", WaitUtils.getAttributeValueAfterWait(cityInputBox, "value"));
        myAccountData.put("state", WaitUtils.getAttributeValueAfterWait(stateInputBox, "value"));
        myAccountData.put("zip", WaitUtils.getAttributeValueAfterWait(zipInputBox, "value"));
        myAccountData.put("country", WaitUtils.getAttributeValueAfterWait(countryInputBox, "value"));
        myAccountData.put("languagePreference", WaitUtils.getTextAfterWait(SelectUtils.getFirstSelectedOption(languagePreferenceDropdown)));
        myAccountData.put("favouriteCategory", WaitUtils.getTextAfterWait(SelectUtils.getFirstSelectedOption(favouriteCategoryDropdown)));
        myAccountData.put("enableMyListCheckboxStatus", CheckboxAndRadioButtonUtils.isCheckboxChecked(enableMyListCheckbox) ? "checked" : "unchecked");
        myAccountData.put("enableMyBannerCheckboxStatus", CheckboxAndRadioButtonUtils.isCheckboxChecked(enableMyBannerCheckbox) ? "checked" : "unchecked");
        return myAccountData;
    }

    /**
     * Retrieves only the address-related data from the My Account page.
     *
     * @return a Map containing address data with keys such as "firstName", "lastName", "address1", "address2", "city", "state", "zip", and "country".
     */
    public Map<String, String> getMyAddressData() {
        Map<String, String> myAddressData = new HashMap<>();
        myAddressData.put("firstName", WaitUtils.getAttributeValueAfterWait(firstNameInputBox, "value"));
        myAddressData.put("lastName", WaitUtils.getAttributeValueAfterWait(lastNameInputBox, "value"));
        myAddressData.put("address1", WaitUtils.getAttributeValueAfterWait(address1InputBox, "value"));
        myAddressData.put("address2", WaitUtils.getAttributeValueAfterWait(address2InputBox, "value"));
        myAddressData.put("city", WaitUtils.getAttributeValueAfterWait(cityInputBox, "value"));
        myAddressData.put("state", WaitUtils.getAttributeValueAfterWait(stateInputBox, "value"));
        myAddressData.put("zip", WaitUtils.getAttributeValueAfterWait(zipInputBox, "value"));
        myAddressData.put("country", WaitUtils.getAttributeValueAfterWait(countryInputBox, "value"));
        return myAddressData;
    }

    /**
     * Updates the account information with the specified details.
     * Clears existing values in the input fields before entering the new values.
     *
     * @param newPassword the new password to set.
     * @param email       the new email address to set.
     * @param phone       the new phone number to set.
     * @param address1    the new address line 1 to set.
     * @param address2    the new address line 2 to set.
     * @param city        the new city to set.
     * @param state       the new state to set.
     * @param zip         the new zip code to set.
     */
    public void updateMyAccountInformation(
            String newPassword,
            String email,
            String phone,
            String address1,
            String address2,
            String city,
            String state,
            String zip
    ) {
        WaitUtils.clearInputBoxAfterWait(emailInputBox);
        WaitUtils.clearInputBoxAfterWait(phoneInputBox);
        WaitUtils.clearInputBoxAfterWait(address1InputBox);
        WaitUtils.clearInputBoxAfterWait(address2InputBox);
        WaitUtils.clearInputBoxAfterWait(cityInputBox);
        WaitUtils.clearInputBoxAfterWait(stateInputBox);
        WaitUtils.clearInputBoxAfterWait(zipInputBox);

        WaitUtils.sendKeysAfterWait(newPasswordInputBox, newPassword);
        WaitUtils.sendKeysAfterWait(repeatPasswordInputBox, newPassword);
        WaitUtils.sendKeysAfterWait(emailInputBox, email);
        WaitUtils.sendKeysAfterWait(phoneInputBox, phone);
        WaitUtils.sendKeysAfterWait(address1InputBox, address1);
        WaitUtils.sendKeysAfterWait(address2InputBox, address2);
        WaitUtils.sendKeysAfterWait(cityInputBox, city);
        WaitUtils.sendKeysAfterWait(stateInputBox, state);
        WaitUtils.sendKeysAfterWait(zipInputBox, zip);
    }
}