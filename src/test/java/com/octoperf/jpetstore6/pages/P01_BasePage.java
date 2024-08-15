package com.octoperf.jpetstore6.pages;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import com.octoperf.jpetstore6.utilities.*;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Base page class providing common functionalities for all pages in the application.
 * This class initializes the web elements and provides methods to interact with and verify elements on the page.
 */
@Slf4j
public abstract class P01_BasePage {

    private final Map<String, WebElement> elementMap = new HashMap<>();
    private final Map<String, List<WebElement>> listElementMap = new HashMap<>();

    /**
     * Initializes the page elements using Selenium's PageFactory.
     */
    public P01_BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#LogoContent img")
    private WebElement logoImage;

    @FindBy(css = "#LogoContent a")
    private WebElement returnToCatalogPageLink;

    @FindBy(css = "#MenuContent img[src*='cart']")
    private WebElement cartImage;

    @FindBy(css = "#MenuContent a[href*='viewCart=']")
    private WebElement cartLink;

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signInLink;

    @FindBy(css = "#MenuContent a[href*='signoff=']")
    private WebElement signOutLink;

    @FindBy(css = "#MenuContent a[href*='AccountForm']")
    private WebElement myAccountLink;

    @FindBy(css = "#MenuContent a[href*='help']")
    private WebElement helpLink;

    @FindBy(css = "#SearchContent input[name='keyword']")
    private WebElement searchInputBox;

    @FindBy(css = "#SearchContent input[name='searchProducts']")
    private WebElement searchButton;

    @FindBy(id = "CTA")
    private WebElement ctaSection;

    @FindBy(css = "#CTA a[href*='octoperf']")
    private WebElement octoPerfLinkInCtaSection;

    @FindBy(id = "PoweredBy")
    private WebElement poweredBySection;

    @FindBy(css = "#PoweredBy a[href*='octoperf']")
    private WebElement octoPerfLinkInPoweredBySection;

    @FindBy(css = "#PoweredBy a[href*='mybatis']")
    private WebElement myBatisLinkInPoweredBySection;

    @FindBy(css = "#Banner img")
    private WebElement favouritePetImage;

    @FindBy(css = "#MenuContent img[src*='separator']")
    private List<WebElement> separatorImagesOnMenuContent;

    @FindBy(css = "#QuickLinks img[src*='separator']")
    private List<WebElement> separatorImagesInQuickLinks;

    @FindBy(css = "#QuickLinks img[src*='sm']")
    private List<WebElement> categoryImagesInQuickLinks;

    @FindBy(css = "#QuickLinks a")
    private List<WebElement> categoryLinksInQuickLinks;

    /**
     * Initializes the element maps with the web elements found on the page.
     */
    public void initializeElementMap() {
        elementMap.put("logo image", logoImage);
        elementMap.put("logo link", returnToCatalogPageLink);
        elementMap.put("cart image", cartImage);
        elementMap.put("cart link", cartLink);
        elementMap.put("sign-in link", signInLink);
        elementMap.put("sign-out link", signOutLink);
        elementMap.put("my account link", myAccountLink);
        elementMap.put("help link", helpLink);
        elementMap.put("search input box", searchInputBox);
        elementMap.put("search button", searchButton);
        elementMap.put("cta section", ctaSection);
        elementMap.put("octoperf link in the cta section", octoPerfLinkInCtaSection);
        elementMap.put("poweredby section", poweredBySection);
        elementMap.put("octoperf link in the poweredby section", octoPerfLinkInPoweredBySection);
        elementMap.put("mybatis link in the poweredby section", myBatisLinkInPoweredBySection);
        elementMap.put("favourite pet image", favouritePetImage);

        listElementMap.put("separator images in the menu content section", separatorImagesOnMenuContent);
        listElementMap.put("separator images in the quick links section", separatorImagesInQuickLinks);
        listElementMap.put("category images in the quick links section", categoryImagesInQuickLinks);
        listElementMap.put("category links in the quick links section", categoryLinksInQuickLinks);
    }

    /**
     * Retrieves a web element based on the provided description.
     *
     * @param elementDescription the description of the web element.
     * @return the WebElement corresponding to the description.
     * @throws IllegalArgumentException if the element description is invalid.
     */
    public WebElement getElement(String elementDescription) {
        WebElement element = elementMap.get(elementDescription.trim().toLowerCase());
        if (element == null) {
            throw new IllegalArgumentException("Invalid element description: " + elementDescription);
        }
        return element;
    }

    /**
     * Retrieves a list of web elements based on the provided description.
     *
     * @param elementDescription the description of the web elements.
     * @return a list of WebElements corresponding to the description.
     * @throws IllegalArgumentException if the element description is invalid.
     */
    public List<WebElement> getElements(String elementDescription) {
        List<WebElement> elements = listElementMap.get(elementDescription.trim().toLowerCase());
        if (elements == null) {
            throw new IllegalArgumentException("Invalid element description: " + elementDescription);
        }
        return elements;
    }

    /**
     * Clicks on a link in the Quick Links section by the category name.
     *
     * @param categoryName the name of the category to click on.
     */
    public void clickLinkInQuickLinksByCategoryName(String categoryName) {
        WebElement link = Driver.getDriver().findElement(By.cssSelector("#QuickLinks a[href*='" + categoryName.toUpperCase() + "']"));
        WaitUtils.clickAfterWait(link);
    }

