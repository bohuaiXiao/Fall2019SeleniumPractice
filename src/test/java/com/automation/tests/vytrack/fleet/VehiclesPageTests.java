package com.automation.tests.vytrack.fleet;

import com.automation.tests.vytrack.login.LoginPageTests;
import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.testng.Assert .*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class VehiclesPageTests {

    private WebDriver driver;
    private Object LoginPageTests;

    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private  String username = "storemanager57";
    private  String password = "UserUser123";
    private By subtitleBy = By.className("oro-subtitle");

    private By fleetBy = By.cssSelector("#main-menu > ul > li:nth-child(2) > a > span");
    private By pageBy = By.cssSelector("input[type='number']");
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.iWait(3);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        driver.findElement(By.linkText("Vehicles")).click();
    }
    @AfterMethod
    public void tearDrop(){
        BrowserUtils.iWait(3);
        driver.quit();
    }
    @Test
    public void verifyPageSubTitle(){

//        //driver.findElement(fleetBy).click();
//        //Actions class is used for more advanced browser interactions
//        Actions actions = new Actions(driver);
//        // move to element instead of click
//        Actions actions1 = actions.moveToElement(driver.findElement(fleetBy));
//        actions1.perform();
//        //perform - to execute command
//        //every action should end with perform()
//
//        BrowserUtils.iWait(3);
//        driver.findElement(By.linkText("Vehicles")).click();


        WebElement element = driver.findElement(subtitleBy);
        String subTitle = element.getText();
        System.out.println("subTitle = " + subTitle);
        String expected = "All Cars";
        assertEquals(expected,subTitle);

    }

    @Test
    public void verifyPageNumber(){


        String value = driver.findElement(pageBy).getAttribute("value");
        String  expect = "1";
        assertEquals(value,expect);
    }



}
