package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.basePage.BasePage;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css= "[id='remove-sauce-labs-bike-light']")
    public WebElement removeBtn;
    @FindBy(css= "[id='checkout']")
    public WebElement checkoutBtn;
    @FindBy(css=".cart_item")
    public static WebElement itemstoBuy;

    public CartPage removeProduct () {
        removeBtn.click();
        return new CartPage(super.getDriver());
    }
    public Checkout1Page checkout() {
        checkoutBtn.click();
        return new Checkout1Page(driver);
    }
    public boolean isItemToBuyDisplayed() {
        try {
            return itemstoBuy.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
        public boolean isRemoveBtnDisplayed() {
            try{
                return removeBtn.isDisplayed();
            }catch (NoSuchElementException e){
                return false;
            }
    }
    public boolean isCartEmpty() {
        try {
            return !isItemToBuyDisplayed();
        } catch (Exception e) {
            return true;
        }
    }
}
