package com.automation.tests.day13;

import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class DriverTest {




    @Test
    public void googleTest(){
        Driver.getDriver().get("http://google.com");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Google");
        Driver.getDriver().close();

    }
}
