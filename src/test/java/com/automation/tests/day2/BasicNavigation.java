package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {

        //to start selenium
        WebDriverManager.chromedriver ().setup ();

        ChromeDriver driver = new ChromeDriver ();
        // in selenium everything start from webdriver interface

        driver.get ("https://www.google.com");
        





    }
}
