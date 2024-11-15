package tests;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.baseTest.BaseTest;

public class RemoveTest extends BaseTest {

    @Test
    public void testRemoveItemFromCart() {
        LoginPage loginPage = loadFirstPage();
        loginPage.login("standard_user", "secret_sauce");
        HomePage homePage = new HomePage(getDriver());
        homePage.selectRandomProduct();
        homePage.selectRandomProduct();
        homePage.selectRandomProduct();
        CartPage cartPage = homePage.cart();
        cartPage = cartPage.removeProduct();
        cartPage = cartPage.removeProduct();
        cartPage = cartPage.removeProduct();
        boolean isCartEmpty = cartPage.isCartEmpty();
        Assert.assertTrue(isCartEmpty, "Cart is not empty");
    }
}