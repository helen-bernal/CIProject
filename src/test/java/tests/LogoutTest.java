package tests;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.baseTest.BaseTest;
public class LogoutTest extends BaseTest{
    @Test
    public void testLogout() {
        LoginPage loginPage = loadFirstPage();
        loginPage.login("standard_user", "secret_sauce");
        HomePage homePage = new HomePage(getDriver());
        homePage.openMenu();
        homePage.logout();
        Assert.assertTrue(loginPage.isUserNameFieldVisible(), "We are not at LoginPage");
    }
}