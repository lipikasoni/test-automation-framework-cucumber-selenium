package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import utils.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogoutSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage;
    Logger log = LogManager.getLogger(LoginSteps.class);
    @When("user clicks logout")
    public void logout() {
        homePage = new HomePage(driver);
        homePage.logout();
    }

    @Then("user should be redirected to login page")
    public void verifyLogout() {
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));
    }
}