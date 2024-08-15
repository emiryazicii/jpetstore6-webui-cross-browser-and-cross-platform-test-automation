package com.octoperf.jpetstore6.utilities;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

/**
 * UrlUtils provides utility methods for normalizing URLs by removing session identifiers
 * and handling lists of URLs.
 */
@UtilityClass
public class UrlUtils {

    /**
     * Normalizes a URL by removing the session identifier part from it.
     *
     * @param url The URL to be normalized.
     * @return The normalized URL, or null if the input URL is null.
     */
    public static String normalizeURL(String url) {
        return url.replaceAll(";jsessionid=[^?]*", "");
    }

    /**
     * Normalizes a list of URLs by removing the session identifier part from each URL.
     *
     * @param urls The list of URLs to be normalized.
     * @return A list of normalized URLs. Returns an empty list if the input list is null or empty.
     */
    public static List<String> normalizeURLs(List<String> urls) {
        return urls.stream()
                .map(UrlUtils::normalizeURL)
                .collect(Collectors.toList());
    }
}
