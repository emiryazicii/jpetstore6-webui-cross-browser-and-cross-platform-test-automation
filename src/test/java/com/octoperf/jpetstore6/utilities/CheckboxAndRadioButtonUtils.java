package com.octoperf.jpetstore6.utilities;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Utility class for handling checkboxes and radio buttons using Selenium WebDriver.
 * Provides methods to check/uncheck checkboxes and select/deselect radio buttons.
 */
@UtilityClass
public class CheckboxAndRadioButtonUtils {

    /**
     * Checks the specified checkbox if it is not already checked.
     *
     * @param checkbox the {@link WebElement} representing the checkbox to be checked
     */
    public static void checkCheckbox(WebElement checkbox) {
        WaitUtils.waitForElementToBeClickable(checkbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    /**
     * Unchecks the specified checkbox if it is not already unchecked.
     *
     * @param checkbox the {@link WebElement} representing the checkbox to be unchecked
     */
    public static void uncheckCheckbox(WebElement checkbox) {
        WaitUtils.waitForElementToBeClickable(checkbox);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    /**
     * Checks if the specified checkbox is checked.
     *
     * @param checkbox the {@link WebElement} representing the checkbox
     * @return {@code true} if the checkbox is checked, {@code false} otherwise
     */
    public static boolean isCheckboxChecked(WebElement checkbox) {
        WaitUtils.waitForVisibilityOf(checkbox);
        return checkbox.isSelected();
    }

    /**
     * Selects the specified radio button if it is not already selected.
     *
     * @param radioButton the {@link WebElement} representing the radio button to be selected
     */
    public static void selectRadioButton(WebElement radioButton) {
        WaitUtils.waitForElementToBeClickable(radioButton);
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }

    /**
     * Clicks the radio button with the specified attribute value from a list of radio buttons.
     *
     * @param radioButtons the list of {@link WebElement} representing the radio buttons
     * @param attributeValue the value of the radio button to be clicked
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {
        WaitUtils.waitForVisibilityOfAllElements(radioButtons);
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getAttribute("value").equals(attributeValue)) {
                radioButton.click();
                break;
            }
        }
    }

    /**
     * Checks if the specified radio button is selected.
     *
     * @param radioButton the {@link WebElement} representing the radio button
     * @return {@code true} if the radio button is selected, {@code false} otherwise
     */
    public static boolean isRadioButtonSelected(WebElement radioButton) {
        WaitUtils.waitForVisibilityOf(radioButton);
        return radioButton.isSelected();
    }
}