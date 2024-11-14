package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.basePage.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css=".shopping_cart_link")
    private WebElement shoppingCart;
    @FindBy(css="[id='react-burger-menu-btn']")
    private WebElement burgerMenuButton;
    @FindBy(css="[id='logout_sidebar_link']")
    private WebElement logoutSidebar;
    @FindBy(css="[id='dd-to-cart-sauce-labs-backpack']")
    private WebElement addButton;
    @FindBy(css="[id='remove-sauce-labs-backpack']")
    private WebElement removeButton;

    public CartPage cart () {
        shoppingCart.click();
        return new CartPage(super.getDriver());
    }
    public HomePage loginText() {
        burgerMenuButton.click();
        addButton.click();
        removeButton.click();
        return new HomePage(super.getDriver());
    }
    public LoginPage logout() {
        logoutSidebar.click();
        return new LoginPage(driver);
    }
}
