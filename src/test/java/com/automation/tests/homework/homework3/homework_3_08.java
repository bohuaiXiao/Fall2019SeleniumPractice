package com.automation.tests.homework.homework3;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 *Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
 * Step 2. And click on “Autocomplete”.
 * Step 3. Enter “United States of America” into country input box.
 * Step 4. Verify that following message is displayed:
 * “You selected: United States of America”
 * Optional: If you want to to be a real selenium hero,
 * use @DataProvider for for tests cases from 9 through 12.
 * Please use following documentation:
 * https:// testng.org/doc/documentation- main.html#parameters-dataproviders
 */
public class homework_3_08 {
    private WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com";
    private By autocomplete = By.linkText("Autocomplete");
    private By country = By.cssSelector("#myCountry");
    private By submit = By.cssSelector("[value='Submit']");
    private By resultBy = By.cssSelector("#result");


    @Test
    public void test(){
        driver.findElement(country).sendKeys("United States of America");
        driver.findElement(submit).click();
        String expected = "You selected: United States of America";
        String result = driver.findElement(resultBy).getText();
        Assert.assertEquals(expected,result);


    }





    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        BrowserUtils.iWait(1);
        driver.findElement(autocomplete).click();
        BrowserUtils.iWait(1);


    }
    @AfterMethod
    private void tearDown(){
        BrowserUtils.iWait(3);
        driver.close();
    }

}
