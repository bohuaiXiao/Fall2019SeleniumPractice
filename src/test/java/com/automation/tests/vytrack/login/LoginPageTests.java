package com.automation.tests.vytrack.login;

import com.automation.utilities.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class LoginPageTests {
    private WebDriver driver;
    //https is a secured version of http protocol
    // http - it's hypertext transfer protocol that every single website is using now days
    // https - data ebcrypted , no chance for hackers to retrieve info
    // http - data as a plain text , very easy to hack it
    private  String username = "storemanager57";
    private  String password = "UserUser123";


    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.cssSelector("#prependedInput");
    private By passwordBy = By.cssSelector("#prependedInput2");
    private By warningMessageBy = By.cssSelector("#login-form > fieldset > div.alert.alert-error > div");

    @Test (description = "verify that warning message displays when user enters invalid username")
    public void invalidUserName(){
        driver.findElement(usernameBy).sendKeys("invalidUsername");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.iWait(3);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());

        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();

    }

    @Test(description = "Loging as store manager and verify that tile is equals to DashBoard")
    public  void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password,Keys.ENTER);
        BrowserUtils.iWait(3);

        String expected = "Dashboard";
        String actual = driver.getTitle();
        assertEquals(expected,actual,"Page title is not correct");
    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void dearDown(){
        BrowserUtils.iWait(3);
        //if webdriver object alive
        if (driver!=null){
            // close browser.close session
            driver.quit();
            //destroy webDriver object for sure
            driver= null;
        }
    }
}
