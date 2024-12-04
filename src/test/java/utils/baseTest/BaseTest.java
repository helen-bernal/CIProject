package utils.baseTest;

import Pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.MyDriver;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    MyDriver mydriver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void beforeMethod(@Optional("chrome") String browser, @Optional("https://www.saucedemo.com/") String url) {
        // Prioridad: Línea de comandos -> Parámetro de TestNG -> Predeterminado
        String browserType = System.getProperty("browserName", browser);

        if (mydriver == null || mydriver.getDriver() == null) {
            mydriver = new MyDriver(browserType);
            mydriver.getDriver().manage().window().maximize();
        }
        navigateTo(url);
    }

    private void navigateTo(String url) {
        mydriver.getDriver().get(url);
    }

    public LoginPage loadFirstPage() {
        return new LoginPage(mydriver.getDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        if (mydriver != null && mydriver.getDriver() != null) {
            mydriver.getDriver().quit(); // Asegura liberar recursos al final de cada test
        }
    }

    public WebDriver getDriver() {
        return mydriver != null ? mydriver.getDriver() : null;
    }
}
