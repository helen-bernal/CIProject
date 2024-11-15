package tests;

import Pages.*;
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
        Assert.assertTrue(cartPage.isItemToBuyDisplayed(), "Product not added to the cart");
        Assert.assertTrue(cartPage.isRemoveBtnDisplayed(), "Button 'Remove' not here.");
        cartPage = cartPage.removeProduct();
        Assert.assertTrue(cartPage.isRemoveBtnDisplayed(), "Button 'Remove' not here.");
        cartPage = cartPage.removeProduct();
        Assert.assertTrue(cartPage.isRemoveBtnDisplayed(), "Button 'Remove' not here.");
        cartPage = cartPage.removeProduct();
        boolean isProductRemoved = cartPage.isCartEmpty();
        Assert.assertTrue(isProductRemoved, "There are still products");
    }



}