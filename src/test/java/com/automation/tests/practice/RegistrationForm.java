package com.automation.tests.practice;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class RegistrationForm {
    private String URL = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver ;
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By userNameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneNumberBy = By.cssSelector("#registrationForm > div:nth-child(6) > div > input");
    private  By maleBy = By.cssSelector("#registrationForm > div:nth-child(7) > div > div:nth-child(1) > label > input[type=radio]");
    private By DOB = By.name("birthday");
    private By javaBox = By.id("inlineCheckbox2");
    private By submitBy = By.cssSelector("button[type='submit']");

    @Test
    public void test1(){

        driver.findElement(firstNameBy).sendKeys("firstName");
        driver.findElement(lastNameBy).sendKeys("lastName");
        driver.findElement(userNameBy).sendKeys("bohuai");
        driver.findElement(emailBy).sendKeys("xiao@gmail.com");
        driver.findElement(passwordBy).sendKeys("daaohaoids223w");
        driver.findElement(phoneNumberBy).sendKeys("571-454-5895");
        driver.findElement(maleBy).click();
        driver.findElement(DOB).sendKeys("02/18/2000");


        Select select = new Select(driver.findElement(By.name("department")));
        select.selectByValue("DE");

        Select select1 = new Select(driver.findElement(By.name("job_title")));
        select.selectByIndex(6);


        driver.findElement(javaBox).click();
        driver.findElement(submitBy).click();

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();

        assertEquals(expected,actual);
    }

    @Test
    public void verifyFirstNameLengthTest(){
        driver.findElement(firstNameBy).sendKeys("a");
        String excepted = "first name must be more than 2 and less than 64 characters long";
        BrowserUtils.iWait(3);
        WebElement warningElement = driver.findElement(By.cssSelector("#registrationForm > div:nth-child(1) > div > small:nth-child(4)"));
        String text = warningElement.getText();
        assertTrue(warningElement.isDisplayed());
    }

    @Test
    public void verifyAlphabeticLetterOnlyTest(){
        driver.findElement(firstNameBy).sendKeys("123");
        BrowserUtils.iWait(3);
        WebElement warningMessage = driver.findElement(By.cssSelector("#registrationForm > div:nth-child(1) > div > small:nth-child(5)"));
        assertTrue(warningMessage.isDisplayed());


        int[][] number = {{'a'},{'b'}};
        int arr[] =new int[2];
    }








    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        BrowserUtils.iWait(3);
        driver.quit();
    }




}
