package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");
    private By menuBtn = By.id("react-burger-menu-btn");
    private By logoutBtn = By.id("logout_sidebar_link");

    public void addProductToCart() {
        click(addToCartBtn);
    }

    public void openCart() {
        click(cartIcon);
    }

    public void logout() {
        click(menuBtn);
        click(logoutBtn);
    }
}