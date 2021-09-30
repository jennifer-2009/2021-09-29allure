package utils;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

    public WebDriver driver;

    public SeleniumUtils(WebDriver driver) {

        this.driver = driver;
    }

    // fluent wait
    public WebElement waitElement(final String css) {

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(15));
        wait.pollingEvery(Duration.ofMillis(250));
        wait.ignoring(Exception.class);

        WebElement elem = wait.until(new Function<WebDriver, WebElement>() {

            @Override
            public WebElement apply(WebDriver d) {

                return d.findElement(By.cssSelector(css));
            }
        });

        return elem;
    }

    // Explicit wait
    public WebElement explicitWaitElement(final String css) {

        WebDriverWait wait = this.getWait();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
    }

    // Scroll down
    public void scrollDown(int length) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + length + ")");
    }

    // Wait for alert presents
    public Alert waitAlert(String css) {

        this.waitElement(css).click();
        return this.getWait().until(ExpectedConditions.alertIsPresent());

    }

    private WebDriverWait getWait() {

        return new WebDriverWait(driver, 15);
    }

}
