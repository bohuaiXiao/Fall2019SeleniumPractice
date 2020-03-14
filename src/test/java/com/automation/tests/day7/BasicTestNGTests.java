package com.automation.tests.day7;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author:
 * @create:
 * @date:
 */
public class BasicTestNGTests {

    //runs only once before @BeforeClass and @BeforeMethod
    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }




    // runs before every test automatically
    // works as a pre- condition or setup
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");

    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }


    @BeforeMethod
    public void setup(){
        System.out.println("BEFORE METHOD");
    }

    // runs automatically after every test
    @AfterMethod
    public void teardown(){
        System.out.println("AFTER METHOD");
        System.out.println("_________________________________________");
    }




    @Test
    public void test(){
        System.out.println("TEST1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test1(){
        System.out.println("TEST2");
        int num1 = 6;
        int num2 = 10;
        // it calls hard assertion
        // if assertion fails - it stops the execution(due to exception).
        Assert.assertTrue(num1>num2);
    }
}