    /**
     * Retrieves the text before the "|" character in the PoweredBy section.
     *
     * @return the text before the "|" character.
     */
    public String getHostedByText() {
        String poweredBySectionText = WaitUtils.getTextAfterWait(poweredBySection);
        return poweredBySectionText.substring(0, poweredBySectionText.indexOf("|")).trim();
    }

    /**
     * Retrieves the text after the "|" character in the PoweredBy section.
     *
     * @return the text after the "|" character.
     */
    public String getPoweredByText() {
        String poweredBySectionText = WaitUtils.getTextAfterWait(poweredBySection);
        return poweredBySectionText.substring(poweredBySectionText.indexOf("|") + 1).trim();
    }

    /**
     * Verifies if the current page title and URL match the expected values.
     *
     * @param expectedTitle the expected page title.
     * @param expectedUrl the expected page URL.
     * @return true if both title and URL match, false otherwise.
     */
    public boolean verifyTitleAndUrl(String expectedTitle, String expectedUrl) {
        String actualPageTitle = Driver.getDriver().getTitle();
        String actualUrl = UrlUtils.normalizeURL(Driver.getDriver().getCurrentUrl());
        log.info("Actual Title: |{}|", actualPageTitle);
        log.info("Actual Url: |{}|", actualUrl);
        return expectedTitle.equals(actualPageTitle) && expectedUrl.equals(actualUrl);
    }

    /**
     * Sends input to a web element based on the description.
     *
     * @param input the text to send to the web element.
     * @param elementDescription the description of the web element.
     */
    public void sendInput(String input,String elementDescription) {
        WebElement element = getElement(elementDescription);
        WaitUtils.sendKeysAfterWait(element, input);
    }

    /**
     * Clears the input box of a web element based on the description.
     *
     * @param elementDescription the description of the web element.
     */
    public void clearInputBox(String elementDescription) {
        WebElement element = getElement(elementDescription);
        WaitUtils.clearInputBoxAfterWait(element);
    }

    /**
     * Retrieves the text from a list of web elements based on the description.
     *
     * @param elementDescription the description of the web elements.
     * @return a list of text strings from the elements.
     */
    public List<String> getTexts(String elementDescription) {
        List<WebElement> elements = getElements(elementDescription);
        return StreamUtils.getTextOfElements(elements);
    }

    /**
     * Verifies the visibility of a web element based on the description.
     *
     * @param elementDescription the description of the web element.
     * @return true if the element is visible, false otherwise.
     */
    public boolean verifyVisibilityOfElement(String elementDescription) {
        WebElement element = getElement(elementDescription);
        return WaitUtils.isDisplayedAfterWait(element);
    }

    /**
     * Verifies the visibility of multiple web elements based on the description.
     *
     * @param elementDescription the description of the web elements.
     * @return true if all elements are visible, false otherwise.
     */
    public boolean verifyVisibilityOfElements(String elementDescription) {
        List<WebElement> elements = getElements(elementDescription);
        return StreamUtils.verifyElementsAreDisplayed(elements);
    }

    /**
     * Retrieves the text from a web element based on the description.
     *
     * @param elementDescription the description of the web element.
     * @return the text of the web element.
     */
    public String getText(String elementDescription) {
        WebElement element = getElement(elementDescription);
        return WaitUtils.getTextAfterWait(element);
    }

    /**
     * Retrieves the attribute values from a list of web elements based on the description.
     *
     * @param elementDescription the description of the web elements.
     * @param attributeName the name of the attribute to retrieve.
     * @return a list of attribute values.
     */
    public List<String> getAttributeValues(String elementDescription, String attributeName) {
        List<WebElement> elements = getElements(elementDescription);
        return StreamUtils.getElementsAttributeValues(elements, attributeName);
    }

    /**
     * Retrieves the attribute value from a web element based on the description.
     *
     * @param elementDescription the description of the web element.
     * @param attributeName the name of the attribute to retrieve.
     * @return the attribute value.
     */
    public String getAttributeValue(String elementDescription, String attributeName) {
        WebElement element = getElement(elementDescription);
        return WaitUtils.getAttributeValueAfterWait(element, attributeName);
    }

    /**
     * Clicks on a web element based on the description. If the element is a link in the PoweredBy section or a MyBatis link,
     * it switches to a new browser window.
     *
     * @param elementDescription the description of the web element.
     */
    public void clickOn(String elementDescription) {
        WebElement element = getElement(elementDescription);
        WaitUtils.clickAfterWait(element);
        if (elementDescription.trim().toLowerCase().contains("link in the poweredby section") || elementDescription.trim().toLowerCase().contains("mybatis link")) {
            WindowUtils.switchToWindow(1);
        }
    }

    /**
     * Checks if a checkbox or radio button is checked.
     *
     * @param elementDescription the description of the checkbox or radio button.
     * @return "checked" if the element is checked, "unchecked" otherwise.
     */
    public String isChecked(String elementDescription) {
        WebElement element = getElement(elementDescription);
        return CheckboxAndRadioButtonUtils.isCheckboxChecked(element) ? "checked" : "unchecked";
    }
}