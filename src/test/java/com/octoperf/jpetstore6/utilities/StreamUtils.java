package com.octoperf.jpetstore6.utilities;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * StreamUtils provides utility methods for operating on lists of {@link WebElement}
 * using Java Streams. It includes operations for retrieving attributes, verifying display status,
 * and obtaining text from elements.
 */
@UtilityClass
public class StreamUtils {

    /**
     * Retrieves the value of a specified attribute from each {@link WebElement} in the list.
     *
     * @param elements      The list of {@link WebElement} objects.
     * @param attributeName The name of the attribute whose value is to be retrieved.
     * @return A list of attribute values corresponding to the specified attribute name.
     */
    public static List<String> getElementsAttributeValues(List<WebElement> elements, String attributeName) {
        return elements.stream()
                .map(element -> WaitUtils.getAttributeValueAfterWait(element, attributeName))
                .collect(Collectors.toList());
    }

    /**
     * Verifies that all {@link WebElement} objects in the list are displayed.
     *
     * @param elements The list of {@link WebElement} objects.
     * @return True if all elements are displayed, otherwise false.
     */
    public static boolean verifyElementsAreDisplayed(List<WebElement> elements) {
        return elements.stream()
                .allMatch(WaitUtils::isDisplayedAfterWait);
    }

    /**
     * Retrieves the text of each {@link WebElement} in the list.
     *
     * @param elements The list of {@link WebElement} objects.
     * @return A list of text values corresponding to each element.
     */
    public static List<String> getTextOfElements(List<WebElement> elements) {
        return elements.stream()
                .map(WaitUtils::getTextAfterWait)
                .collect(Collectors.toList());
    }
}