package com.automation.tests.day7;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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
        BrowserUtils.iWait(5);
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

    @Test
    public void forgotPasswordTest(){
        driver.findElement(By.linkText("Forgot Password")).click();
        driver.findElement(By.cssSelector("#forgot_password > div > div > input[type=text]")).sendKeys("tom@gmail.com", Keys.ENTER);

        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.tagName("h4")).getText();
        Assert.assertEquals(expected,actual,"message is not matching" );
    }

    @Test
    public void checkBoxTest(){
        driver.findElement(By.linkText("Checkboxes")).click();

        List<WebElement> input = driver.findElements(By.tagName("input"));
        WebElement firstBox = input.get(0);
        firstBox.click();
        BrowserUtils.iWait(3);

        driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)")).click();


        Assert.assertTrue(firstBox.isSelected(),"Not selected");
    }






}
