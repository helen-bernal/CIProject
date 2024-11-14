package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.basePage.BasePage;

public class Checkout2Page extends BasePage {
    public Checkout2Page(WebDriver driver) {
        super(driver);
    }
    //Creación de elementos
    @FindBy(css="[id='finish']")
    public WebElement finishBtn;

    public Checkout3Page finishSell (String text){
        finishBtn.click();
        return new Checkout3Page(super.getDriver());
    }
}
