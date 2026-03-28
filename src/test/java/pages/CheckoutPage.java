package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private By checkoutBtn = By.id("checkout");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By successMsg = By.className("complete-header");
    private By errorMsg = By.cssSelector("h3[data-test='error']");

    public void clickCheckout() {
        click(checkoutBtn);
        waitForElementVisible(firstName);
    }

    public void enterDetails(String f, String l, String p) {
        sendKeys(firstName, f);
        sendKeys(lastName, l);
        sendKeys(postalCode, p);
    }

    public void clickContinue() {
        click(continueBtn);
    }

    public void clickFinish() {
        click(finishBtn);
    }

    public String getSuccessMessage() {
        return getText(successMsg);
    }

    public String getErrorMessage() {
        return getText(errorMsg);
    }
}