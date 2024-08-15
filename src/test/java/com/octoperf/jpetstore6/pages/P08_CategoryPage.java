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
 * Represents the Category Page in the application. This page extends {@link P01_BasePage} and includes elements and methods
 * specific to interacting with product categories.
 */
public class P08_CategoryPage extends P01_BasePage {

    private final Map<String, WebElement> elementMap = new HashMap<>();
    private final Map<String, List<WebElement>> listElementsMap = new HashMap<>();

    /**
     * Initializes the Category Page by setting up web elements using Selenium's PageFactory
     * and populating the element map with page-specific elements.
     */
    public P08_CategoryPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        initializeElementMap();
    }

    @FindBy(css = "#Catalog h2")
    private WebElement categoryName;

    @FindBy(css = "#BackLink a")
    private WebElement backlink;

    @FindBy(css = "table th")
    private List<WebElement> tableHeaders;

    @FindBy(css = "td a")
    private List<WebElement> productIdLinks;

    @FindBy(css = "td:nth-of-type(2)")
    private List<WebElement> productNames;

    /**
     * Initializes the element map with elements specific to the Category Page.
     * It also calls the superclass method to initialize common elements.
     */
    @Override
    public void initializeElementMap() {
        super.initializeElementMap();
        elementMap.put("category name", categoryName);
        elementMap.put("back link", backlink);

        listElementsMap.put("table headers", tableHeaders);
        listElementsMap.put("product ids", productIdLinks);
        listElementsMap.put("product names", productNames);
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
     * Clicks on the product link identified by the given product ID.
     *
     * @param productId the product ID whose link needs to be clicked.
     */
    public void clickOnProductIdLink(String productId) {
        WebElement link = Driver.getDriver().findElement(By.cssSelector("a[href*='" + productId + "']"));
        WaitUtils.clickAfterWait(link);
    }

    /**
     * Retrieves the href attribute of the product link identified by the given product ID.
     *
     * @param productId the product ID whose link href needs to be retrieved.
     * @return the href attribute of the product link.
     */
    public String getHrefByProductId(String productId) {
        WebElement link = Driver.getDriver().findElement(By.xpath("//a[.='" + productId + "']"));
        return WaitUtils.getAttributeValueAfterWait(link, "href");
    }

    /**
     * Retrieves product data for the product identified by the given product ID.
     * The data includes product ID and product name.
     *
     * @param productId the product ID whose data needs to be retrieved.
     * @return a Map containing the product ID and product name.
     */
    public Map<String, String> getProductData(String productId) {
        List<WebElement> row = Driver.getDriver().findElements(By.xpath("//a[.='" + productId + "']/../../td"));
        Map<String, String> productData = new HashMap<>();
        productData.put("productId", WaitUtils.getTextAfterWait(row.get(0).findElement(By.tagName("a"))));
        productData.put("productName", WaitUtils.getTextAfterWait(row.get(1)));
        return productData;
    }
}