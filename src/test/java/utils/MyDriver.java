package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyDriver {
    public WebDriver driver;

    public MyDriver(String browser) {
        if ("chrome".equals(browser)) {
            String driverPath = "";

            // Check the operating system
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                driverPath = "C:\\Users\\helen.bernal\\SouceDemoAutomationProject\\drivers\\chromedriver.exe"; // Windows path
            } else {
                driverPath = "./drivers/chromedriver"; // Linux or macOS path
            }

            // Set ChromeDriver property
            System.setProperty("webdriver.chrome.driver", driverPath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless"); // Run headless in CI/CD

            driver = new ChromeDriver(options);
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