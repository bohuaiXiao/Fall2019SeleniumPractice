package com.automation.tests.homework;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class Test_NGPractice {
    private WebDriver driver;
    private By Registration_Form = By.linkText("Registration Form");
    private By DobBy = By.name("birthday");
    private By CBy = By.id("inlineCheckbox1");
    private By JavaBy = By.id("inlineCheckbox2");
    private By JavaSBy = By.id("inlineCheckbox3");
    private By first_NameBy = By.name("firstname");
    private By last_NameBy = By.name("lastname");
    private By user_NameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    private By genderMaleBy = By.cssSelector("#registrationForm > div:nth-child(7) > div > div:nth-child(1) > label > input[type=radio]");
    private By departmentBy = By.cssSelector("#registrationForm > div:nth-child(9) > div > select");
    private By jobTitleBy = By.cssSelector("#registrationForm > div:nth-child(10) > div > select");
    private By submitBy = By.cssSelector("#wooden_spoon");
    @Test
    public void test_01(){

        driver.findElement(DobBy).sendKeys("wrong_dob");
        WebElement dobWarning = driver.findElement(By.linkText("The date of birth is not valid"));
        BrowserUtils.iWait(3);
        Assert.assertTrue(dobWarning.isDisplayed());
    }

    @Test
    public void test_02(){
        boolean isFlag = false;
        if (driver.findElement(CBy).isDisplayed()&&
                driver.findElement(JavaBy).isDisplayed()&&
                driver.findElement(JavaSBy).isDisplayed())  {
            isFlag = true;
        }
        BrowserUtils.iWait(3);
        Assert.assertTrue(isFlag);

    }

    @Test
    public void test_03(){
    driver.findElement(first_NameBy).sendKeys("a");
        WebElement firstNameWarning = driver.findElement(By.linkText("first name must be more than 2 and less than 64 characters long"));
        BrowserUtils.iWait(3);
        Assert.assertTrue(firstNameWarning.isDisplayed());
    }

    @Test
    public void test_04(){
        driver.findElement(last_NameBy).sendKeys("a");
        WebElement lastNameWaring = driver.findElement(By.cssSelector("#registrationForm > div:nth-child(2) > div > small:nth-child(4)"));
        String expected = "The last name must be more than 2 and less than 64 characters long";
        String actual = lastNameWaring.getText();

        Assert.assertTrue(lastNameWaring.isDisplayed());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void test_05(){

        driver.findElement(first_NameBy).sendKeys("bohuai");
        driver.findElement(last_NameBy).sendKeys("xiao");
        driver.findElement(user_NameBy).sendKeys("justin");
        driver.findElement(emailBy).sendKeys("justin@gmail.com");
        driver.findElement(passwordBy).sendKeys("superPassword123");
        driver.findElement(phoneBy).sendKeys("571-103-5478");
        driver.findElement(genderMaleBy).click();
        driver.findElement(DobBy).sendKeys("02/17/2000");
        BrowserUtils.iWait(1);
        Select select = new Select(driver.findElement(departmentBy));
        select.selectByValue("DE");
        BrowserUtils.iWait(1);
        Select select1 = new Select(driver.findElement(jobTitleBy));
        select1.selectByVisibleText("QA");
        driver.findElement(JavaBy).click();
        BrowserUtils.iWait(1);
        driver.findElement(submitBy).click();
        WebElement successElement = driver.findElement(By.cssSelector("#content > div > div > p"));
        Assert.assertTrue(successElement.isDisplayed(),"Test Passed!!");

    }




    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(Registration_Form).click();
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.iWait(3);
        driver.close();
    }
}
