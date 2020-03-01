package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {

//        // seup chromedriver
//        WebDriverManager.chromedriver ().setup ();
//        // create chromedriver objeck
//        ChromeDriver driver = new ChromeDriver ();
//        // open some website
//        driver.get ("https://www.google.com");

        // setup Chromedriver
        WebDriverManager.chromedriver ().setup ();
        // create a chromDriver object
        ChromeDriver chromeDriver = new ChromeDriver ();
        // use get method to open a website
        chromeDriver.get ("https://www.youtube.com/watch?v=PLLbGltmkpE&list=PLUDwpEzHYYLs6G9WOfFxiH5zMfgNxgmSV");



    }
}
