package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyDriver {
    public WebDriver driver;

    public MyDriver(String browser) {
        if ("chrome".equals(browser)) {
            // Establecer el path del ChromeDriver
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\helen.bernal\\SouceDemoAutomationProject\\drivers\\chromedriver.exe");

            // Configurar ChromeOptions para deshabilitar pop-ups
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-popup-blocking");  // Deshabilita los pop-ups

            // Iniciar el ChromeDriver con las opciones configuradas
            driver = new ChromeDriver(options);
        }
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit(); // Cierra todas las ventanas abiertas y finaliza la sesión
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}