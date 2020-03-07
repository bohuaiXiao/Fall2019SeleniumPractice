package com.utilities;

public class BrowserUtils {

    public static void iWait (long seconds){
        try {
            Thread.sleep (1000*seconds);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
    


}
