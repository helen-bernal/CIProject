package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyDriver {
    public WebDriver driver;

    public MyDriver(String browser) {
        if ("chrome".equals(browser)) {
            String driverPath = "";

            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                driverPath = "C:\\Users\\helen.bernal\\CIProject\\SouceDemoAutomationProject\\drivers\\chromedriver.exe";
            } else {
                driverPath = "C:/Users/helen.bernal/CIProject/SouceDemoAutomationProject/drivers/chromedriver";
            }

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