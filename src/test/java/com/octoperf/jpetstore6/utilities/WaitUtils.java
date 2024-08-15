package com.octoperf.jpetstore6.utilities;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.octoperf.jpetstore6.utilities.UrlUtils.normalizeURL;

/**
 * WaitUtils provides utility methods for handling WebDriver waits for various conditions
 * to ensure elements are in the expected state before performing actions.
 */
@UtilityClass
public class WaitUtils {

    private static WebDriverWait getWait() {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }

    /**
     * Waits for an alert to be present.
     */
    public static void waitForAlertIsPresent() {
        getWait().until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Waits for an element's selection state to match the expected state.
     *
     * @param element The WebElement to check.
     * @param selected The expected selection state.
     */
    public static void waitForElementSelectionStateToBe(WebElement element, boolean selected) {
        getWait().until(ExpectedConditions.elementSelectionStateToBe(element, selected));
    }

    /**
     * Waits for an element to be clickable.
     *
     * @param element The WebElement to check.
     */
    public static void waitForElementToBeClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for an element to be selected.
     *
     * @param element The WebElement to check.
     */
    public static void waitForElementToBeSelected(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeSelected(element));
    }

    /**
     * Waits for a frame to be available and switches to it.
     *
     * @param element The frame element to switch to.
     */
    public static void waitForFrameToBeAvailableAndSwitchToIt(WebElement element) {
        getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    /**
     * Waits for an element to be invisible.
     *
     * @param element The WebElement to check.
     */
    public static void waitForInvisibilityOf(WebElement element) {
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Waits for all elements in a list to be invisible.
     *
     * @param elements The list of WebElements to check.
     */
    public static void waitForInvisibilityOfAllElements(List<WebElement> elements) {
        getWait().until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    /**
     * Waits for all elements located by the given locator to be present.
     *
     * @param locator The By locator of the elements.
     */
    public static void waitForPresenceOfAllElementsLocatedBy(By locator) {
        getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    /**
     * Waits for an element located by the given locator to be present.
     *
     * @param locator The By locator of the element.
     */
    public static void waitForPresenceOfElementLocated(By locator) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Waits for a nested element located by the given locator to be present.
     *
     * @param locator The By locator of the parent element.
     * @param childLocator The By locator of the nested element.
     */
    public static void waitForPresenceOfNestedElementLocatedBy(By locator, By childLocator) {
        getWait().until(ExpectedConditions.presenceOfNestedElementLocatedBy(locator, childLocator));
    }

    /**
     * Waits for nested elements located by the given locator to be present.
     *
     * @param locator The By locator of the parent element.
     * @param childLocator The By locator of the nested elements.
     */
    public static void waitForPresenceOfNestedElementsLocatedBy(By locator, By childLocator) {
        getWait().until(ExpectedConditions.presenceOfNestedElementsLocatedBy(locator, childLocator));
    }

    /**
     * Waits for an element to become stale.
     *
     * @param element The WebElement to check.
     */
    public static void waitForStalenessOf(WebElement element) {
        getWait().until(ExpectedConditions.stalenessOf(element));
    }

    /**
     * Waits for the title of the page to contain the specified text.
     *
     * @param title The title text to check for.
     */
    public static void waitForTitleContains(String title) {
        getWait().until(ExpectedConditions.titleContains(title));
    }

    /**
     * Waits for the title of the page to be exactly equal to the specified text.
     *
     * @param title The exact title text to check for.
     */
    public static void waitForTitleIs(String title) {
        getWait().until(ExpectedConditions.titleIs(title));
    }

    /**
     * Waits for an element to be visible.
     *
     * @param element The WebElement to check.
     */
    public static void waitForVisibilityOf(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for all elements in a list to be visible.
     *
     * @param elements The list of WebElements to check.
     */
    public static void waitForVisibilityOfAllElements(List<WebElement> elements) {
        getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    /**
     * Waits for all elements located by the given locator to be visible.
     *
     * @param locator The By locator of the elements.
     */
    public static void waitForVisibilityOfAllElementsLocatedBy(By locator) {
        getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    /**
     * Waits for an element located by the given locator to be visible.
     *
     * @param locator The By locator of the element.
     */
    public static void waitForVisibilityOfElementLocated(By locator) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for an element's attribute to have a specific value.
     *
     * @param element The WebElement to check.
     * @param attributeName The name of the attribute.
     * @param expectedValue The expected value of the attribute.
     */
    public static void waitForAttributeValueToBe(WebElement element, String attributeName, String expectedValue) {
        getWait().until(ExpectedConditions.attributeToBe(element, attributeName, expectedValue));
    }

    /**
     * Waits for an element's attribute to contain a specific substring.
     *
     * @param element The WebElement to check.
     * @param attributeName The name of the attribute.
     * @param expectedSubstring The expected substring of the attribute.
     */
    public static void waitForAttributeContains(WebElement element, String attributeName, String expectedSubstring) {
        getWait().until(ExpectedConditions.attributeContains(element, attributeName, expectedSubstring));
    }

    /**
     * Clicks an element after waiting for it to be clickable.
     *
     * @param element The WebElement to click.
     */
    public static void clickAfterWait(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    /**
     * Checks if an element is displayed after waiting for it to be visible.
     *
     * @param element The WebElement to check.
     * @return True if the element is displayed, otherwise false.
     */
    public static boolean isDisplayedAfterWait(WebElement element) {
        waitForVisibilityOf(element);
        return element.isDisplayed();
    }

    /**
     * Retrieves the text of an element after waiting for it to be visible.
     *
     * @param element The WebElement to retrieve text from.
     * @return The text of the element.
     */
    public static String getTextAfterWait(WebElement element) {
        waitForVisibilityOf(element);
        return element.getText();
    }

    /**
     * Retrieves the value of an element's attribute after waiting for it to be visible.
     *
     * @param element The WebElement to retrieve the attribute from.
     * @param attribute The name of the attribute.
     * @return The attribute value.
     */
    public static String getAttributeValueAfterWait(WebElement element, String attribute) {
        waitForVisibilityOf(element);
        if (attribute.equalsIgnoreCase("href")) {
            return normalizeURL(element.getAttribute("href"));
        } else {
            return element.getAttribute(attribute);
        }
    }

    /**
     * Sends keys to an element after waiting for it to be clickable.
     *
     * @param element The WebElement to send keys to.
     * @param keyToSend The keys to send.
     */
    public static void sendKeysAfterWait(WebElement element, String keyToSend) {
        waitForElementToBeClickable(element);
        element.sendKeys(keyToSend);
    }

    /**
     * Clears the text of an input box after waiting for it to be clickable.
     *
     * @param inputBox The WebElement representing the input box.
     */
    public static void clearInputBoxAfterWait(WebElement inputBox) {
        waitForElementToBeClickable(inputBox);
        inputBox.clear();
    }

    /**
     * Retrieves the value of a CSS property from an element after waiting for it to be visible.
     *
     * @param element The WebElement to retrieve the CSS property from.
     * @param cssProperty The name of the CSS property.
     * @return The value of the CSS property.
     */
    public static String getCssValueAfterWait(WebElement element, String cssProperty) {
        waitForVisibilityOf(element);
        return element.getCssValue(cssProperty);
    }
}