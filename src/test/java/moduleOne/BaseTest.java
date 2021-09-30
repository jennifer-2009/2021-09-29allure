package moduleOne;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverFactory;
import utils.SeleniumUtils;

public class BaseTest {

    protected WebDriver driver;
    protected SeleniumUtils utils;

    @BeforeClass
    public void setup() {
        driver = DriverFactory.getDriver("chrome", false);
        utils = new SeleniumUtils(driver);
    }

    @AfterClass
    public void teardown() {

        driver.quit();
    }
}
