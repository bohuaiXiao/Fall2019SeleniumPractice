package com.automation.tests.officeHour;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class Office_03_17_2020 {
    private WebDriver driver;
    private String URL = "http://qa3.vytrack.com";
    private String username = "storemanager85";   //   valid username
    private String password = "UserUser123";      //   valid password
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);
        BrowserUtils.iWait(3);


    }
    @AfterMethod
    public void tearDown() {
        BrowserUtils.iWait(3);
        driver.close();
    }

    // click on contacts


    @Test
    public void test(){
    driver.findElement(By.cssSelector("#widget-content-dashboard-widget-1943676555-14 > ul > li:nth-child(2) > a")).click();
    }




}
