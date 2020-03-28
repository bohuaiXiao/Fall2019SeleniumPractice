package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class clickTest {
    private WebDriver driver;

    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.iWait(3);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement link = driver.findElement(By.xpath("//*[@id='golden_button']"));
        js.executeScript("arguments[0].click()",link);
        BrowserUtils.iWait(3);
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),"Clicked on button five!");
    }
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.iWait(3);
        driver.quit();
    }

    @Test
    public void textInputTest(){
     driver.get("http://practice.cybertekschool.com/login");
     BrowserUtils.iWait(3);
     WebElement username = driver.findElement(By.name("username"));
     WebElement password = driver.findElement(By.name("password"));
     WebElement loginBtn = driver.findElement(By.id("wooden_spoon"));
     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("arguments[0].setAttribute('value','tomsmith')",username);
     js.executeScript("arguments[0].setAttribute('value','SuperSecretPassword')",password);
     js.executeScript("arguments[0].click",loginBtn);
    }
    @Test
    public void scrollToElement(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtils.iWait(5);

        WebElement cybertek_school = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",cybertek_school);

    }
    @Test
    public void scrollTest(){
        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 15; i++) {
            js.executeScript("window.scrollBy(0,2500)");
            BrowserUtils.iWait(2);
            System.out.println(i+"Times");
        }

    }


}
