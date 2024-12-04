package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyDriver {
    public WebDriver driver;

    public MyDriver(String browser) {
        if ("chrome".equals(browser)) {
            // No es necesario especificar la ruta del chromedriver aquí,
            // GitHub Actions ya se encarga de ello

            System.out.println("Configurando el driver de Chrome...");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");  // Si deseas que el navegador se ejecute en modo headless

            // Se crea el driver sin necesidad de especificar la ruta del chromedriver
            driver = new ChromeDriver(options);
        }
    }

    // Método para cerrar el driver
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Método para obtener la instancia del driver
    public WebDriver getDriver() {
        return this.driver;
    }
}