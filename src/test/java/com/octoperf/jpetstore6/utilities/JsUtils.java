package com.octoperf.jpetstore6.utilities;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * JsUtils provides utility methods for interacting with web elements using JavaScript.
 * These methods are used for actions such as clicking elements, scrolling, and highlighting elements.
 */
@UtilityClass
public class JsUtils {

    /**
     * Retrieves the {@link JavascriptExecutor} instance from the WebDriver.
     *
     * @return The {@link JavascriptExecutor} instance.
     */
    private static JavascriptExecutor getJsExecutor() {
        return (JavascriptExecutor) Driver.getDriver();
    }

    /**
     * Clicks on a web element using JavaScript.
     *
     * @param element The {@link WebElement} to be clicked.
     */
    public static void clickElementWithJs(WebElement element) {
        getJsExecutor().executeScript("arguments[0].click();", element);
    }

    /**
     * Scrolls the browser window to the bottom of the page.
     */
    public static void scrollToBottom() {
        getJsExecutor().executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    /**
     * Highlights a web element by changing its border color.
     *
     * @param element The {@link WebElement} to be highlighted.
     */
    public static void highlightElement(WebElement element) {
        getJsExecutor().executeScript("arguments[0].style.border='2px solid red';", element);
    }

    /**
     * Removes the highlight from a web element by resetting its border color.
     *
     * @param element The {@link WebElement} from which the highlight should be removed.
     */
    public static void removeHighlight(WebElement element) {
        getJsExecutor().executeScript("arguments[0].style.border='';", element);
    }

    /**
     * Scrolls the browser window to a specific vertical offset.
     *
     * @param yOffset The vertical offset (in pixels) to scroll to.
     */
    public static void scrollToVerticalOffset(int yOffset) {
        getJsExecutor().executeScript("window.scrollTo(0, arguments[0]);", yOffset);
    }

    /**
     * Scrolls the browser window to bring a web element into view.
     *
     * @param element The {@link WebElement} to be brought into view.
     */
    public static void scrollIntoView(WebElement element) {
        getJsExecutor().executeScript("arguments[0].scrollIntoView();", element);
    }
}