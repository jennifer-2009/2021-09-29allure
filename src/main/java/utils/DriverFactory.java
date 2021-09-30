package utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver getDriver(String browser, boolean headlessMode){
        WebDriver driver = null;
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            if(headlessMode){
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        }
        return driver;
    }
}
