package com.automation.tests.homework.homework4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:
 * @create:
 * @date:
 * 1. go to https://www.selenium.dev/documentation/en/
 * 2. find all the elements in the page with the tag a
 * 3. verify that all the links are valid
 */

public class homework5 {
    ConfigurationReader reader = new ConfigurationReader();
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/documentation/en/");
    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.iWait(2);
        driver.quit();
    }
    @Test
    public void test(){
        List<WebElement> aList = driver.findElements(By.tagName("a"));
        int size = aList.size();
        List<WebElement> displayElements = new ArrayList<>();
        for (WebElement each: aList
             ) {
            if(each.isDisplayed()){
                displayElements.add(each);
            }
        }

        for (int i = 0; i < displayElements.size(); i++) {
            displayElements.get(i).click();
            driver.navigate().back();
            displayElements = new ArrayList<>();
        }

            }
        }

