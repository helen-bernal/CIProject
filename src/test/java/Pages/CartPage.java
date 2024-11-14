package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.basePage.BasePage;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css= "[id='remove-sauce-labs-bike-light']")
    public WebElement removeBtn;
    @FindBy(css= "[id='checkout']")
    public WebElement checkoutBtn;


}
