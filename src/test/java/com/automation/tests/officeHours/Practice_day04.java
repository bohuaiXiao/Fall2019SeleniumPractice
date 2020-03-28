package com.automation.tests.officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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
public class Practice_day04 {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/nested_frames");

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test(){
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name=\"frame-top\"]")));
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name=\"frame-left\"]")));



        System.out.println(driver.findElement(By.cssSelector("body")).getText());
    }
}
