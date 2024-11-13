package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.basePage.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Creacion de elementos
    @FindBy(css = "[id='user-name']")
    private WebElement usernameInput;
    @FindBy(css = "[id='password']")
    private WebElement passwordInput;
    @FindBy(css = "[id='login-button']")
    private WebElement loginButton;

    public HomePage loginText(String text) {
        usernameInput.sendKeys(text);
        passwordInput.sendKeys(text);
        loginButton.click();
        return new HomePage(super.getDriver());
    }
}

