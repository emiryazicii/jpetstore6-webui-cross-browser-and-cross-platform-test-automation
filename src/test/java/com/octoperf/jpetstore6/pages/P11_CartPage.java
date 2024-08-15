package com.octoperf.jpetstore6.pages;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import com.octoperf.jpetstore6.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Represents the Cart Page in the application. This page extends {@link P01_BasePage} and includes elements and methods
 * specific to interacting with and viewing the contents of the shopping cart.
 */
public class P11_CartPage extends P01_BasePage {

    private final Map<String, WebElement> elementMap = new HashMap<>();
    private final Map<String, List<WebElement>> listElementsMap = new HashMap<>();

    /**
     * Initializes the Cart Page by setting up web elements using Selenium's PageFactory
     * and populating the element map with page-specific elements.
     */
    public P11_CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        initializeElementMap();
    }

    @FindBy(css = "#BackLink a")
    private WebElement backLink;

    @FindBy(css = "#Cart h2")
    private WebElement shoppingCartHeader;

    @FindBy(name = "updateCartQuantities")
    private WebElement updateCartButton;

    @FindBy(css = "#Cart > a[href*='newOrderForm']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//td[contains(text(),'Sub Total')]")
    private WebElement subTotalCell;

    @FindBy(css = "table tr:nth-of-type(2)")
    private WebElement emptyCartMessage;

    @FindBy(css = "#Cart tbody th:not(:nth-last-child(1))")
    private List<WebElement> tableHeaders;

    @FindBy(css = "#Cart tbody tr:not(:first-child):not(:last-child)")
    private List<WebElement> tableRowsExceptHeadersAndLastRow;

    @FindBy(css = "table tr td:nth-of-type(8) a")
    private List<WebElement> removeButtons;

    /**
     * Initializes the element map with elements specific to the Cart Page.
     * It also calls the superclass method to initialize common elements.
     */
    @Override
    public void initializeElementMap() {
        super.initializeElementMap();
        elementMap.put("back link", backLink);
        elementMap.put("shopping cart header", shoppingCartHeader);
        elementMap.put("update cart button", updateCartButton);
        elementMap.put("proceed to checkout button", proceedToCheckoutButton);
        elementMap.put("subtotal cell", subTotalCell);
        elementMap.put("empty cart message", emptyCartMessage);

        listElementsMap.put("table headers", tableHeaders);
        listElementsMap.put("table rows except headers and last row", tableRowsExceptHeadersAndLastRow);
        listElementsMap.put("remove buttons", removeButtons);
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
     * Retrieves data for each item in the cart, including item ID, description, quantity, price, and total cost.
     *
     * @return a Map where the key is the item ID and the value is another Map containing item details such as "Item ID",
     *         "Description", "Quantity", "Price", and "Total Cost".
     */
    public Map<String, Map<String, String>> getItemsData() {
        Map<String, Map<String, String>> data = new HashMap<>();
        List<WebElement> headers = new ArrayList<>(tableHeaders);
        List<WebElement> rows = new ArrayList<>(tableRowsExceptHeadersAndLastRow);

        rows.forEach(row -> {
            List<WebElement> rowCells = row.findElements(By.tagName("td"));
            Map<String, String> rowData = new HashMap<>();

            IntStream.range(0, headers.size()).forEach(j -> {
                String key = WaitUtils.getTextAfterWait(headers.get(j));
                String value;
                if (j == 4) {
                    value = WaitUtils.getAttributeValueAfterWait(rowCells.get(j).findElement(By.tagName("input")), "value");
                } else {
                    value = WaitUtils.getTextAfterWait(rowCells.get(j));
                }
                rowData.put(key, value);
            });
            data.put(WaitUtils.getTextAfterWait(rowCells.get(0)), rowData);
        });
        return data;
    }

    /**
     * Retrieves the subtotal value from the cart page.
     *
     * @return the subtotal value as a String, formatted to include the currency symbol.
     */
    public String getSubtotal() {
        String totalValue = WaitUtils.getTextAfterWait(subTotalCell);
        totalValue = totalValue.substring(totalValue.indexOf("$"));
        return totalValue;
    }

    /**
     * Clicks the remove button for the item with the specified item ID.
     *
     * @param itemId the ID of the item to be removed.
     */
    public void clickRemoveButtonByItemId(String itemId) {
        WebElement removeButton = Driver.getDriver().findElement(
                By.cssSelector("#Cart a[href*='workingItemId=" + itemId + "']"));
        WaitUtils.clickAfterWait(removeButton);
    }

    /**
     * Enters the specified quantity for the item with the given item ID.
     *
     * @param itemId the ID of the item.
     * @param quantity the quantity to be entered.
     */
    public void enterQuantity(String itemId, String quantity) {
        WebElement quantityInputBox = Driver.getDriver().findElement(By.name(itemId));
        WaitUtils.clearInputBoxAfterWait(quantityInputBox);
        WaitUtils.sendKeysAfterWait(quantityInputBox, quantity);
    }

    /**
     * Retrieves the text of the remove button for the item with the specified item ID.
     *
     * @param itemId the ID of the item.
     * @return the text of the remove button.
     */
    public String getRemoveButtonTextByItemId(String itemId) {
        WebElement removeButton = Driver.getDriver().findElement(By.cssSelector("#Cart a[href*='workingItemId=" + itemId + "']"));
        return WaitUtils.getTextAfterWait(removeButton);
    }

    /**
     * Retrieves the href attribute value of the remove button for the item with the specified item ID.
     *
     * @param itemId the ID of the item.
     * @return the href attribute value of the remove button.
     */
    public String getHrefValueOfRemoveButtonByItemId(String itemId) {
        WebElement removeButton = Driver.getDriver().findElement(By.cssSelector("#Cart a[href*='workingItemId=" + itemId + "']"));
        return WaitUtils.getAttributeValueAfterWait(removeButton, "href");
    }

    /**
     * Retrieves detailed information about the item with the specified item ID.
     *
     * @param itemId the ID of the item.
     * @return a Map containing item details such as "Item ID", "Description", "Quantity", "Price", and "Total Cost".
     */
    public Map<String, String> getItemInfoByItemId(String itemId) {
        List<WebElement> row = Driver.getDriver().findElements(By.xpath("//tbody//td[.='" + itemId + "']/..//td"));
        Map<String, String> itemInfo = new HashMap<>();
        itemInfo.put("Item ID", WaitUtils.getTextAfterWait(row.get(0).findElement(By.tagName("a"))));
        itemInfo.put("Description", WaitUtils.getTextAfterWait(row.get(2)));
        itemInfo.put("Quantity", WaitUtils.getAttributeValueAfterWait(row.get(4).findElement(By.tagName("input")),"value"));
        itemInfo.put("Price", WaitUtils.getTextAfterWait(row.get(5)));
        itemInfo.put("Total Cost", WaitUtils.getTextAfterWait(row.get(6)));
        return itemInfo;
    }
}