package com.automation.tests.day7;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class PracticeTests {
    private WebDriver driver;


    // setup before and after methods
    @BeforeMethod (description = "create a WebDriver")
    public void setDriver(){

        WebDriverManager.chromedriver().setup();
        //INTERVIEW QUESTION : HOW TO HANDLE SSL ISSUES IN SELENIUM?
        //ChromeOptions - use to customize browser browser for tests
        // to ignore " Your connection is not private issue"
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
    @AfterMethod (description = "Quite the wesite")
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginTest(){

        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.iWait(5);

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        driver.findElement(By.cssSelector("#wooden_spoon")).click();
        BrowserUtils.iWait(5);

        String expected = "Welcome to the Secure Area. When you are done click logout below."   ;
        String acutal = driver.findElement(By.tagName("h4")).getText();

        Assert.assertEquals(expected,acutal);



    }






}
