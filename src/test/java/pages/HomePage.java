package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    private By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}