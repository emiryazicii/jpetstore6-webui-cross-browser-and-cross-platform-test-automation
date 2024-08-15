package com.octoperf.jpetstore6.pages;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import com.octoperf.jpetstore6.utilities.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the Item Page in the application. This page extends {@link P01_BasePage} and includes elements and methods
 * specific to viewing detailed information about an individual item.
 */
public class P10_ItemPage extends P01_BasePage {

    private final Map<String, WebElement> elementMap = new HashMap<>();

    /**
     * Initializes the Item Page by setting up web elements using Selenium's PageFactory
     * and populating the element map with page-specific elements.
     */
    public P10_ItemPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        initializeElementMap();
    }

    @FindBy(css = "tr:nth-child(1) img")
    private WebElement itemImage;

    @FindBy(css = "tr:nth-child(1) td")
    private WebElement itemInformation;

    @FindBy(css = "tr:nth-child(2) b")
    private WebElement itemId;

    @FindBy(tagName = "font")
    private WebElement itemDescription;

    @FindBy(css = "tr:nth-child(4) td")
    private WebElement productName;

    @FindBy(css = "tr:nth-child(5) td")
    private WebElement stockInfo;

    @FindBy(css = "tr:nth-child(6) td")
    private WebElement itemPrice;

    @FindBy(css = "a[href*='addItemToCart']")
    private WebElement addToCartButton;

    @FindBy(css = "#BackLink a")
    private WebElement backLink;

    /**
     * Initializes the element map with elements specific to the Item Page.
     * It also calls the superclass method to initialize common elements.
     */
    @Override
    public void initializeElementMap() {
        super.initializeElementMap();
        elementMap.put("item image", itemImage);
        elementMap.put("item information", itemInformation);
        elementMap.put("item id", itemId);
        elementMap.put("item description", itemDescription);
        elementMap.put("product name", productName);
        elementMap.put("stock info", stockInfo);
        elementMap.put("item price", itemPrice);
        elementMap.put("add to cart button", addToCartButton);
        elementMap.put("back link", backLink);
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
     * Retrieves detailed information about the item on the page.
     * The information includes item ID, description, product name, stock status, and price.
     *
     * @return a Map containing detailed item information with keys such as "itemInformation", "itemId", "description",
     *         "productName", "stockInfo", and "listPrice".
     */
    public Map<String, String> getDetailedItemInformation() {
        Map<String, String> itemInfo = new HashMap<>();
        itemInfo.put("itemInformation", WaitUtils.getTextAfterWait(itemInformation));
        itemInfo.put("itemId", WaitUtils.getTextAfterWait(itemId));
        itemInfo.put("description", WaitUtils.getTextAfterWait(itemDescription));
        itemInfo.put("productName", WaitUtils.getTextAfterWait(productName));
        itemInfo.put("stockInfo", WaitUtils.getTextAfterWait(stockInfo).equalsIgnoreCase("back ordered.") ? "false" : "true");
        itemInfo.put("listPrice", WaitUtils.getTextAfterWait(itemPrice));
        return itemInfo;
    }
}