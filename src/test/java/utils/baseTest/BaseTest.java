package utils.baseTest;
import Pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utils.MyDriver;

public class BaseTest {
    MyDriver driver;
    @BeforeMethod(alwaysRun=true)
    @Parameters({"browser","url"})
    public void beforeMethod(String browser,String url){
        driver=new MyDriver(browser);
        driver.getDriver().manage().window().maximize();
        navigateTo(url);
    }

    /**
     * Navigates to given URL
     *
     * @param url
     * @author helen bernal
     */

    private void navigateTo(String url) {
        driver.getDriver().get(url);
    }
    /**
     * It instantiates the first page loaded.
     *
     * @author helen bernal
     * @return HomePage
     */
    public LoginPage loadFirstPage(){
        return new LoginPage(driver.getDriver());
    }
    /**
     * After the test execution it closes the browser.
     *
     * @author helen bernal
     */
    @AfterMethod()
    public void afterMethod(){
        driver.getDriver().close();
    }
}
