package com.automation.tests.officeHours;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author:
 * @create:
 * @date:
 */
public class JavaMapsOh {
    public static void main(String[] args) {
        HashMap<String, String >  user1 = new HashMap<>();
        user1.put("first_Name",null);
        user1.put("last_Name","Xiao");
        user1.put("Account Number","A6345165");
        user1.put("DOB","02/18/1990");

        System.out.println("user1 = " + user1);

        LinkedHashMap<String, String> user2 = new LinkedHashMap<>();
        user2.put("first_Name","Kuan");
        user2.put("last_Name","Chang");
        user2.put("Account Number","A9834234");
        user2.put("DOB","11/27/1990");




    }

    /*

     */




}
