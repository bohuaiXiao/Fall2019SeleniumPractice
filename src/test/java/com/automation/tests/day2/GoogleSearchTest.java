package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver ().setup ();
        ChromeDriver driver = new ChromeDriver ();
        driver.get ("https://google.com");

        Thread.sleep (2000);

        //By.name ("q") --->name = "q";
        // name - it's one of the selenium locators
        WebElement search = driver.findElement (By.name ("q"));
        // once we found an element, how to enter text?
        // to enter text, use sendKeys() method
        search.sendKeys ("Java", Keys.ENTER);
        // how to press Enter after entering the text?
        //use Key.Enter


        Thread.sleep (2000);

        //if see<a> element. it calls link
        // visible text of this link, can be used by selenium to find this element
        WebElement news = driver.findElementByLinkText ("News");
        news.click ();// to click on the element
        Thread.sleep (4000);

      //  driver.quit ();






    }
}
