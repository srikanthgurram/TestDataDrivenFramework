package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import util.ConfigFileReader;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    ConfigFileReader config;
    public static WebDriver driver;

    @BeforeTest
    public void setup(){
        config = new ConfigFileReader();
        String baseUrl = config.getPropertyValue("baseurl");

        if(config.getPropertyValue("browser").equalsIgnoreCase("chrome")){
            //initialie chrome driver
            String driverPath = System.getProperty("user.dir")+"/"+config.getPropertyValue("chromedriverpath");
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(baseUrl);
        }else if(config.getPropertyValue("browser").equalsIgnoreCase("firefox")){
            //initialie firefox gecko driver
            String driverPath = System.getProperty("user.dir")+"/"+config.getPropertyValue("firefoxdriverpath");
            System.setProperty("", "");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(baseUrl);

        }
    }

    @AfterTest
    public void cleanup(){
        driver.quit();
    }
}
