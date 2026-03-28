package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.HomePage;
import utils.DriverFactory;

public class CheckoutSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage;
    CheckoutPage checkoutPage;

    @When("user adds product to cart")
    public void addProduct() {
        homePage = new HomePage(driver);
        homePage.addProductToCart();
        homePage.openCart();
    }

    @And("user proceeds to checkout")
    public void proceedCheckout() {
        checkoutPage = new CheckoutPage(driver);

        System.out.println("Current URL before checkout: " + driver.getCurrentUrl());

        checkoutPage.clickCheckout();

        System.out.println("Current URL after checkout: " + driver.getCurrentUrl());
    }

    @And("user enters checkout details")
    public void enterDetails() {
        checkoutPage.enterDetails("Lipika", "Soni", "500001");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();
    }

    @And("user enters incomplete details")
    public void enterIncompleteDetails() {
        checkoutPage.enterDetails("", "Soni", "");
        checkoutPage.clickContinue();
    }

    @Then("order should be placed successfully")
    public void verifyOrder() {
        Assert.assertTrue(checkoutPage.getSuccessMessage().contains("Thank you"));
    }

    @Then("error message should be shown")
    public void verifyError() {
        Assert.assertTrue(checkoutPage.getErrorMessage().length() > 0);
    }
}