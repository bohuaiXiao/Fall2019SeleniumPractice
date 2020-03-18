package com.automation.tests.practice;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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
public class HoverImg {
    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.iWait(3);
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        actions.moveToElement(img1).pause(1000).moveToElement(img2).perform();
        BrowserUtils.iWait(3);
        // hover on the first image
        // verify that" name: user1" is displayed
        // hover over image to make text visible
        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("(//h5)[text()='name: user1']"));
        // verify that webElement  that contains the text is visible
        Assert.assertTrue(imgText1.isDisplayed());


    }
}
