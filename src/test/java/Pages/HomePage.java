package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.basePage.BasePage;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
    @FindBy(css=".inventory_item")
    private WebElement listofItems;

    public CartPage cart() {
        shoppingCart.click();
        return new CartPage(super.getDriver());
    }

    public HomePage selectRandomProduct() {
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".inventory_item")));
        if (products.size() < 1) {
            throw new IllegalStateException("No products available");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(products.size());
        WebElement randomProduct = products.get(randomIndex);
        WebElement addToCartButton = randomProduct.findElement(By.cssSelector(".btn_inventory"));
        addToCartButton.click();
        return this;
    }

    public HomePage openMenu() {
        burgerMenuButton.click();
        return new HomePage(super.getDriver());
    }

    public LoginPage logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutSidebar));
        logoutSidebar.click();
        return new LoginPage(driver);
    }
}