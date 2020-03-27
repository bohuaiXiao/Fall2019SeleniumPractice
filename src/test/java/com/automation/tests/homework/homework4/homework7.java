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

import java.util.*;

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
        wait.until(ExpectedConditions.elementToBeClickable(submitBy));
        driver.findElement(searchBy).sendKeys("iphone");
        driver.findElement(submitBy).click();
        BrowserUtils.iWait(3);

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void test3(){
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
    @Test
    public void test4(){

//        3. click on Price option Under $25 on the left
        // get the under$25 locator
//        4. verify that all results are cheaper than $25
        ////h2[@class="a-size-mini a-spacing-none a-color-base s-line-clamp-4"]
       ////div[@class="s-result-list s-search-results sg-row"]//span[@class="a-size-base-plus a-color-base a-text-normal"]
        // list all things in a list
        List<WebElement> AllItems = driver.findElements(By.xpath("//div[@class=\"a-section a-spacing-medium\"]"));
        // each produck
        System.out.println(AllItems.size());
        String name = "";
        String price = "";
        int i =1;
        Iterator<WebElement> iterator = AllItems.iterator();
        while (iterator.hasNext()){
            WebElement element = iterator.next();
            WebElement a = element.findElement(By.tagName("a"));
            name = a.getText();
            System.out.println("a = "+i + name);
            i++;
        }



    }
    @Test(description = "iphone")
    public void test5(){
        List<WebElement> phoneList = driver.findElements(By.xpath("//div[@class=\"s-include-content-margin s-border-bottom s-latency-cf-section\"]"));
    //     use each phone to get name and price
        Iterator<WebElement> iterator = phoneList.iterator();
        String name= "";
        String price = "";
        HashMap<String,String > listMap = new HashMap<>();
        while   (iterator.hasNext()){
            WebElement next = iterator.next();
            name = next.findElement(By.tagName("h2")).getText();
            price = next.findElement(By.xpath("//span[@class=\"a-price\"]")).getText();
            listMap.put(name,price);
        }
        System.out.print(price.trim());
//        System.out.println(phoneList.get(0).findElement(By.tagName("h2")).getText());
//        System.out.print(phoneList.get(0).findElement(By.xpath("//div[@class=\"a-row\"]//span[@class=\"a-price\"]")).getText());

        // System.out.println(phoneList.get(1).findElement(By.tagName("h2")).getText());
       // System.out.println(listMap);
    }

}
