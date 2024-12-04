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

            System.setProperty("webdriver.chrome.driver", driverPath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");

            ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(driverPath))
                    .usingAnyFreePort()
                    .withTimeout(Duration.ofSeconds(30))
                    .build();

            driver = new ChromeDriver(service, options);
        }
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}