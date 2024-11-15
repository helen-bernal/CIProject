package tests;

import Pages.CartPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MyDriver;

public class PurchaseTest {
    @Test
    public void testItemsToBuyIsDisplayed() {
        // Create MyDriver instance with a specific browser type (e.g., "chrome")
        MyDriver myDriver = new MyDriver("chrome");
        CartPage cartPage = new CartPage(myDriver.getDriver());  // Crear la instancia de CartPage
        Assert.assertTrue(cartPage.isItemToBuyDisplayed(), "The items to buy are not displayed on the page.");

        // Assert if the item is displayed
    }
}