package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriver {
    private WebDriver driver;
    public MyDriver(String browser){
        if ("chrome".equals(browser)){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\helen.bernal\\SouceDemoAutomationProject\\drivers");
            driver=new ChromeDriver();
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
