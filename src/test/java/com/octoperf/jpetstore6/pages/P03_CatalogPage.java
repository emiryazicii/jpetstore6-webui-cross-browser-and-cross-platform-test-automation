package com.octoperf.jpetstore6.pages;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import com.octoperf.jpetstore6.utilities.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the Catalog Page in the application. This page extends {@link P01_BasePage} and includes elements
 * specific to the Catalog Page.
 */
public class P03_CatalogPage extends P01_BasePage {

    private final Map<String, WebElement> elementMap = new HashMap<>();
    private final Map<String, List<WebElement>> listElementsMap = new HashMap<>();

    /**
     * Initializes the Catalog Page by setting up web elements using Selenium's PageFactory
     * and populating the element maps with page-specific elements.
     */
    public P03_CatalogPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        initializeElementMap();
    }

    @FindBy(id = "WelcomeContent")
    private WebElement welcomeMessage;

    @FindBy(css = "#MainImageContent > img")
    private WebElement mainImage;

    @FindBy(id = "SidebarContent")
    private WebElement sideBarSection;

    @FindBy(css = "#BackLink a")
    private WebElement backLink;

    @FindBy(css = "ul:nth-of-type(1) li")
    private WebElement emptySearchWarningMessage;

    @FindBy(css = "ul li")
    private List<WebElement> emptySearchWarningMessages;

    @FindBy(css = "tbody td font")
    private List<WebElement> productIdTexts;

    @FindBy(css = "tbody td b a")
    private List<WebElement> productIdLinks;

    @FindBy(css = "tbody td:nth-of-type(3)")
    private List<WebElement> productNames;

    @FindBy(css = "tbody td img")
    private List<WebElement> productImages;

    @FindBy(css = "tbody td:nth-of-type(1) a:nth-of-type(1)")
    private List<WebElement> productDescriptions;

    @FindBy(css = "map[name='estoremap'] area")
    private List<WebElement> mainImageLinks;

    @FindBy(css = "#SidebarContent img")
    private List<WebElement> sideBarImages;

    @FindBy(css = "#SidebarContent a")
    private List<WebElement> sideBarLinks;

    @FindBy(css = "tbody th:not(:first-child)")
    private List<WebElement> tableHeaders;

    /**
     * Initializes the element maps with elements specific to the Catalog Page.
     * It also calls the superclass method to initialize common elements.
     */
    @Override
    public void initializeElementMap() {
        super.initializeElementMap();
        elementMap.put("welcome message", welcomeMessage);
        elementMap.put("main image", mainImage);
        elementMap.put("sidebar section", sideBarSection);
        elementMap.put("back link", backLink);
        elementMap.put("empty search warning message", emptySearchWarningMessage);

        listElementsMap.put("main image links", mainImageLinks);
        listElementsMap.put("sidebar images", sideBarImages);
        listElementsMap.put("sidebar links", sideBarLinks);
        listElementsMap.put("table headers", tableHeaders);
        listElementsMap.put("product id links",productIdLinks);
        listElementsMap.put("product id texts", productIdTexts);
        listElementsMap.put("product names", productNames);
        listElementsMap.put("product images", productImages);
        listElementsMap.put("product descriptions", productDescriptions);
        listElementsMap.put("empty search warning messages", emptySearchWarningMessages);
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
     * Retrieves a list of web elements based on the provided description. If the elements are not found in the current
     * page's map, it falls back to the superclass map.
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
     * Retrieves the sidebar text as a list, where the text is split based on a specific delimiter.
     *
     * @return a list of strings representing the sidebar text.
     */
    private List<String> getSideBarTextAsList() {
        String text = WaitUtils.getTextAfterWait(sideBarSection);
        text = text.replaceAll("\n", "-");
        return Arrays.asList(text.split("--"));
    }

    /**
     * Retrieves the index of a category in the sidebar section based on the category name.
     *
     * @param categoryName the name of the category.
     * @return the index of the category in the sidebar section.
     */
    private int getCategoryIndexByCategoryNameInSideBarSection(String categoryName) {
        List<String> categories = Arrays.asList("FISH", "DOGS", "CATS", "REPTILES", "BIRDS");
        return categories.indexOf(categoryName.toUpperCase());
    }

    /**
     * Retrieves the text from the sidebar for a given category name.
     *
     * @param categoryName the name of the category.
     * @return the text associated with the category in the sidebar.
     */
    public String getTextInSideBarByCategoryName(String categoryName) {
        int index = getCategoryIndexByCategoryNameInSideBarSection(categoryName);
        return getSideBarTextAsList().get(index);
    }

    /**
     * Retrieves the source URL of a product image based on the product name.
     *
     * @param productName the name of the product.
     * @return the source URL of the product image.
     */
    public String getSrcValueByProductName(String productName){
        WebElement image = Driver.getDriver().findElement(By.xpath("//td[contains(text(),'" + productName + "')]/..//img"));
        return WaitUtils.getAttributeValueAfterWait(image,"src");
    }

    /**
     * Clicks on a link in the main image area based on the category name.
     *
     * @param categoryName the name of the category.
     */
    public void clickLinkInMainImageByCategoryName(String categoryName) {
        WebElement link = Driver.getDriver().findElement(By.cssSelector("#MainImageContent area[href*='" + categoryName.toUpperCase() + "']"));
        WaitUtils.clickAfterWait(link);
    }

    /**
     * Clicks on a link in the sidebar based on the category name.
     *
     * @param categoryName the name of the category.
     */
    public void clickLinkInSideBarByCategoryName(String categoryName) {
        WebElement link = Driver.getDriver().findElement(By.cssSelector("#Sidebar a[href*='" + categoryName.toUpperCase() + "']"));
        WaitUtils.clickAfterWait(link);
    }

    /**
     * Clicks on a product image based on the product name.
     *
     * @param productName the name of the product.
     */
    public void clickProductImageByProductName(String productName) {
        WebElement image = Driver.getDriver().findElement(By.xpath("//td[.='" + productName + "']/..//img"));
        WaitUtils.clickAfterWait(image);
    }

    /**
     * Clicks on the product description based on the product name.
     *
     * @param productName the name of the product.
     */
    public void clickProductDescriptionByProductName(String productName) {
        WebElement productDescription = Driver.getDriver().findElement(By.xpath("//td[.='" + productName + "']/..//img/.."));
        WaitUtils.clickAfterWait(productDescription);

    }

    /**
     * Clicks on the product ID link based on the product name.
     *
     * @param productName the name of the product.
     */
    public void clickProductIdByProductName(String productName) {
        WebElement productId = Driver.getDriver().findElement(By.xpath("//td[.='" + productName + "']/..//b/a"));
        WaitUtils.clickAfterWait(productId);
    }

    /**
     * Retrieves data about a product based on the product name. The data includes:
     * <ul>
     *     <li>Product image source URL</li>
     *     <li>Product description</li>
     *     <li>Product link href</li>
     *     <li>Product ID</li>
     *     <li>Product ID link href</li>
     *     <li>Product name</li>
     * </ul>
     *
     * @param productName the name of the product.
     * @return a map containing product data.
     */
    public Map<String, String> getProductData(String productName) {
        WebElement row = Driver.getDriver().findElement(By.xpath("//td[contains(text(),'" + productName + "')]/.."));
        Map<String, String> productData = new HashMap<>();
        productData.put("productDescription", WaitUtils.getTextAfterWait(row.findElement(By.xpath(".//img/.."))));
        productData.put("productLinkHref", WaitUtils.getAttributeValueAfterWait(row.findElement(By.xpath(".//img/..")), "href"));
        productData.put("productId", WaitUtils.getTextAfterWait(row.findElement(By.xpath(".//font"))));
        productData.put("productIdLinkHref", WaitUtils.getAttributeValueAfterWait(row.findElement(By.xpath(".//b/a")), "href"));
        productData.put("productName", WaitUtils.getTextAfterWait(row.findElement(By.xpath(".//td[3]"))));
        return productData;
    }
}