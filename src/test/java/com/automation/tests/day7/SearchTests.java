package com.automation.tests.day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
public class SearchTests {
    private WebDriver driver;
@Test
    public void googleSearchTest(){
        boolean isFlag = false;
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Java", Keys.ENTER);
        // since every search item has a tag name <h3>
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for (WebElement each :
                searchItems) {
            String var = each.getText();
            // if there is a text - print it
            if (!var.isEmpty()){
                System.out.println(var);
                // verify that every search result contains java
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }

        }


    }






    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void teardown(){
        //close browser and destroy
        driver.quit();
    }



}
