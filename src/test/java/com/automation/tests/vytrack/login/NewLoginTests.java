package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.TestBase;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class NewLoginTests extends TestBase {

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
    
}
