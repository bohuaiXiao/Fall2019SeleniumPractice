package com.automation.tests.vytrack.activies;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class CallPageTests {
    private WebDriver driver;
    private String URL = "http://qa3.vytrack.com";
    private String username = "storemanager85";   //   valid username
    private String password = "UserUser123";      //   valid password
    private By activitesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By logCallBy = By.cssSelector("a[title='Log call']");
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);
        BrowserUtils.iWait(3);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activitesBy)).perform();
        BrowserUtils.iWait(3);
        driver.findElement(By.linkText("Calls")).click();
        BrowserUtils.iWait(3);
    }
    @AfterMethod
    public void tearDown() {
        BrowserUtils.iWait(3);
        driver.close();
    }
    @Test
    public void loginButton(){

        WebElement element = driver.findElement(logCallBy);
        Assert.assertTrue(element.isDisplayed());
    }
    @Test
    public void test_01(){

    }
}
