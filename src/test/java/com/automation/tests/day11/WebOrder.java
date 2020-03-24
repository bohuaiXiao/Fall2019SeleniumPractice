package com.automation.tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author:
 * @create:
 * @date:
 */
public class WebOrder {

    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete12%2fweborders%2fDefault.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);


    }
    public void teardown(){
        driver.quit();
    }

    /*
    Go to web order page
    Click on "Check all" button
    Verify that all records are selected
     */
    public void checkBoxTest(){
// locator of order page
        WebElement order = driver.findElement(By.xpath("(//a)[1]"));
        WebElement checkAll = driver.findElement(By.xpath("//p//a[1]"));

        wait.until(ExpectedConditions.elementToBeClickable(order)).click();

    }
    @Test
    public void updateZipCode(String name){
        By deleteNameBy = By.xpath("//td[text()='"+name+"']//following-sibling::td/input");
        driver.findElement(deleteNameBy).click();
        WebElement element = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        element.clear();
        element.sendKeys("10086");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        WebElement element1 = driver.findElement(By.xpath("//tr//td[.='"+name+"']//following-sibling::td[7]"));
        Assert.assertEquals(element1.getText(),"10086");



    }
}
