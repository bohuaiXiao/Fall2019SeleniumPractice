package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class JSExecutor {
    private RemoteWebDriver driver;

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
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");

       // 强转 you need to cast if reference type is a WebDriver
        //JavascriptException js = (JavascriptException) driver;
        //scroll down 250 pixels
        // x,y coordinates
        for (;;) {
            driver.manage().window().maximize();
            driver.executeScript("window.scrollBy(0,2500)");
            BrowserUtils.iWait(2);
        }
    }
    @Test
    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

        BrowserUtils.iWait(4);
        WebElement cybertek_school = driver.findElement(By.linkText("Cybertek School"));
        BrowserUtils.iWait(3);
        driver.executeScript("arguments[0].scrollIntoView(true)",cybertek_school);

    }

}
