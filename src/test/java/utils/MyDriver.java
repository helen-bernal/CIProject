package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

            System.setProperty("webdriver.chrome.driver", driverPath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");

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