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
 * Represents the My Orders Page in the application. This page extends {@link P01_BasePage} and provides methods
 * to interact with and retrieve order data from the user's order list.
 */
public class P16_MyOrdersPage extends P01_BasePage {

    private final Map<String, WebElement> elementMap = new HashMap<>();
    private final Map<String, List<WebElement>> listElementsMap = new HashMap<>();

    /**
     * Initializes the My Orders Page by setting up web elements using Selenium's PageFactory
     * and populating the element map with page-specific elements.
     */
    public P16_MyOrdersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        initializeElementMap();
    }

    @FindBy(css = "#Content h2")
    private WebElement myOrdersHeader;

    @FindBy(css = "table th")
    private List<WebElement> tableHeaders;

    @FindBy(css = "table tr:not(:first-of-type)")
    private List<WebElement> ordersInTheList;

    /**
     * Initializes the element map with elements specific to the My Orders Page.
     * It also calls the superclass method to initialize common elements.
     */
    @Override
    public void initializeElementMap() {
        super.initializeElementMap();
        elementMap.put("my orders header", myOrdersHeader);

        listElementsMap.put("table headers", tableHeaders);
        listElementsMap.put("orders in the list", ordersInTheList);
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
     * Retrieves order data for a specific order ID from the list of orders on the page.
     *
     * @param orderId the ID of the order to retrieve data for.
     * @return a Map containing order data including "Order ID", "Date", and "Total Price".
     * @throws IllegalArgumentException if the order ID is not found in the list.
     */
    public Map<String, String> getOrderDataByOrderId(String orderId) {
        WebElement orderRow = ordersInTheList.stream()
                .filter(row -> WaitUtils.getTextAfterWait(row.findElement(By.cssSelector("td:nth-of-type(1) a"))).equals(orderId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Order ID not found: " + orderId));

        List<WebElement> cells = orderRow.findElements(By.cssSelector("td"));
        Map<String, String> orderData = new HashMap<>();
        orderData.put("Order ID", WaitUtils.getTextAfterWait(cells.get(0).findElement(By.tagName("a"))));
        orderData.put("Date", WaitUtils.getTextAfterWait(cells.get(1)));
        orderData.put("Total Price", WaitUtils.getTextAfterWait(cells.get(2)));
        return orderData;
    }
}