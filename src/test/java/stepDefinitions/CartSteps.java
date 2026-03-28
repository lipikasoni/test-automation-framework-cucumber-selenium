package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverFactory;

public class CartSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage;
    HomePage homePage;

    @Given("user is logged in")
    public void userIsLoggedIn() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @When("user adds a product to cart")
    public void addToCart() {
        homePage = new HomePage(driver);
        homePage.addProductToCart();
    }

    @Then("product should be visible in cart")
    public void verifyCart() {
        homePage.openCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
    }
}