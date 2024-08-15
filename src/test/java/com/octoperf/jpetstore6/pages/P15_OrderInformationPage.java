package com.octoperf.jpetstore6.pages;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import com.octoperf.jpetstore6.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the Order Information Page in the application. This page extends {@link P01_BasePage} and provides methods
 * to interact with and retrieve order information details.
 */
public class P15_OrderInformationPage extends P01_BasePage {

    private final Map<String, WebElement> elementMap = new HashMap<>();
    private final Map<String, List<WebElement>> listElementsMap = new HashMap<>();

    /**
     * Initializes the Order Information Page by setting up web elements using Selenium's PageFactory
     * and populating the element map with page-specific elements.
     */
    public P15_OrderInformationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        initializeElementMap();
    }

    @FindBy(css = "ul.messages li")
    private WebElement orderConfirmationMessage;

    @FindBy(css = "#BackLink a")
    private WebElement backLink;

    @FindBy(css = "tbody th[align='center']")
    private WebElement orderNumberDateTime;

    @FindBy(css = "tbody tr:nth-of-type(2) th:first-child")
    private WebElement paymentDetailsHeader;

    @FindBy(css = "tbody tr:nth-of-type(6) th:first-child")
    private WebElement billingAddressHeader;

    @FindBy(css = "tbody tr:nth-of-type(15) th:first-child")
    private WebElement shippingAddressHeader;

    @FindBy(css = "tbody tr:nth-of-type(26) tr:nth-of-type(3) th")
    private WebElement subtotalCell;

    @FindBy(css = "tr:nth-of-type(24) td:nth-of-type(1)")
    private WebElement courierKeyCell;

    @FindBy(css = "tr:nth-of-type(24) td:nth-of-type(2)")
    private WebElement courierValueCell;

    @FindBy(css = "tr:nth-of-type(25) td:nth-of-type(1)")
    private WebElement orderStatusCell;

    @FindBy(css = "tbody tr:nth-of-type(26) tr:nth-of-type(1) th")
    private List<WebElement> itemInfoTableHeaders;

    @FindBy(css = "tr:nth-of-type(n+3):nth-of-type(-n+5) td:nth-of-type(1)")
    private List<WebElement> paymentDetailsKeyCells;

    @FindBy(css = "tr:nth-of-type(n+3):nth-of-type(-n+5) td:nth-of-type(2)")
    private List<WebElement> paymentDetailsValueCells;

    @FindBy(css = "tr:nth-of-type(n+6):nth-of-type(-n+14) td:nth-of-type(1)")
    private List<WebElement> billingAddressKeyCells;

    @FindBy(css = "tr:nth-of-type(n+6):nth-of-type(-n+14) td:nth-of-type(2)")
    private List<WebElement> billingAddressValueCells;

    @FindBy(css = "tr:nth-of-type(n+16):nth-of-type(-n+23) td:nth-of-type(1)")
    private List<WebElement> shippingAddressKeyCells;

    @FindBy(css = "tr:nth-of-type(n+16):nth-of-type(-n+23) td:nth-of-type(2)")
    private List<WebElement> shippingAddressValueCells;

    /**
     * Initializes the element map with elements specific to the Order Information Page.
     * It also calls the superclass method to initialize common elements.
     */
    @Override
    public void initializeElementMap() {
        super.initializeElementMap();
        elementMap.put("order confirmation message", orderConfirmationMessage);
        elementMap.put("back link", backLink);
        elementMap.put("payment details header", paymentDetailsHeader);
        elementMap.put("billing address header", billingAddressHeader);
        elementMap.put("shipping address header", shippingAddressHeader);
        elementMap.put("subtotal cell", subtotalCell);
        elementMap.put("courier key cell", courierKeyCell);
        elementMap.put("courier value cell", courierValueCell);
        elementMap.put("order status cell", orderStatusCell);
        elementMap.put("order number date and time", orderNumberDateTime);

        listElementsMap.put("item info table headers", itemInfoTableHeaders);
        listElementsMap.put("payment details key cells", paymentDetailsKeyCells);
        listElementsMap.put("payment details value cells", paymentDetailsValueCells);
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
     * Retrieves the href value of a link associated with a specific item ID.
     *
     * @param itemId the ID of the item.
     * @return a String representing the href attribute of the link associated with the item ID.
     */
    public String getHrefValueByItemId(String itemId) {
        WebElement link = Driver.getDriver().findElement(By.cssSelector("a[href*='" + itemId + "']"));
        return WaitUtils.getAttributeValueAfterWait(link, "href");
    }

    /**
     * Retrieves the order number from the order number and date-time element.
     *
     * @return a String representing the order number.
     */
    public String getOrderNumber() {
        String orderNumberDateAndTime = WaitUtils.getTextAfterWait(orderNumberDateTime);
        return orderNumberDateAndTime.substring(orderNumberDateAndTime.indexOf("#") + 1, orderNumberDateAndTime.indexOf("2024") - 1);
    }

    /**
     * Retrieves the date and time of the order from the order number and date-time element.
     *
     * @return a String representing the date and time of the order.
     */
    public String getOrderDateAndTime() {
        String orderNumberDateAndTime = WaitUtils.getTextAfterWait(orderNumberDateTime);
        return orderNumberDateAndTime.substring(14);
    }

    /**
     * Retrieves the warning message associated with the card number from the payment details value cells.
     *
     * @return a String representing the card number warning message.
     */
    public String getCardNumberWarning() {
        return WaitUtils.getTextAfterWait(paymentDetailsValueCells.get(1)).substring(19);
    }

    /**
     * Retrieves the courier information from the courier value cell.
     *
     * @return a String representing the courier information.
     */
    public String getCourier() {
        return WaitUtils.getTextAfterWait(courierValueCell);
    }

    /**
     * Retrieves the order status from the order status cell.
     *
     * @return a String representing the order status.
     */
    public String getOrderStatus() {
        return WaitUtils.getTextAfterWait(orderStatusCell).substring(8);
    }

    /**
     * Retrieves the subtotal value from the subtotal cell.
     *
     * @return a String representing the subtotal value.
     */
    public String getSubtotal() {
        return WaitUtils.getTextAfterWait(subtotalCell).substring(7);
    }

    /**
     * Retrieves the payment details from the payment details value cells.
     *
     * @return a Map containing payment details including "cardType", "cardNumber", and "expiryDate".
     */
    public Map<String, String> getPaymentDetails() {
        Map<String, String> paymentDetails = new HashMap<>();
        paymentDetails.put("cardType", WaitUtils.getTextAfterWait(paymentDetailsValueCells.get(0)));
        paymentDetails.put("cardNumber", WaitUtils.getTextAfterWait(paymentDetailsValueCells.get(1)).substring(0, 18));
        paymentDetails.put("expiryDate", WaitUtils.getTextAfterWait(paymentDetailsValueCells.get(2)));
        return paymentDetails;
    }

    /**
     * Retrieves the billing address information from the billing address value cells.
     *
     * @return a Map containing billing address details including "firstName", "lastName", "address1", "address2",
     * "city", "state", "zip", and "country".
     */
    public Map<String, String> getBillingAddress() {
        Map<String, String> billingAddress = new HashMap<>();
        billingAddress.put("firstName", WaitUtils.getTextAfterWait(billingAddressValueCells.get(0)));
        billingAddress.put("lastName", WaitUtils.getTextAfterWait(billingAddressValueCells.get(1)));
        billingAddress.put("address1", WaitUtils.getTextAfterWait(billingAddressValueCells.get(2)));
        billingAddress.put("address2", WaitUtils.getTextAfterWait(billingAddressValueCells.get(3)));
        billingAddress.put("city", WaitUtils.getTextAfterWait(billingAddressValueCells.get(4)));
        billingAddress.put("state", WaitUtils.getTextAfterWait(billingAddressValueCells.get(5)));
        billingAddress.put("zip", WaitUtils.getTextAfterWait(billingAddressValueCells.get(6)));
        billingAddress.put("country", WaitUtils.getTextAfterWait(billingAddressValueCells.get(7)));
        return billingAddress;
    }

    /**
     * Retrieves the shipping address information from the shipping address value cells.
     *
     * @return a Map containing shipping address details including "firstName", "lastName", "address1", "address2",
     * "city", "state", "zip", and "country".
     */
    public Map<String, String> getShippingAddress() {
        Map<String, String> shippingAddress = new HashMap<>();
        shippingAddress.put("firstName", WaitUtils.getTextAfterWait(shippingAddressValueCells.get(0)));
        shippingAddress.put("lastName", WaitUtils.getTextAfterWait(shippingAddressValueCells.get(1)));
        shippingAddress.put("address1", WaitUtils.getTextAfterWait(shippingAddressValueCells.get(2)));
        shippingAddress.put("address2", WaitUtils.getTextAfterWait(shippingAddressValueCells.get(3)));
        shippingAddress.put("city", WaitUtils.getTextAfterWait(shippingAddressValueCells.get(4)));
        shippingAddress.put("state", WaitUtils.getTextAfterWait(shippingAddressValueCells.get(5)));
        shippingAddress.put("zip", WaitUtils.getTextAfterWait(shippingAddressValueCells.get(6)));
        shippingAddress.put("country", WaitUtils.getTextAfterWait(shippingAddressValueCells.get(7)));
        return shippingAddress;
    }

    /**
     * Retrieves item information based on the provided item ID.
     *
     * @param itemId the ID of the item.
     * @return a Map containing item information such as "Item ID", "Description", "Quantity", "Price", and "Total Cost".
     */
    public Map<String, String> getItemInformationByItemId(String itemId) {
        List<WebElement> row = Driver.getDriver().findElements(By.xpath("//tbody//td[.='" + itemId + "']/..//td"));
        Map<String, String> itemInformation = new HashMap<>();
        itemInformation.put("Item ID", WaitUtils.getTextAfterWait(row.get(0).findElement(By.tagName("a"))));
        itemInformation.put("Description", WaitUtils.getTextAfterWait(row.get(1)));
        itemInformation.put("Quantity", WaitUtils.getTextAfterWait(row.get(2)));
        itemInformation.put("Price", WaitUtils.getTextAfterWait(row.get(3)));
        itemInformation.put("Total Cost", WaitUtils.getTextAfterWait(row.get(4)));
        return itemInformation;
    }
}