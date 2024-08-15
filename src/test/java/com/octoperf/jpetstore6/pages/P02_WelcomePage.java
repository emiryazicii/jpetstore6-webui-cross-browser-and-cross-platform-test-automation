package com.octoperf.jpetstore6.pages;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the Welcome Page in the application. This page extends {@link P01_BasePage} and includes additional
 * elements specific to the Welcome Page.
 */
public class P02_WelcomePage extends P01_BasePage {

    private final Map<String, WebElement> elementMap = new HashMap<>();

    /**
     * Initializes the Welcome Page by setting up web elements using Selenium's PageFactory
     * and populating the element map with page-specific elements.
     */
    public P02_WelcomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
        initializeElementMap();
    }

    @FindBy(css = "h2")
    private WebElement welcomeHeader;

    @FindBy(css = "a[href*='Catalog']")
    private WebElement enterTheStoreLink;

    @FindBy(css = "sub")
    private WebElement copyrightSubtitle;

    /**
     * Initializes the element map with elements specific to the Welcome Page.
     * It also calls the superclass method to initialize common elements.
     */
    @Override
    public void initializeElementMap() {
        super.initializeElementMap();
        elementMap.put("welcome header", welcomeHeader);
        elementMap.put("enter the store link", enterTheStoreLink);
        elementMap.put("copyright subtitle", copyrightSubtitle);
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
}