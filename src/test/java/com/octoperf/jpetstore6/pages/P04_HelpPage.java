package com.octoperf.jpetstore6.pages;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the Help Page in the application. This page extends {@link P01_BasePage} and includes elements
 * specific to the Help Page.
 */
public class P04_HelpPage extends P01_BasePage {

    private final Map<String, WebElement> elementMap = new HashMap<>();
    private final Map<String, List<WebElement>> listElementsMap = new HashMap<>();

    /**
     * Initializes the Help Page by setting up web elements using Selenium's PageFactory
     * and populating the element maps with page-specific elements.
     */
    public P04_HelpPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        initializeElementMap();
    }

    @FindBy(xpath = "//h1/following-sibling::p[position() <= 1]")
    private WebElement jPetStoreDemoParagraph;

    @FindBy(xpath = "//a[@id='SigningUp']/../following-sibling::p[position() <= 1]")
    private WebElement signingUpParagraph;

    @FindBy(xpath = "//a[@id='Catalog']/../following-sibling::p[position() <= 1]")
    private WebElement workingWithTheProductCatalogParagraph;

    @FindBy(xpath = "//a[@id='CatalogSearching']/../following-sibling::p[position() <= 1]")
    private WebElement searchingTheCatalogParagraph;

    @FindBy(css = "#Content sub")
    private WebElement copyrightSubtitle;

    @FindBy(css = "h4, h2, h1")
    private List<WebElement> allHeaders;

    @FindBy(css = "#Content p")
    private List<WebElement> allParagraphs;

    @FindBy(css = "ul a")
    private List<WebElement> headerLinks;

    @FindBy(xpath = "//a[@id='SigningIn']/../following-sibling::p[position() <= 2]")
    private List<WebElement> signingInParagraphs;

    @FindBy(xpath = "//a[@id='CatalogBrowsing']/../following-sibling::p[position() <= 3]")
    private List<WebElement> browsingTheCatalogParagraphs;

    @FindBy(xpath = "//a[@id='ShoppingCartAdd']/../following-sibling::p[position() <= 3]")
    private List<WebElement> addingAndRemovingItemsParagraphs;

    @FindBy(xpath = "//a[@id='ShoppingCartUpdate']/../following-sibling::p[position() <= 2]")
    private List<WebElement> updatingTheQuantityOfAnItemParagraphs;

    @FindBy(xpath = "//a[@id='Ordering']/../following-sibling::p[position() <= 2]")
    private List<WebElement> orderingItemParagraphs;

    @FindBy(xpath = "//a[@id='OrderReview']/../following-sibling::p[position() <= 2]")
    private List<WebElement> reviewingAnOrderParagraphs;

    /**
     * Initializes the element maps with elements specific to the Help Page.
     * It also calls the superclass method to initialize common elements.
     */
    @Override
    public void initializeElementMap() {
        super.initializeElementMap();
        elementMap.put("jpetstore demo paragraph", jPetStoreDemoParagraph);
        elementMap.put("signing up paragraph", signingUpParagraph);
        elementMap.put("working with the product catalog paragraph", workingWithTheProductCatalogParagraph);
        elementMap.put("searching the catalog paragraph", searchingTheCatalogParagraph);
        elementMap.put("copyright subtitle", copyrightSubtitle);
        elementMap.put("signing up link",headerLinks.get(0));
        elementMap.put("signing in link",headerLinks.get(1));
        elementMap.put("working with the product catalog link",headerLinks.get(2));
        elementMap.put("browsing the catalog link",headerLinks.get(3));
        elementMap.put("searching the catalog link",headerLinks.get(4));
        elementMap.put("working with the shopping cart link",headerLinks.get(5));
        elementMap.put("adding and removing items link",headerLinks.get(6));
        elementMap.put("updating the quantity of an item link",headerLinks.get(7));
        elementMap.put("ordering items link",headerLinks.get(8));
        elementMap.put("reviewing an order link",headerLinks.get(9));
        elementMap.put("known issues link",headerLinks.get(10));

        listElementsMap.put("all headers", allHeaders);
        listElementsMap.put("all paragraphs", allParagraphs);
        listElementsMap.put("header links", headerLinks);
        listElementsMap.put("signing in paragraphs", signingInParagraphs);
        listElementsMap.put("browsing the catalog paragraphs", browsingTheCatalogParagraphs);
        listElementsMap.put("adding and removing items paragraphs", addingAndRemovingItemsParagraphs);
        listElementsMap.put("updating the quantity of an item paragraphs", updatingTheQuantityOfAnItemParagraphs);
        listElementsMap.put("ordering item paragraphs", orderingItemParagraphs);
        listElementsMap.put("reviewing an order paragraphs", reviewingAnOrderParagraphs);
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
}