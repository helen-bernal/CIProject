package tests;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.baseTest.BaseTest;

public class RemoveTest extends BaseTest {
    @Test(description = "Verify removing items from the cart")
    @Story("Remove items from the cart")
    @Description("This test verifies that a user can remove all products from the cart and the cart becomes empty.")
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
