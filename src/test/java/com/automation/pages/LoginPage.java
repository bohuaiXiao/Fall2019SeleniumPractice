package com.automation.pages;


import org.openqa.selenium.Keys;
import com.automation.utilities.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author:
 * @create:
 * @date:
 */
public class LoginPage {
    protected WebDriver driver = Driver.getDriver();
    @FindBy(id="prependedInput")
    public WebElement username;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(id="_submit")
    public WebElement login;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPassword ;

    @FindBy(css="#login-form > fieldset > div.alert.alert-error > div")
    private WebElement warningMessage;


    public LoginPage(){
        PageFactory.initElements(driver,this);
    }


    // login as spacifc user
    public void login(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.login.click();

    }

    /**
     * Method to login, version 2
     * Login as default user
     */
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
    }

    public String getWarningMessage(){
        return warningMessage.getText();
    }


}
