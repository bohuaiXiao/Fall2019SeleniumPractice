package com.automation.tests.homework.homework4;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author:
 * @create:
 * @date:1. go to https://www.w3schools.com/
 * 2. find all the elements in the page with the tag a
 * 3. for each of those elements, if it is displayed on the page, print the text and the href of that
 * element.
 */
public class homework4 {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/");
        BrowserUtils.iWait(3);
    }
    @Test
    public void test(){
        List<WebElement> aList = driver.findElements(By.tagName("a"));
       //System.out.println("aList = " + aList);
        int i=1;
        for (WebElement each: aList
             ) {
            if (each.isDisplayed()){
                String eachText = each.getText();
                String eachHref = each.getAttribute("href");
                System.out.println(i+"eachText = " + eachText);
                System.out.println(i+"eachHref = " + eachHref);
                System.out.println("------------------------");
                i++;
            }

        }

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
