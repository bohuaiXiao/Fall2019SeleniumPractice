package com.automation.tests.day7;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class UnitTestPractice {
    public static void main(String[] args) {
        String expected = "cba";
        String toReverse = "abc";
        String actual  = reverse(toReverse);
    }
    //@Test - annotation
    @Test(description = "Verify if method can reverse a string")
    public void test(){
        String expected ="elppa";
        String actual = reverse("apple");
        // to verify if expected result is equals to actual
        //it coming from testing , junit also has this class
        // you can compare any data types here: strings, primitives , arrays, objects
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void test1(){
        String expected = "rac";
        String actual = reverse("car");
        Assert.assertEquals(expected,actual);
    }







    public static String reverse(String str){
        String result = "";
        for (int i = str.length()-1  ; i >=0 ; i--) {
            result+= str.charAt(i);
        }
        return result;
    }
}
