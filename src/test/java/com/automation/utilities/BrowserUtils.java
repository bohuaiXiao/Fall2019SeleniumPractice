package com.automation.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public  class BrowserUtils {

    public static void iWait (long seconds){
        try {
            Thread.sleep (1000*seconds);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public static List<String> getElementText(List<WebElement> columnName){
        List<String > string = new ArrayList<>();
        for (WebElement each:columnName
             ) {
            string.add(each.getText());
        }
        return string;
    }
    


}
