package tests;

import Pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.baseTest.BaseTest;
import utils.MyDriver;

public class RemoveTest extends BaseTest {
    @Test
    public void testRemoveItemFromCart() {
        // Usar el método heredado getDriver() de BaseTest para obtener el WebDriver
        CartPage cartPage = new CartPage(getDriver());  // Aquí instanciamos la CartPage

        // Verificar si el artículo que queremos comprar está visible en la página
        Assert.assertTrue(cartPage.isItemToBuyDisplayed(), "The items to buy are not displayed on the page.");

        // Puedes agregar las acciones necesarias para remover el ítem del carrito aquí
        cartPage.removeProduct("sauce-labs-bike-light");

        // Verificar que el artículo ya no está presente
        Assert.assertFalse(cartPage.isItemToBuyDisplayed(), "The item should not be displayed after removal.");
    }
}