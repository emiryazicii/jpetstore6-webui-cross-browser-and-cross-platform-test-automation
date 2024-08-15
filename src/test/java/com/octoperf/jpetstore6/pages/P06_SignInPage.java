package com.octoperf.jpetstore6.pages;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import com.octoperf.jpetstore6.utilities.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the Sign In Page in the application. This page extends {@link P01_BasePage} and includes elements and methods
 * specific to the sign-in functionality.
 */
public class P06_SignInPage extends P01_BasePage {

    private final Map<String, WebElement> elementMap = new HashMap<>();

    /**
     * Initializes the Sign In Page by setting up web elements using Selenium's PageFactory
     * and populating the element map with page-specific elements.
     */
    public P06_SignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        initializeElementMap();
    }

    @FindBy(name = "username")
    private WebElement userNameInputBox;

    @FindBy(name = "password")
    private WebElement passwordInputBox;

    @FindBy(name = "signon")
    private WebElement loginButton;

    @FindBy(css = "form > p:first-of-type")
    private WebElement loginHelperMessage;

    @FindBy(css = "div#Catalog")
    private WebElement registrationHelperMessage;

    @FindBy(css = "div#Catalog > a")
    private WebElement registerNowLink;

    @FindBy(css = "p:nth-of-type(2)")
    private WebElement userNameAndPasswordInputBoxNames;

    @FindBy(css = ".messages li")
    private WebElement failedSignOnMessage;

    @FindBy(css = "#Content .messages li")
    private WebElement checkingOutMessage;

    /**
     * Initializes the element map with elements specific to the Sign In Page.
     * It also calls the superclass method to initialize common elements.
     */
    @Override
    public void initializeElementMap(){
        super.initializeElementMap();
        elementMap.put("username input box", userNameInputBox);
        elementMap.put("password input box", passwordInputBox);
        elementMap.put("login button", loginButton);
        elementMap.put("login helper message", loginHelperMessage);
        elementMap.put("registration helper message", registrationHelperMessage);
        elementMap.put("register now link", registerNowLink);
        elementMap.put("username and password input box names", userNameAndPasswordInputBoxNames);
        elementMap.put("failed sign-on message", failedSignOnMessage);
        elementMap.put("checking out message", checkingOutMessage);
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
     * Logs in the user by entering the provided username and password and clicking the login button.
     *
     * @param username the username for login.
     * @param password the password for login.
     */
    public void login(String username, String password) {
        WaitUtils.sendKeysAfterWait(userNameInputBox, username);
        WaitUtils.clearInputBoxAfterWait(passwordInputBox);
        WaitUtils.sendKeysAfterWait(passwordInputBox, password);
        WaitUtils.clickAfterWait(loginButton);
    }

    /**
     * Retrieves the text from the registration helper message element.
     *
     * @return the text of the registration helper message.
     */
    public String getRegistrationHelperMessageText() {
        String txt = WaitUtils.getTextAfterWait(registrationHelperMessage);
        txt = txt.substring(txt.indexOf("N"), txt.indexOf("!") + 1);
        return txt;
    }

    /**
     * Retrieves the text of the username input box label from the page.
     *
     * @return the text of the username input box label.
     */
    public String getUsernameInputBoxName() {
        String txt = WaitUtils.getTextAfterWait(userNameAndPasswordInputBoxNames);
        txt = txt.replace("\n", "");
        txt = txt.substring(0, txt.indexOf(":") + 1);
        return txt;
    }

    /**
     * Retrieves the text of the password input box label from the page.
     *
     * @return the text of the password input box label.
     */
    public String getPasswordInputBoxName() {
        String txt = WaitUtils.getTextAfterWait(userNameAndPasswordInputBoxNames);
        txt = txt.replace("\n", "");
        txt = txt.substring(txt.indexOf(":") + 1);
        return txt;
    }
}