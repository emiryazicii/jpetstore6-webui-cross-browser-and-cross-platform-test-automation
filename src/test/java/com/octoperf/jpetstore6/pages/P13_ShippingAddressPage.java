package com.octoperf.jpetstore6.pages;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import com.octoperf.jpetstore6.utilities.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the Shipping Address Page in the application. This page extends {@link P01_BasePage} and provides functionality
 * to interact with and retrieve information from the shipping address form.
 */
public class P13_ShippingAddressPage extends P01_BasePage {

    private final Map<String, WebElement> elementMap = new HashMap<>();
    private final Map<String, List<WebElement>> listElementsMap = new HashMap<>();

    /**
     * Initializes the Shipping Address Page by setting up web elements using Selenium's PageFactory
     * and populating the element map with page-specific elements.
     */
    public P13_ShippingAddressPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        initializeElementMap();
    }

    @FindBy(css = "table th")
    private WebElement shippingAddressHeader;

    @FindBy(name = "order.shipToFirstName")
    private WebElement firstNameInputBox;

    @FindBy(name = "order.shipToLastName")
    private WebElement lastNameInputBox;

    @FindBy(name = "order.shipAddress1")
    private WebElement address1InputBox;

    @FindBy(name = "order.shipAddress2")
    private WebElement address2InputBox;

    @FindBy(name = "order.shipCity")
    private WebElement cityInputBox;

    @FindBy(name = "order.shipState")
    private WebElement stateInputBox;

    @FindBy(name = "order.shipZip")
    private WebElement zipInputBox;

    @FindBy(name = "order.shipCountry")
    private WebElement countryInputBox;

    @FindBy(name = "newOrder")
    private WebElement continueButton;

    @FindBy(css = "td:nth-of-type(1)\n")
    private List<WebElement> shippingAddressInputBoxNames;

    @FindBy(css = "td:nth-of-type(2) input")
    private List<WebElement> shippingAddressInputBoxes;

    /**
     * Initializes the element map with elements specific to the Shipping Address Page.
     * It also calls the superclass method to initialize common elements.
     */
    @Override
    public void initializeElementMap() {
        super.initializeElementMap();
        elementMap.put("shipping address header", shippingAddressHeader);
        elementMap.put("first name input box", firstNameInputBox);
        elementMap.put("last name input box", lastNameInputBox);
        elementMap.put("address 1 input box", address1InputBox);
        elementMap.put("address 2 input box", address2InputBox);
        elementMap.put("city input box", cityInputBox);
        elementMap.put("state input box", stateInputBox);
        elementMap.put("zip input box", zipInputBox);
        elementMap.put("country input box", countryInputBox);
        elementMap.put("continue button", continueButton);

        listElementsMap.put("shipping address input box names", shippingAddressInputBoxNames);
        listElementsMap.put("shipping address input boxes", shippingAddressInputBoxes);
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
     * @return the List of WebElements corresponding to the description.
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
     * Retrieves default shipping address data from the shipping address form.
     *
     * @return a Map containing shipping address details such as "firstName", "lastName", "address1", "address2",
     *         "city", "state", "zip", and "country".
     */
    public Map<String, String> getDefaultShippingAddressData() {
        Map<String, String> shippingAddressData = new HashMap<>();
        shippingAddressData.put("firstName", WaitUtils.getAttributeValueAfterWait(firstNameInputBox, "value"));
        shippingAddressData.put("lastName", WaitUtils.getAttributeValueAfterWait(lastNameInputBox, "value"));
        shippingAddressData.put("address1", WaitUtils.getAttributeValueAfterWait(address1InputBox, "value"));
        shippingAddressData.put("address2", WaitUtils.getAttributeValueAfterWait(address2InputBox, "value"));
        shippingAddressData.put("city", WaitUtils.getAttributeValueAfterWait(cityInputBox, "value"));
        shippingAddressData.put("state", WaitUtils.getAttributeValueAfterWait(stateInputBox, "value"));
        shippingAddressData.put("zip", WaitUtils.getAttributeValueAfterWait(zipInputBox, "value"));
        shippingAddressData.put("country", WaitUtils.getAttributeValueAfterWait(countryInputBox, "value"));
        return shippingAddressData;
    }

    /**
     * Clears the values in the shipping address input boxes.
     */
    public void clearShippingAddressBoxes(){
        WaitUtils.clearInputBoxAfterWait(address1InputBox);
        WaitUtils.clearInputBoxAfterWait(address2InputBox);
        WaitUtils.clearInputBoxAfterWait(cityInputBox);
        WaitUtils.clearInputBoxAfterWait(stateInputBox);
        WaitUtils.clearInputBoxAfterWait(zipInputBox);
    }

    /**
     * Enters the provided shipping address details into the form.
     *
     * @param address1 the first line of the shipping address.
     * @param address2 the second line of the shipping address (optional).
     * @param city the city of the shipping address.
     * @param state the state or province of the shipping address.
     * @param zip the postal code or ZIP code of the shipping address.
     */
    public void enterShippingAddress(
            String address1,
            String address2,
            String city,
            String state,
            String zip) {
        WaitUtils.sendKeysAfterWait(address1InputBox, address1);
        WaitUtils.sendKeysAfterWait(address2InputBox, address2);
        WaitUtils.sendKeysAfterWait(cityInputBox, city);
        WaitUtils.sendKeysAfterWait(stateInputBox, state);
        WaitUtils.sendKeysAfterWait(zipInputBox, zip);
    }
}