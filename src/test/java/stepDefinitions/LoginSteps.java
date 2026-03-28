package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage;

    @Given("user is on login page")
    public void openLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters username {string} and password {string}")
    public void enterCredentials(String username, String password) {
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
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
    @Then("error message should be displayed")
    public void validateErrorMessage() {
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Epic sadface"));
    }
}