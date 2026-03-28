package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void waitForElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        waitForElementVisible(locator);
        driver.findElement(locator).click();
    }

    protected void sendKeys(By locator, String text) {
        waitForElementVisible(locator);
        driver.findElement(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        waitForElementVisible(locator);
        return driver.findElement(locator).getText();
    }
}