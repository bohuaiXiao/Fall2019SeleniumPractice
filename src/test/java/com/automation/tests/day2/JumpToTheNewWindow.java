package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver ().setup ();
        ChromeDriver driver = new ChromeDriver ();

        driver.get ("http://google.com");

        Thread.sleep (4000);
        // every window has some ID, this ID calls window handle
        // based on window handle, we can switch in between windows
        String windowHandle = driver.getWindowHandle ();
        System.out.println ("windowHandle = " + windowHandle);

        //since we have all windows
        // and we know ID of original window
        // we can say switch to something is not equals to old window Id




        Set<String> windowHandles = driver.getWindowHandles ();

        for (String each :
                windowHandles) {
            if (!each.equals (windowHandle)){
                driver.switchTo ().window (each);
            }
        }
        WebElement name = driver.findElementByName ("q");
        System.out.println ("name = " + name);

        System.out.println ("After switch  "+driver.getCurrentUrl ());
        driver.close ();





    }
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles ();
        for (String windowID: windows
             ) {
            driver.switchTo ().window (windowID);
            if (driver.getTitle ().equals (driver.getTitle ())){
                break;
            }


        }



    }



    }

