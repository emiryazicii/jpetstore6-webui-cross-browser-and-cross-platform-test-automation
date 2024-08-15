package com.octoperf.jpetstore6.utilities;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * SelectUtils provides utility methods for interacting with HTML <select> elements.
 * These methods facilitate selecting and deselecting options, checking the multi-select status,
 * and retrieving selected options and available options.
 */
@UtilityClass
public class SelectUtils {

    /**
     * Creates a {@link Select} object for a given {@link WebElement}.
     *
     * @param element The {@link WebElement} representing the <select> element.
     * @return A {@link Select} object for the provided element.
     */
    private static Select select(WebElement element) {
        WaitUtils.waitForVisibilityOf(element);
        return new Select(element);
    }

    /**
     * Selects an option by its visible text.
     *
     * @param element     The {@link WebElement} representing the <select> element.
     * @param visibleText The visible text of the option to be selected.
     */
    public static void selectByVisibleText(WebElement element, String visibleText) {
        select(element).selectByVisibleText(visibleText);
    }

    /**
     * Selects an option by its value attribute.
     *
     * @param element The {@link WebElement} representing the <select> element.
     * @param value   The value of the option to be selected.
     */
    public static void selectByValue(WebElement element, String value) {
        select(element).selectByValue(value);
    }

    /**
     * Selects an option by its index.
     *
     * @param element The {@link WebElement} representing the <select> element.
     * @param index   The index of the option to be selected.
     */
    public static void selectByIndex(WebElement element, int index) {
        select(element).selectByIndex(index);
    }

    /**
     * Deselects all selected options in a multi-select <select> element.
     *
     * @param element The {@link WebElement} representing the multi-select <select> element.
     */
    public static void deselectAll(WebElement element) {
        select(element).deselectAll();
    }

    /**
     * Deselects an option by its visible text in a multi-select <select> element.
     *
     * @param element     The {@link WebElement} representing the multi-select <select> element.
     * @param visibleText The visible text of the option to be deselected.
     */
    public static void deselectByVisibleText(WebElement element, String visibleText) {
        select(element).deselectByVisibleText(visibleText);
    }

    /**
     * Deselects an option by its value attribute in a multi-select <select> element.
     *
     * @param element The {@link WebElement} representing the multi-select <select> element.
     * @param value   The value of the option to be deselected.
     */
    public static void deselectByValue(WebElement element, String value) {
        select(element).deselectByValue(value);
    }

    /**
     * Deselects an option by its index in a multi-select <select> element.
     *
     * @param element The {@link WebElement} representing the multi-select <select> element.
     * @param index   The index of the option to be deselected.
     */
    public static void deselectByIndex(WebElement element, int index) {
        select(element).deselectByIndex(index);
    }

    /**
     * Checks if the <select> element allows multiple selections.
     *
     * @param element The {@link WebElement} representing the <select> element.
     * @return True if the <select> element allows multiple selections, otherwise false.
     */
    public static boolean isMultiple(WebElement element) {
        return select(element).isMultiple();
    }

    /**
     * Retrieves all selected options from a multi-select <select> element.
     *
     * @param element The {@link WebElement} representing the multi-select <select> element.
     * @return A list of {@link WebElement} representing the selected options.
     */
    public static List<WebElement> getAllSelectedOptions(WebElement element) {
        return select(element).getAllSelectedOptions();
    }

    /**
     * Retrieves the first selected option from a multi-select <select> element.
     *
     * @param element The {@link WebElement} representing the multi-select <select> element.
     * @return The {@link WebElement} representing the first selected option.
     */
    public static WebElement getFirstSelectedOption(WebElement element) {
        return select(element).getFirstSelectedOption();
    }

    /**
     * Retrieves the text of all options in a <select> element.
     *
     * @param dropdownElement The {@link WebElement} representing the <select> element.
     * @return A list of strings representing the text of all options.
     */
    public static List<String> getTextOfAllOptions(WebElement dropdownElement) {
        List<WebElement> actualOptions = select(dropdownElement).getOptions();
        List<String> optionsTexts = new ArrayList<>();

        for (WebElement option : actualOptions) {
            optionsTexts.add(option.getText());
        }
        return optionsTexts;
    }
}