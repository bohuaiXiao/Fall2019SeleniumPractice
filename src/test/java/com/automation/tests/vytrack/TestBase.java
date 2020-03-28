package com.automation.tests.vytrack;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * @author:
 * @create:
 * @date:
 */
public abstract class TestBase {
    protected WebDriverWait wait;
    // will be visible in the subclass,regardless on subclass location(same package or no)
    protected WebDriver driver=Driver.getDriver();
    protected Actions actions;
    @BeforeMethod
    public void setup(){

        String URL = ConfigurationReader.getProperty("qa2");
        driver.get(URL);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,15);
        actions = new Actions(driver);

    }
    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }

}
