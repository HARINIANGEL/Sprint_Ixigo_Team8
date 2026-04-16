package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

import GenericUtility.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    BaseClass base;
    WebDriver driver;

    public Hook(BaseClass base) {
        this.base = base;
    }
    

    @Before
    public void setup() {


        driver = new ChromeDriver();
        base.driver = driver;

        driver.manage().window().maximize();
        driver.get("https://www.ixigo.com/");
        handlePopup();
    }
    public void handlePopup() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("wiz-iframe-intent"));
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("closeButton")));
            closeBtn.click();
            driver.switchTo().defaultContent();

            System.out.println("Popup closed successfully");

        } catch (Exception e) {
            System.out.println("Popup not present");
            driver.switchTo().defaultContent();
        }
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}