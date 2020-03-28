package com.automation.tests.homework.homework3;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
public class homeWork_3_06 {
    private WebDriver driver;
    private By emailBy = By.id("email");
    private By fullNameBy = By.cssSelector("#login > div:nth-child(1) > div > input[type=text]");
    private By signEmailBy = By.cssSelector("#login > div:nth-child(2) > div > input[type=email]");
    private By submitBy = By.cssSelector("#login > button");


    @Test
    public void test_06(){
        driver.get("https://www.tempmailaddress.com/");
        BrowserUtils.iWait(1);

        String email = driver.findElement(emailBy).getText();
        System.out.println("email = " + email);
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.iWait(2);
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(fullNameBy).sendKeys("bohuaiXiao");
        driver.findElement(signEmailBy).sendKeys(email);
        driver.findElement(submitBy).click();


        WebElement successElement = driver.findElement(By.cssSelector("#content > div > h3"));
        Assert.assertTrue(successElement.isDisplayed(),"Test not Passed");
       // System.out.println("======ONE=====");
//Navigate back to the “https:// www.tempmailaddress.com/”
        for (int i = 0; i < 3; i++) {
            driver.navigate().back();
            BrowserUtils.iWait(2);
        }
        //Verify that you’ve received an email from
        //“do-not-reply@practice.cybertekschool.com”
        //get the element for the email body
        WebElement schrankaElement = driver.findElement(By.id("schranka"));
        // list for target<tr>;
        List<WebElement> trList = schrankaElement.findElements(By.tagName("tr"));
        String emailVerify = "do-not-reply@practice.cybertekschool.com";

        trList.get(0).click();
        String fromFile = driver.findElement(By.id("odesilatel")).getText();
        String subjectFile = driver.findElement(By.id("predmet")).getText();
//        System.out.println("subjectFile = " + subjectFile);
//        System.out.println("fromFile = " + fromFile);

        String subjectVerify = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(emailVerify,fromFile);
        Assert.assertEquals(subjectVerify,subjectFile);


    }







    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.tempmailaddress.com/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.iWait(3);
        driver.close();
    }
}
