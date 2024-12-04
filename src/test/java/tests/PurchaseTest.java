package tests;
import Pages.CartPage;
import Pages.Checkout1Page;
import Pages.Checkout2Page;
import Pages.Checkout3Page;
import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.baseTest.BaseTest;

public class PurchaseTest  extends BaseTest{
    @Epic("Ecommerce WebPAge Automation")
    @Feature("Purchase Flow")
    @Test(description = "Verify the purchase flow")
    @Story("Complete a purchase")
    @Description("This test verifies the entire purchase flow from login to order confirmation.")
    public void testPurchase() {
            LoginPage loginPage = loadFirstPage();
            loginPage.login("standard_user", "secret_sauce");
            HomePage homePage = new HomePage(getDriver());
            homePage.selectRandomProduct();
            CartPage cartPage = homePage.cart();
            Checkout1Page checkout1Page = cartPage.checkout();
            Checkout2Page checkout2Page = checkout1Page.continueCheck2("Helen", "Bernal", "0930");
            Checkout3Page checkout3Page = checkout2Page.finishPurchase();
            Assert.assertTrue(checkout3Page.isOrderDoneTxtDisplayed(), "Purchase not successfull");
        }
    }

