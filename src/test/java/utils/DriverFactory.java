package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        // optional for CI
        options.addArguments("--headless=new");

        WebDriver webDriver = new ChromeDriver(options);
        driver.set(webDriver);

        webDriver.manage().window().maximize();
    }
    public static void quitDriver() {
        getDriver().quit();
        driver.remove();
    }
}