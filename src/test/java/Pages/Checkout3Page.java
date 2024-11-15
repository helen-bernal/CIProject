package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.basePage.BasePage;

public class Checkout3Page extends BasePage {
    public Checkout3Page(WebDriver driver) {
        super(driver);
    }
    @FindBy(css=".complete-header")
    public WebElement orderDoneTxt;
    @FindBy(css="[id='back-to-products']")
    public WebElement backBtn;

    public HomePage backtoHome(){
        backBtn.click();
        return new HomePage(super.getDriver());
    }
    public boolean isOrderDoneTxtDisplayed() {
        try{
            return orderDoneTxt.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
