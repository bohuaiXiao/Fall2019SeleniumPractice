package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.*;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class NewLoginTests extends AbstractTestBase {

    /**
     * Login and verify that page title is a  "Dashboard"
     */
    @Test
    public void verifyPageTitle(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        BrowserUtils.iWait(2);
        String title = Driver.getDriver().getTitle();
        Assert.assertEquals(title,"Dashboard");


    }
    @Test
    public void theMessage(){
        LoginPage loginPage = new LoginPage();
       loginPage.login("wrong","wrong");
       BrowserUtils.iWait(1);
       String message = loginPage.getWarningMessage();
       String expected = "Invalid user name or password."   ;
        System.out.println("message = " + message);

        Assert.assertEquals(message,expected);
    }
    
}
