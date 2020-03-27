package com.automation.tests.homework;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

/**
 * @author:
 * @create:
 * @date:
 */
public class asd11 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void dayTest(){
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        int i = 0;
        String day= "";
        while (i <= 3) {
            BrowserUtils.iWait(1);
            // Randomly select a checkbox.
            List<WebElement> options  =driver.findElements(By.xpath("//input[@type='checkbox']"));
            Random random = new Random();
            int index = random.nextInt(options.size()-2);
            options.get(index).click();
            //BrowserUtils.iWait(1);
            day = options.get(index).getText();
            System.out.println("day = " + day);
           // options.get(index).click();
            if (day.equals("Friday")){
                ++i;
            }
        }
    }
}
