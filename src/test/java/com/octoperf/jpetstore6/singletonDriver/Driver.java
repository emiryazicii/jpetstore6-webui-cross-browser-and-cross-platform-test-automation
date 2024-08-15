package com.octoperf.jpetstore6.singletonDriver;

import com.octoperf.jpetstore6.utilities.ConfigurationReader;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

/**
 * The {@code Driver} class manages WebDriver instances using the Singleton pattern with {@code InheritableThreadLocal}.
 * It supports various browser types, including headless configurations. This class provides methods to get and close
 * WebDriver instances, and it ensures that WebDriver instances are properly initialized and managed.
 */
@Slf4j
public class Driver {

    /**
     * Private constructor to prevent instantiation of the class.
     */
    private Driver() {
    }

    /**
     * Thread-local variable to hold WebDriver instances. Uses {@code InheritableThreadLocal} to ensure that WebDriver
     * instances are inherited by child threads.
     */
    private static final InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /**
     * Returns the WebDriver instance for the current thread. Initializes a new WebDriver instance if none exists for
     * the current thread, based on the browser type specified in the configuration.
     *
     * @return The WebDriver instance for the current thread.
     * @throws RuntimeException If there is an error initializing the WebDriver.
     */
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {

            String browserType = ConfigurationReader.getProperty("browser");

            try {

                switch (browserType) {
                    case "headless-chrome":
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--headless=new");
                        driverPool.set(new ChromeDriver(chromeOptions));
                        break;
                    case "headless-firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--headless");
                        driverPool.set(new FirefoxDriver(firefoxOptions));
                        break;
                    case "headless-edge":
                        EdgeOptions edgeOptions = new EdgeOptions();
                        edgeOptions.addArguments("--headless=new");
                        driverPool.set(new EdgeDriver(edgeOptions));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid browser type specified in the configuration: " + browserType);
                }

                log.info("Initialized WebDriver for {} browser", browserType);

                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            } catch (Exception e) {
                log.error("Failed to initialize WebDriver: {}", e.getMessage());
                throw new RuntimeException("Failed to initialize WebDriver", e);
            }
        }

        return driverPool.get();
    }

    /**
     * Closes the WebDriver instance for the current thread and removes it from the thread-local storage.
     * If no WebDriver instance exists for the current thread, this method does nothing.
     */
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
            log.info("Closed WebDriver instance");
        }
    }
}
