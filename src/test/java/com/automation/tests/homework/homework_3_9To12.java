package com.automation.tests.homework;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 *
 *
 */
public class homework_3_9To12 {
    private WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com";
    private By statusBy = By.linkText("Status Codes");
    private By firstBy = By.linkText("200");
    private By twoBy = By.linkText("301");
    private By threeBy = By.linkText("404");
    private By fourBy = By.linkText("500");
    private String expected1 = "This page returned a 200 status code";
    private String expected2 = "This page returned a 301 status code";
    private String expected3 = "This page returned a 404 status code";
    private String expected4 = "This page returned a 500 status code";


    @Test (description = "check data",dataProvider = "statusData")
    public void test(By click, String result){
    driver.findElement(click).click();
    String actual = driver.findElement(By.tagName("p")).getText();
     //   System.out.println("actual = " + actual);
        Assert.assertTrue(actual.contains(result.trim()));
    }
    @DataProvider (name="statusData")
    public Object[][] statusData(){

        return new Object[][]{{firstBy,expected1},
                              {twoBy,expected2},
                              {threeBy,expected3},
                              {fourBy,expected4}};
    }






    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.iWait(3);
        driver.findElement(statusBy).click();
        BrowserUtils.iWait(3);
}
    @AfterMethod
    private void tearDown(){
        driver.quit();
    }

}
