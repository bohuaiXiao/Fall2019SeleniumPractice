package com.automation.tests.homework.homework4;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author:
 * @create:
 * @date:
 */
public class homework3 {
    /**
     * 1. go to https://www.amazon.com
     * 2. verify that default value of the All departments dropdown is All
     * 3. verify that options in the All departments dropdown are not sorted alphabetically
     */
    private WebDriver driver;
    private By option = By.xpath("//select//option[@value=\"search-alias=aps\"]");
    List<String> allOptionStr = new ArrayList<>();
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public  void test(){
        String optionText = driver.findElement(option).getText();
        Assert.assertTrue(optionText.contains("All"));

    }
    @Test
    public void test2 (){
        Select select = new Select(driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]")));
        List<WebElement> options = select.getOptions();

        List<String> allOptionStr = new ArrayList<>();
        for (WebElement each :
                options) {
            allOptionStr.add(each.getText().trim());
        }
        System.out.println("allOptionStr = " + allOptionStr);

        List<String > newStr = new ArrayList<>(allOptionStr);
        Collections.sort(newStr);
        System.out.println("newStr = " + newStr);
        Assert.assertFalse(allOptionStr.equals(newStr));



    }
    @Test
    public void test3(){
        driver.get("https://www.amazon.com/gp/site-directory");
        List<WebElement> elements = driver.findElements(By.xpath("//h2[@class=\"fsdDeptTitle\"]"));
        List<String> elementText = BrowserUtils.getElementText(elements);
        Assert.assertFalse(allOptionStr.containsAll(elementText));
    }
}
