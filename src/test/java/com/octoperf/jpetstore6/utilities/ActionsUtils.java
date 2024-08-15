package com.octoperf.jpetstore6.utilities;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Utility class for performing various actions using Selenium's {@link Actions} class.
 * Provides methods for common interactions such as moving to an element, clicking, double-clicking,
 * right-clicking, dragging and dropping, sending keys, and more.
 */
@Slf4j
@UtilityClass
public class ActionsUtils {

    /**
     * Creates a new {@link Actions} instance using the current WebDriver.
     *
     * @return a new {@link Actions} instance
     */
    private static Actions getActions() {
        return new Actions(Driver.getDriver());
    }

    /**
     * Moves the mouse to the specified element.
     * Waits for the element to be visible before performing the action.
     *
     * @param element the WebElement to move to
     */
    public static void moveToElement(WebElement element) {
        WaitUtils.waitForVisibilityOf(element);
        getActions().moveToElement(element).perform();
    }

    /**
     * Clicks the specified element using the Actions class.
     * Moves to the element and then clicks it.
     *
     * @param element the WebElement to click
     */
    public static void clickWithActions(WebElement element) {
        WaitUtils.waitForElementToBeClickable(element);
        getActions().moveToElement(element).click(element).perform();
    }

    /**
     * Double-clicks the specified element using the Actions class.
     * Waits for the element to be clickable before performing the action.
     *
     * @param element the WebElement to double-click
     */
    public static void doubleClick(WebElement element) {
        WaitUtils.waitForElementToBeClickable(element);
        getActions().doubleClick(element).perform();
    }

    /**
     * Right-clicks (context-clicks) on the specified element using the Actions class.
     * Waits for the element to be clickable before performing the action.
     *
     * @param element the WebElement to right-click
     */
    public static void rightClick(WebElement element) {
        WaitUtils.waitForElementToBeClickable(element);
        getActions().contextClick(element).perform();
    }

    /**
     * Drags the source element and drops it on the target element using the Actions class.
     * Waits for both the source and target elements to be in a state where they can be interacted with.
     *
     * @param source the WebElement to drag
     * @param target the WebElement to drop the source element on
     */
    public static void dragAndDrop(WebElement source, WebElement target) {
        WaitUtils.waitForElementToBeClickable(source);
        WaitUtils.waitForVisibilityOf(target);
        getActions().dragAndDrop(source, target).perform();
    }

    /**
     * Sends keys to the specified element using the Actions class.
     * Waits for the element to be clickable before performing the action.
     *
     * @param element the WebElement to send keys to
     * @param keys    the keys to send to the element
     */
    public static void sendKeys(WebElement element, CharSequence... keys) {
        WaitUtils.waitForElementToBeClickable(element);
        getActions().sendKeys(element, keys).perform();
    }

    /**
     * Clicks and holds the specified element using the Actions class.
     * Waits for the element to be clickable before performing the action.
     *
     * @param element the WebElement to click and hold
     */
    public static void clickAndHold(WebElement element) {
        WaitUtils.waitForElementToBeClickable(element);
        getActions().clickAndHold(element).perform();
    }

    /**
     * Releases the mouse button from the specified element using the Actions class.
     * This method is used after clicking and holding or dragging and dropping.
     *
     * @param element the WebElement to release the mouse button from, may be null
     */
    public static void release(WebElement element) {
        getActions().release(element).perform();
    }
}
