package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    private By username = By.name("user-name");
    private By password = By.id("password");
    private By loginBtn = By.xpath("//*[@id=\"login-button\"]");
    private By errorMsg = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
}