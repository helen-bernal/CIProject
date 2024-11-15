package utils.baseTest;
import Pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.MyDriver;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    MyDriver mydriver;

    @BeforeMethod(alwaysRun=true)
    @Parameters({"browser","url"})
    public void beforeMethod(String browser, String url) {
        mydriver = new MyDriver(browser);
        mydriver.getDriver().manage().window().maximize();
        navigateTo(url);
    }

    private void navigateTo(String url) {
        mydriver.getDriver().get(url);
    }

    public LoginPage loadFirstPage() {
        return new LoginPage(mydriver.getDriver());
    }

    @AfterMethod()
    public void afterMethod() {
        mydriver.getDriver().close();
    }

    public WebDriver getDriver() {  // Nuevo método para obtener el driver
        return mydriver.getDriver();
    }
}