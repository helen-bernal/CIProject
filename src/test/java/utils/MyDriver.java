package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.time.Duration;  // Importa Duration

public class MyDriver {
    public WebDriver driver;

    public MyDriver(String browser) {
        if ("chrome".equals(browser)) {
            String driverPath = "";

            String projectDir = System.getProperty("user.dir");

            System.out.println("Directorio del proyecto: " + projectDir);

            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                driverPath = projectDir + "/drivers/chromedriver.exe";
            }
            else if (System.getProperty("os.name").toLowerCase().contains("nix") ||
                    System.getProperty("os.name").toLowerCase().contains("nux") ||
                    System.getProperty("os.name").toLowerCase().contains("mac")) {
                driverPath = projectDir + "/drivers/chromedriver";
            }

            System.out.println("Ruta del chromedriver: " + driverPath);

            // Usar WebDriverManager o establecer el path si se está usando el driver manualmente
            System.setProperty("webdriver.chrome.driver", driverPath);

            // Configuración de ChromeOptions
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");  // Ejecutar en modo sin cabeza

            // Configuración del servicio de ChromeDriver
            ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(driverPath)) // Ruta del chromedriver
                    .usingAnyFreePort()  // Utiliza cualquier puerto libre
                    .withTimeout(Duration.ofSeconds(30))  // Timeout de 30 segundos usando Duration
                    .build();

            // Instanciación del WebDriver usando el servicio
            driver = new ChromeDriver(service, options);
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