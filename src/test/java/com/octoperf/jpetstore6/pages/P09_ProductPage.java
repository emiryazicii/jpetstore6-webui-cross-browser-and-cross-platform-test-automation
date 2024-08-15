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
 * Represents the Product Page in the application. This page extends {@link P01_BasePage} and includes elements and methods
 * specific to interacting with individual products.
 */
public class P09_ProductPage extends P01_BasePage {

    private final Map<String, WebElement> elementMap = new HashMap<>();
    private final Map<String, List<WebElement>> listElementsMap = new HashMap<>();

    /**
     * Initializes the Product Page by setting up web elements using Selenium's PageFactory
     * and populating the element map with page-specific elements.
     */
    public P09_ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        initializeElementMap();
    }

    @FindBy(css = "#Catalog h2")
    private WebElement productName;

    @FindBy(css = "#BackLink a")
    private WebElement backLink;

    @FindBy(css = "table th:nth-child(-n+4)")
    private List<WebElement> tableHeaders;

    @FindBy(css = "table tr td:first-child:not(:last-child) a")
    private List<WebElement> itemIdLinks;

    @FindBy(css = "tr td:nth-child(2)")
    private List<WebElement> productIds;

    @FindBy(css = "tr td:nth-child(3)")
    private List<WebElement> descriptions;

    @FindBy(css = "tr td:nth-child(4)")
    private List<WebElement> listPrices;

    @FindBy(css = "tr td:nth-child(5) a")
    private List<WebElement> addToCartButtons;

    /**
     * Initializes the element map with elements specific to the Product Page.
     * It also calls the superclass method to initialize common elements.
     */
    @Override
    public void initializeElementMap() {
        super.initializeElementMap();
        elementMap.put("product name", productName);
        elementMap.put("back link", backLink);

        listElementsMap.put("table headers", tableHeaders);
        listElementsMap.put("item ids", itemIdLinks);
        listElementsMap.put("product ids", productIds);
        listElementsMap.put("descriptions", descriptions);
        listElementsMap.put("list prices", listPrices);
        listElementsMap.put("add to cart buttons", addToCartButtons);
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
     * Clicks on the item link identified by the given item ID.
     *
     * @param itemId the item ID whose link needs to be clicked.
     */
    public void clickItemIdLink(String itemId) {
        WebElement link = Driver.getDriver().findElement(By.cssSelector("a[href*='itemId=" + itemId + "']"));
        WaitUtils.clickAfterWait(link);
    }

    /**
     * Clicks on the "Add to Cart" button for the item identified by the given item ID.
     *
     * @param itemId the item ID whose "Add to Cart" button needs to be clicked.
     */
    public void clickAddToCartButtonByItemId(String itemId) {
        WebElement button = Driver.getDriver().findElement(By.cssSelector("a[href*='workingItemId=" + itemId + "']"));
        WaitUtils.clickAfterWait(button);
    }

    /**
     * Retrieves the href attribute of the link associated with the given item ID.
     *
     * @param itemId the item ID whose link href needs to be retrieved.
     * @return the href attribute of the item link.
     */
    public String getHrefByItemId(String itemId) {
        WebElement link = Driver.getDriver().findElement(By.xpath("//a[.='" + itemId + "']"));
        return WaitUtils.getAttributeValueAfterWait(link, "href");
    }

    /**
     * Retrieves the href attribute of the "Add to Cart" button for the item identified by the given item ID.
     *
     * @param itemId the item ID whose "Add to Cart" button href needs to be retrieved.
     * @return the href attribute of the "Add to Cart" button.
     */
    public String getHrefValueOfAddToCartButtonByItemId(String itemId) {
        WebElement button = Driver.getDriver().findElement(By.cssSelector("a[href*='workingItemId=" + itemId + "']"));
        return WaitUtils.getAttributeValueAfterWait(button, "href");
    }

    /**
     * Retrieves item data for the item identified by the given item ID.
     * The data includes item ID, product ID, description, and list price.
     *
     * @param itemId the item ID whose data needs to be retrieved.
     * @return a Map containing the item ID, product ID, description, and list price.
     */
    public Map<String, String> getItemData(String itemId) {
        List<WebElement> row = Driver.getDriver().findElements(By.xpath("//a[.='" + itemId + "']/../../td"));
        Map<String, String> itemData = new HashMap<>();
        itemData.put("itemId", WaitUtils.getTextAfterWait(row.get(0).findElement(By.tagName("a"))));
        itemData.put("productId", WaitUtils.getTextAfterWait(row.get(1)));
        itemData.put("description", WaitUtils.getTextAfterWait(row.get(2)));
        itemData.put("listPrice", WaitUtils.getTextAfterWait(row.get(3)));
        return itemData;
    }
}