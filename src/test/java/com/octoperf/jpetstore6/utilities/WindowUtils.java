package com.octoperf.jpetstore6.utilities;

import com.octoperf.jpetstore6.singletonDriver.Driver;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Utility class for handling browser window and tab operations.
 */
@UtilityClass
public class WindowUtils {

    /**
     * Switches to the specified window by index.
     *
     * @param windowIndex the index of the window to switch to
     * @throws IllegalArgumentException if the window index is invalid
     */
    public static void switchToWindow(int windowIndex) {
        List<String> windowHandles = new ArrayList<>(Driver.getDriver().getWindowHandles());
        if (windowIndex >= 0 && windowIndex < windowHandles.size()) {
            Driver.getDriver().switchTo().window(windowHandles.get(windowIndex));
        } else {
            throw new IllegalArgumentException("Invalid window index: " + windowIndex);
        }
    }

    /**
     * Switches to a window and verifies its URL and title.
     *
     * @param expectedURL the expected URL fragment
     * @param expectedTitle the expected title fragment
     * @return {@code true} if the window is found and its title contains the expected title
     * @throws IllegalArgumentException if no window with the expected URL and title is found
     */
    public static boolean switchWindowAndVerify(String expectedURL, String expectedTitle) {
        Set<String> allHandles = Driver.getDriver().getWindowHandles();
        for (String eachHandle : allHandles) {
            Driver.getDriver().switchTo().window(eachHandle);
            if (Driver.getDriver().getCurrentUrl().contains(expectedURL)) {
                return Driver.getDriver().getTitle().contains(expectedTitle);
            }
        }
        throw new IllegalArgumentException("No window found with URL containing: " + expectedURL + " and title containing: " + expectedTitle);
    }

    /**
     * Switches to a window with the specified title.
     *
     * @param targetTitle the title of the window to switch to
     */
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    /**
     * Closes all tabs except the main tab.
     */
    public static void closeAllTabsExceptMain() {
        String mainHandle = Driver.getDriver().getWindowHandles().iterator().next();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            if (!handle.equals(mainHandle)) {
                Driver.getDriver().switchTo().window(handle);
                Driver.closeDriver();
            }
        }
        Driver.getDriver().switchTo().window(mainHandle);
    }

    /**
     * Closes the current window and switches to the parent window.
     */
    public static void closeCurrentWindow() {
        String parentHandle = Driver.getDriver().getWindowHandles().iterator().next();
        Driver.closeDriver();
        switchToWindow(parentHandle);
    }

    /**
     * Switches to the parent window of the current window.
     */
    public static void switchToParentWindow() {
        String parentHandle = Driver.getDriver().getWindowHandles().iterator().next();
        Driver.getDriver().switchTo().window(parentHandle);
    }

    /**
     * Gets the title of the current window.
     *
     * @return the title of the current window
     */
    public static String getCurrentWindowTitle() {
        return Driver.getDriver().getTitle();
    }

    /**
     * Gets the URL of the current window.
     *
     * @return the URL of the current window
     */
    public static String getCurrentWindowUrl() {
        return Driver.getDriver().getCurrentUrl();
    }

    /**
     * Gets the handle of the current window.
     *
     * @return the handle of the current window
     */
    public static String getCurrentWindowHandle() {
        return Driver.getDriver().getWindowHandle();
    }

    /**
     * Opens a new browser tab.
     */
    public static void openNewTab() {
        Driver.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.chord(Keys.CONTROL, "t"));
    }

    /**
     * Closes the current browser tab.
     */
    public static void closeCurrentTab() {
        Driver.getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.chord(Keys.CONTROL, "w"));
    }

    /**
     * Gets the number of currently open tabs.
     *
     * @return the number of open tabs
     */
    public static int getNumberOfOpenTabs() {
        return Driver.getDriver().getWindowHandles().size();
    }
}