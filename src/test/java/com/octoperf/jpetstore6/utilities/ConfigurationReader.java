package com.octoperf.jpetstore6.utilities;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ConfigurationReader is a utility class to read configuration properties from a file.
 * <p>
 * The properties file is loaded during class initialization and can be accessed via the static method
 * {@link #getProperty(String)}.
 * </p>
 */
@Slf4j
@UtilityClass
public class ConfigurationReader {

    private static final Properties properties = new Properties();

    // Static initializer block to load properties from the file when the class is loaded
    static {
        try (InputStream inputStream = new FileInputStream("configuration.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            // Log the error using SLF4J
            log.error("Failed to load configuration properties from '{}'", "configuration.properties", e);
            throw new RuntimeException("Configuration properties could not be loaded.", e);
        }
    }

    /**
     * Get the value of a property by its keyword.
     *
     * @param keyword The keyword of the property whose value is to be retrieved.
     * @return The value of the property corresponding to the given keyword, or null if not found.
     */
    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }
}
