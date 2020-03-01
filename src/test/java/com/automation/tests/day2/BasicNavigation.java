package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {

        //to start selenium
        WebDriverManager.chromedriver ().setup ();

        ChromeDriver driver = new ChromeDriver ();
        // in selenium everything start from webdriver interface

        // ChromDriver extends RemoteWebDriver --> implements webDriver
        driver.get ("https://www.google.com");// to open a website
        driver.manage ().window ().maximize ();

        Thread.sleep (3000);// for demo, wait 3 seconds

        String title = driver.getTitle ();
        // method that return page title
        // return <title> Some tile</title> text


        String expectedTitle = "Google";
        System.out.println ("Searched title is ---->" + title);
        if (expectedTitle.equalsIgnoreCase (title)){
            System.out.println ("Test Passed");
        }else {
            System.out.println ("Test not Passed");
        }

        driver.navigate ().to ("https://amazon.com");
        Thread.sleep (3000);

        if (driver.getTitle ().contains ("Amazon")){
            System.out.println ("Test Passed");
        }else {
            System.out.println ("Test not Passed");
        }
        // comeback to google
        driver.navigate ().back ();
        Thread.sleep (3000);
        verifyEquals (driver.getTitle (),"google");
        //move forward in the browser history
        driver.navigate ().forward ();
        verifyEquals (driver.getTitle (),"amazon");
        System.out.println ("Title = " + driver.getTitle ());

        System.out.println ("URL:  " + driver.getCurrentUrl ());


        driver.close ();// to close browser

        driver.navigate ().refresh ();
        // to reload the page








    }

    public static void verifyEquals(String arg1, String arg2){

        if (arg1.toLowerCase ().contains (arg2)){

            System.out.println ("Test Passed");
        }else {
            System.out.println ("Test not Passed");
        }


    }
}
