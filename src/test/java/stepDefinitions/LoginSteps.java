package stepDefinitions;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage;
    Logger log = LogManager.getLogger(LoginSteps.class);
    @Given("user is on login page")
    public void openLoginPage() {
        log.info("Opening login page");
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        log.info("Entering username and password");
        loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("clicks login button")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Then("user should be redirected to home page")
    public void validateLogin() {
        log.info("Validating successful login");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
    @Then("error message should be displayed")
    public void validateErrorMessage() {
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Epic sadface"));
    }
}