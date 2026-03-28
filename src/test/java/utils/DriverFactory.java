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

        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);

        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=AutofillServerCommunication,AutofillEnableAccountWalletIntegration");
        options.addArguments("--incognito");
        options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "/selenium-profile-" + System.currentTimeMillis());
        options.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(options);

        getDriver().manage().window().maximize();
    }

    public static void quitDriver() {
        getDriver().quit();
        driver.remove();
    }
}