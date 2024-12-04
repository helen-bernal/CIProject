package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.basePage.BasePage;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage {
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(css = "[id^='remove-']")
    private List<WebElement> removeButtons;

    @FindBy(css = "[id='checkout']")
    public WebElement checkoutBtn;

    public CartPage removeProduct() {
        if (!removeButtons.isEmpty()) {
            wait.until(ExpectedConditions.elementToBeClickable(removeButtons.get(0)));
            removeButtons.get(0).click();
        }

        return new CartPage(super.getDriver());
    }

    public Checkout1Page checkout() {
        checkoutBtn.click();
        return new Checkout1Page(driver);
    }

    public boolean isCartEmpty() {
        try {
            return removeButtons.isEmpty();
        } catch (Exception e) {
            return true;
        }
    }
}