package com.octoperf.jpetstore6.utilities;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;

/**
 * Utility class for handling browser alerts using Selenium WebDriver.
 * Provides methods to accept, dismiss, get text from, and interact with prompts.
 */
@Slf4j
@UtilityClass
public class AlertUtils {

    /**
     * Retrieves the current alert, waiting if necessary.
     *
     * @return the current {@link Alert}
     * @throws TimeoutException if the alert is not present within the timeout period
     */
    private static Alert getAlert() {
        WaitUtils.waitForAlertIsPresent();
        return Driver.getDriver().switchTo().alert();
    }

    /**
     * Accepts the current alert.
     * If no alert is present, it throws an exception.
     */
    public static void acceptAlert() {
        Alert alert = getAlert();
        alert.accept();
    }

    /**
     * Dismisses the current alert.
     * If no alert is present, it throws an exception.
     */
    public static void dismissAlert() {
        Alert alert = getAlert();
        alert.dismiss();
    }

    /**
     * Retrieves the text from the current alert.
     *
     * @return the alert text
     * @throws NoAlertPresentException if no alert is present
     */
    public static String getAlertText() {
        Alert alert = getAlert();
        return alert.getText();
    }

    /**
     * Types the given text into the prompt of the current alert and then accepts it.
     *
     * @param text the text to type into the prompt
     * @throws IllegalArgumentException if the text is null
     * @throws NoAlertPresentException if no alert is present
     */
    public static void typeInPrompt(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        Alert alert = getAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    /**
     * Checks if an alert is present.
     *
     * @return {@code true} if an alert is present, {@code false} otherwise
     */
    public static boolean isAlertPresent() {
        try {
            getAlert();
            return true;
        } catch (NoAlertPresentException | TimeoutException e) {
            return false;
        }
    }
}