package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.basePage.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[id='user-name']")
    private WebElement usernameInput;
    @FindBy(css = "[id='password']")
    private WebElement passwordInput;
    @FindBy(css = "[id='login-button']")
    private WebElement loginButton;

    public HomePage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new HomePage(super.getDriver());
    }
    public boolean isUserNameFieldVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(usernameInput)) != null;
    }
}

