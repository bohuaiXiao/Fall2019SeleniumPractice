package com.automation.tests.homework.homework4;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:
 * @create:
 * @date:
 */
public class homework7 {
    private WebDriver driver;
    WebDriverWait wait ;
    private By searchBy = By.id("twotabsearchtextbox");
    private By submitBy = By .xpath("//*[@id='nav-search']/form/div[2]/div/input");
    private By primeBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]");
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.get("https://amazon.com");


    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void test3(){
        wait.until(ExpectedConditions.elementToBeClickable(submitBy));
        driver.findElement(searchBy).sendKeys("wooden spoon");
        driver.findElement(submitBy).click();
        //wait.until(ExpectedConditions.visibilityOfAllElements());
        WebElement Brand = driver.findElement(By.id("brandsRefinements"));
        List<WebElement> BrandList = Brand.findElements(By.tagName("li"));
        List<String > nameList = new ArrayList<>();
        for (WebElement each : BrandList
                ) {
            nameList.add(each.getText());
        }
        System.out.println("nameList = " + nameList);
        BrowserUtils.iWait(2);
        driver.findElement(primeBy).click();
        BrowserUtils.iWait(1);
       // boolean isFlag = false;
        WebElement element = driver.findElement(By.id("brandsRefinements"));
        List<WebElement> li = element.findElements(By.tagName("li"));
        List<String > nameNewList = new ArrayList<>();
        for (WebElement each : li
        ) {
            nameNewList.add(each.getText());
        }



        Assert.assertEquals(nameList,nameNewList);
    }
}
