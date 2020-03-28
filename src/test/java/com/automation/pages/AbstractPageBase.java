package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import  com.automation.utilities.*;


/**
 * @author:
 * @create:
 * @date:
 * This class will be extended by page classes
 * Ant common webElements/ locators can be stored here
 * since navigation menu doesn't belong to particular page
 * We cannot really create a dedictiation
 */
public abstract class AbstractPageBase {
    protected WebDriver driver = Driver.getDriver();
    public AbstractPageBase(){

        PageFactory.initElements(driver,this);
    }

    public void navigateTo(String tabName,String moduleName){
        String NameXpath= "/span[@class=\"title title-level-1\" and contains(text(),'"+tabName+"')]";
        String module = "//span[@class=\"title title-level-2\"][text()='"+moduleName+"']"   ;
        WebElement tableElement = driver.findElement(By.xpath(NameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(module));

        Actions actions = new Actions(driver);
        actions.moveToElement(tableElement).pause(2000).click(moduleElement).build().perform();
    }
}
