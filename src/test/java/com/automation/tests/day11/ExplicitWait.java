package com.automation.tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class ExplicitWait
{   private WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void waitForTitle(){
        driver.get("https://www.google.com");
        WebDriverWait wait = new WebDriverWait(driver,10);
       // wait up to 10 seconds until title contains Google
        wait.until(ExpectedConditions.titleContains("Google"));
        driver.navigate().to("https://amazon.com");
        wait.until(ExpectedConditions.titleContains("Amazon"));

    }
    @Test
    public void waitVisibility(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.findElement(By.tagName("button")).click();

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("tomsmith");
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();
        System.out.println("actual = " + actual);
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void waitVisibility2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        driver.findElement(By.xpath("(//a)[6]")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement element = driver.findElement(By.cssSelector("button[text()='Submit']"));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));

        wait.until(ExpectedConditions.elementToBeClickable(element));

        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys("usdn");
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("asdadfsv");
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();


    }
    //ElementClickInterceptionException-means that somthing else was clicked instead of your element
    //it's a custom explicit wait. Wit Flunent wait we can define the maxinum amount of wait time foe condition and element as well as frequency
    //with which to check for the condition (polling time).
    // Foe explicit wait, polling time is always 500 milliseconds. In fluent wait, we can change it

















}
