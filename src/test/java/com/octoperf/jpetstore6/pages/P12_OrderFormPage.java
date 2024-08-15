package com.octoperf.jpetstore6.pages;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import com.octoperf.jpetstore6.utilities.SelectUtils;
import com.octoperf.jpetstore6.utilities.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the Order Form Page in the application. This page extends {@link P01_BasePage} and provides functionality
 * to interact with and retrieve information from the order form.
 */
public class P12_OrderFormPage extends P01_BasePage {

    private final Map<String, WebElement> elementMap = new HashMap<>();
    private final Map<String, List<WebElement>> listElementsMap = new HashMap<>();

    /**
     * Initializes the Order Form Page by setting up web elements using Selenium's PageFactory
     * and populating the element map with page-specific elements.
     */
    public P12_OrderFormPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        initializeElementMap();
    }

    @FindBy(name = "order.cardType")
    private WebElement cardTypeDropdown;

    @FindBy(name = "order.creditCard")
    private WebElement cardNumberInputBox;

    @FindBy(name = "order.expiryDate")
    private WebElement expiryDateInputBox;

    @FindBy(name = "order.billToFirstName")
    private WebElement firstNameInputBox;

    @FindBy(name = "order.billToLastName")
    private WebElement lastNameInputBox;

    @FindBy(name = "order.billAddress1")
    private WebElement address1InputBox;

    @FindBy(name = "order.billAddress2")
    private WebElement address2InputBox;

    @FindBy(name = "order.billCity")
    private WebElement cityInputBox;

    @FindBy(name = "order.billState")
    private WebElement stateInputBox;

    @FindBy(name = "order.billZip")
    private WebElement zipInputBox;

    @FindBy(name = "order.billCountry")
    private WebElement countryInputBox;

    @FindBy(name = "shippingAddressRequired")
    private WebElement shipToDifferentAddressCheckbox;

    @FindBy(name = "newOrder")
    private WebElement continueButton;

    @FindBy(css = "table tr:nth-of-type(1) th:nth-of-type(1)")
    private WebElement paymentDetailsHeader;

    @FindBy(css = "table tr:nth-of-type(5) th:nth-of-type(1)")
    private WebElement billingAddressHeader;

    @FindBy(css = "table tr:last-of-type td")
    private WebElement checkBoxDescription;

    @FindBy(css = "table tr:nth-of-type(3) td:nth-of-type(2)")
    private WebElement cardNumberWarning;

    @FindBy(css = "tr:nth-of-type(-n+4) td:nth-of-type(1)")
    private List<WebElement> paymentDetailsInputBoxNames;

    @FindBy(css = "tr:nth-of-type(-n+4) td:nth-of-type(2) ")
    private List<WebElement> paymentDetailsInputBoxes;

    @FindBy(css = "tr:nth-of-type(n+5):not(:last-of-type) td:nth-of-type(1)")
    private List<WebElement> billingAddressInputBoxNames;

    @FindBy(css = "tr:nth-of-type(n+6) td:nth-of-type(2) input")
    private List<WebElement> billingAddressInputBoxes;

    /**
     * Initializes the element map with elements specific to the Order Form Page.
     * It also calls the superclass method to initialize common elements.
     */
    @Override
    public void initializeElementMap() {
        super.initializeElementMap();
        elementMap.put("card type dropdown", cardTypeDropdown);
        elementMap.put("card number input box", cardNumberInputBox);
        elementMap.put("expiry date input box", expiryDateInputBox);
        elementMap.put("first name input box", firstNameInputBox);
        elementMap.put("last name input box", lastNameInputBox);
        elementMap.put("address 1 input box", address1InputBox);
        elementMap.put("address 2 input box", address2InputBox);
        elementMap.put("city input box", cityInputBox);
        elementMap.put("state input box", stateInputBox);
        elementMap.put("zip input box", zipInputBox);
        elementMap.put("country input box", countryInputBox);
        elementMap.put("ship to different address checkbox", shipToDifferentAddressCheckbox);
        elementMap.put("continue button", continueButton);
        elementMap.put("payment details header", paymentDetailsHeader);
        elementMap.put("billing address header", billingAddressHeader);
        elementMap.put("checkbox description", checkBoxDescription);
        elementMap.put("card number warning", cardNumberWarning);

        listElementsMap.put("payment details input box names", paymentDetailsInputBoxNames);
        listElementsMap.put("payment details input boxes", paymentDetailsInputBoxes);
        listElementsMap.put("billing address input box names", billingAddressInputBoxNames);
        listElementsMap.put("billing address input boxes", billingAddressInputBoxes);
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
     * Enters payment details into the order form.
     *
     * @param cardType the type of credit card.
     * @param cardNumber the credit card number.
     * @param expiryDate the expiry date of the credit card.
     */
    public void enterPaymentDetails(String cardType,String cardNumber, String expiryDate){
        WaitUtils.clearInputBoxAfterWait(cardNumberInputBox);
        WaitUtils.clearInputBoxAfterWait(expiryDateInputBox);
        SelectUtils.selectByVisibleText(cardTypeDropdown, cardType);
        WaitUtils.sendKeysAfterWait(cardNumberInputBox, cardNumber);
        WaitUtils.sendKeysAfterWait(expiryDateInputBox, expiryDate);
    }

    /**
     * Retrieves payment details from the order form.
     *
     * @return a Map containing payment details such as "cardType", "cardNumber", and "expiryDate".
     */
    public Map<String, String> getPaymentDetailsData() {
        Map<String, String> paymentDetails = new HashMap<>();
        paymentDetails.put("cardType", WaitUtils.getTextAfterWait(SelectUtils.getFirstSelectedOption(cardTypeDropdown)));
        paymentDetails.put("cardNumber", WaitUtils.getAttributeValueAfterWait(cardNumberInputBox, "value"));
        paymentDetails.put("expiryDate", WaitUtils.getAttributeValueAfterWait(expiryDateInputBox, "value"));
        return paymentDetails;
    }

    /**
     * Retrieves billing address details from the order form.
     *
     * @return a Map containing billing address details such as "firstName", "lastName", "address1", "address2",
     *         "city", "state", "zip", and "country".
     */
    public Map<String, String> getBillingAddressData() {
        Map<String, String> billingAddressData = new HashMap<>();
        billingAddressData.put("firstName", WaitUtils.getAttributeValueAfterWait(firstNameInputBox, "value"));
        billingAddressData.put("lastName", WaitUtils.getAttributeValueAfterWait(lastNameInputBox, "value"));
        billingAddressData.put("address1", WaitUtils.getAttributeValueAfterWait(address1InputBox, "value"));
        billingAddressData.put("address2", WaitUtils.getAttributeValueAfterWait(address2InputBox, "value"));
        billingAddressData.put("city", WaitUtils.getAttributeValueAfterWait(cityInputBox, "value"));
        billingAddressData.put("state", WaitUtils.getAttributeValueAfterWait(stateInputBox, "value"));
        billingAddressData.put("zip", WaitUtils.getAttributeValueAfterWait(zipInputBox, "value"));
        billingAddressData.put("country", WaitUtils.getAttributeValueAfterWait(countryInputBox, "value"));
        return billingAddressData;
    }
}