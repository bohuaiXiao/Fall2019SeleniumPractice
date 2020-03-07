package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver ().setup ();
        WebDriver driver = new ChromeDriver ();
        driver.get ("http://practice.cybertekschool.com/radio_buttons");
        driver.findElement (By.cssSelector ("#red")).click ();
        Thread.sleep (3000);

        driver.findElement (By.linkText ("Cybertek School"));
        Thread.sleep (3000);
        driver.quit ();
    }
}
