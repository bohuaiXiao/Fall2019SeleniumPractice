package com.automation.pages.fleet;

import com.automation.pages.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class VehiclePage extends AbstractPageBase {
    @FindBy(partialLinkText = "Create Car")
    private WebElement createCar;

    @Test
    public void clickToCreateCar(){
        WebDriverWait wait = new WebDriverWait(driver,10)   ;
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();

    }

}
