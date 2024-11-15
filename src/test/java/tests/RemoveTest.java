package tests;

import Pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.baseTest.BaseTest;

public class RemoveTest extends BaseTest {

    @Test
    public void testRemoveItemFromCart() {
        // Utiliza el driver gestionado por BaseTest
        CartPage cartPage = new CartPage(getDriver());
        // Realiza las validaciones
        Assert.assertTrue(cartPage.isItemToBuyDisplayed(), "The items to buy are not displayed on the page.");
        // Elimina el producto del carrito
        cartPage.removeProduct("sauce-labs-bike-light");
        // Valida que el producto ya no está
        Assert.assertFalse(cartPage.isItemToBuyDisplayed(), "The item should not be displayed after removal.");
    }
}