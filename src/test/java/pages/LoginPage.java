package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMsg = By.cssSelector("h3[data-test='error']");

    public void enterUsername(String user) {
        sendKeys(username, user);
    }

    public void enterPassword(String pass) {
        sendKeys(password, pass);
    }

    public void clickLogin() {
        click(loginBtn);
    }

    public String getErrorMessage() {
        return getText(errorMsg);
    }
}