package com.octoperf.jpetstore6.pages;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import com.octoperf.jpetstore6.utilities.StreamUtils;
import com.octoperf.jpetstore6.utilities.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Represents the Order Confirmation Page in the application. This page extends {@link P01_BasePage} and provides functionality
 * to interact with and retrieve information from the order confirmation details.
 */
public class P14_OrderConfirmationPage extends P01_BasePage {

    private final Map<String, WebElement> elementMap = new HashMap<>();
    private final Map<String, List<WebElement>> listElementsMap = new HashMap<>();

    /**
     * Initializes the Order Confirmation Page by setting up web elements using Selenium's PageFactory
     * and populating the element map with page-specific elements.
     */
    public P14_OrderConfirmationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        initializeElementMap();
    }

    @FindBy(css = "table font[size='4'] > b")
    private WebElement orderHeader;

    @FindBy(css = "table font[size='3'] > b")
    private WebElement orderDateAndTime;

    @FindBy(css = "tbody > tr:nth-child(2) > th")
    private WebElement billingAddressHeader;

    @FindBy(css = "tbody > tr:nth-child(11) > th")
    private WebElement shippingAddressHeader;

    @FindBy(id = "Catalog")
    private WebElement catalogSection;

    @FindBy(css = "#BackLink a")
    private WebElement backLink;

    @FindBy(css = "a.Button")
    private WebElement confirmButton;

    @FindBy(css = "tr:nth-of-type(n+3):nth-of-type(-n+10) td:nth-of-type(1)")
    private List<WebElement> billingAddressKeyCells;

    @FindBy(css = "tr:nth-of-type(n+3):nth-of-type(-n+10) td:nth-of-type(2)")
    private List<WebElement> billingAddressValueCells;

    @FindBy(css = "tr:nth-of-type(n+11) td:nth-of-type(1)")
    private List<WebElement> shippingAddressKeyCells;

    @FindBy(css = "tr:nth-of-type(n+11) td:nth-of-type(2)")
    private List<WebElement> shippingAddressValueCells;

    /**
     * Initializes the element map with elements specific to the Order Confirmation Page.
     * It also calls the superclass method to initialize common elements.
     */
    @Override
    public void initializeElementMap() {
        super.initializeElementMap();
        elementMap.put("order header", orderHeader);
        elementMap.put("order date and time", orderDateAndTime);
        elementMap.put("billing address header", billingAddressHeader);
        elementMap.put("shipping address header", shippingAddressHeader);
        elementMap.put("catalog section", catalogSection);
        elementMap.put("back link", backLink);
        elementMap.put("confirm button", confirmButton);

        listElementsMap.put("billing address key cells", billingAddressKeyCells);
        listElementsMap.put("billing address value cells", billingAddressValueCells);
        listElementsMap.put("shipping address key cells", shippingAddressKeyCells);
        listElementsMap.put("shipping address value cells", shippingAddressValueCells);
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
     * Retrieves the text of the order date and time from the order confirmation page.
     *
     * @return a String representing the order date and time.
     */
    public String getOrderDateAndTimeText() {
        return WaitUtils.getTextAfterWait(orderDateAndTime);
    }

    /**
     * Retrieves the confirmation instruction message, which is extracted from the catalog section text.
     *
     * @return a String containing the confirmation instruction message.
     */
    public String getConfirmationInstructionMessage() {
        String catalogText = WaitUtils.getTextAfterWait(catalogSection);
        return catalogText.substring(0, catalogText.lastIndexOf(".") + 1);
    }

    /**
     * Retrieves the billing address data from the confirmation page.
     *
     * @return a Map containing billing address details such as "firstName", "lastName", "address1", "address2",
     * "city", "state", "zip", and "country".
     */
    public Map<String, String> getBillingAddressData() {
        List<String> keys = Arrays.asList("firstName", "lastName", "address1", "address2", "city", "state", "zip", "country");
        List<String> values = StreamUtils.getTextOfElements(billingAddressValueCells);
        Map<String, String> addressData = new HashMap<>();
        IntStream.range(0, keys.size()).forEach(i -> addressData.put(keys.get(i), values.get(i)));
        return addressData;
    }

    /**
     * Retrieves the shipping address data from the confirmation page.
     *
     * @return a Map containing shipping address details such as "firstName", "lastName", "address1", "address2",
     * "city", "state", "zip", and "country".
     */
    public Map<String, String> getShippingAddressData() {
        List<String> keys = Arrays.asList("firstName", "lastName", "address1", "address2", "city", "state", "zip", "country");
        List<String> values = StreamUtils.getTextOfElements(shippingAddressValueCells);
        Map<String, String> addressData = new HashMap<>();
        IntStream.range(0, keys.size()).forEach(i -> addressData.put(keys.get(i), values.get(i)));
        return addressData;
    }
}