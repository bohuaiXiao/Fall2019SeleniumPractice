package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author:
 * @create:
 * @date:
 */
public class SearchTests {
    private WebDriver driver;
@Test
    public void googleSearchTest(){
        boolean isFlag = false;
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Java", Keys.ENTER);
        // since every search item has a tag name <h3>
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for (WebElement each :
                searchItems) {
            String var = each.getText();
            // if there is a text - print it
            if (!var.isEmpty()){
                System.out.println(var);
                // verify that every search result contains java
                // is some of the search results
                // doesn't contain java word, it will fail the test
                Assert.assertTrue(var.toLowerCase().contains("java"));
                System.out.println(var.toLowerCase());
            }

        }

    }


    /**
     * Given user is on the amazon.com page
     * When user enters "java" as a search item
     * Then user clicks on the search button
     * And user clicks on the first search item
     * And user verifies that title of search item contains "Java"
     */
    @Test (description = "Search for Java Book on amazon")
    public void amazonSearchTest(){
    driver.get("https://www.amazon.com/");
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java",Keys.ENTER);
        BrowserUtils.iWait(5);
        // find all links inside h2 elements , because h2 element is clickable itself
        List<WebElement> h2 = driver.findElements(By.tagName("h2"));
        //click on the first item
        h2.get(0).click();
        BrowserUtils.iWait(5);

        WebElement productTitle = driver.findElement(By.id("productTitle"));
        String productTitleText = productTitle.getText();
        System.out.println("productTitleText = " + productTitleText);

        Assert.assertTrue(productTitleText.contains("Java"));


    }






    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void teardown(){
        //close browser and destroy
        driver.quit();
    }



}
