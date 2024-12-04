package tests;
import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.baseTest.BaseTest;
public class LogoutTest extends BaseTest{
    @Feature("Logout")
    @Test(description = "Verify the logout process is correct")
    @Story("User logs out successfully")
    @Description("This test verifies that a user can log out and is at the LoginPage again.")
    public void testLogout() {
        LoginPage loginPage = loadFirstPage();
        loginPage.login("standard_user", "secret_sauce");
        HomePage homePage = new HomePage(getDriver());
        homePage.openMenu();
        homePage.logout();
        Assert.assertTrue(loginPage.isUserNameFieldVisible(), "We are not at LoginPage");
    }
}
