package com.automation.tests.homework.homework4;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author:
 * @create:
 * @date:
 * 1. go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
 * 2. Randomly select a checkbox. As soon as you check any day, print the name of the day
 * and uncheck immediately.
 * After you check and uncheck Friday for the third time, exit the program.
 */
public class homework1 {
    private WebDriver driver ;
    private WebDriverWait wait;
    private By checkbox1 = By.xpath("//input[@type='checkbox'][1]");


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        BrowserUtils.iWait(3);

    }

    @Test
    public void test(){
        int i =0;
        int x=1;
       // while (i<=3){
            //wait.until(ExpectedConditions.elementToBeClickable(checkbox1));
       while (i<3)
            {
            Random random = new Random();
            int a = random.nextInt(5);
            String day = "";
            WebElement element = driver.findElement(By.xpath("(//table)[5]//tbody//tr["+(a+2)+"]//input"));
            element.click();
            WebElement element1 = driver.findElement(By.xpath("(//table)[5]//tbody//tr["+(a+2)+"]"));
            String eachDay = element1.getText();
            System.out.println(x+eachDay);
            x++;
            if (eachDay.equals("Friday")){
                i++;
            }
        }

    }












    @AfterMethod
    public void teardown(){
        BrowserUtils.iWait(3);
        driver.quit();

    }

}
