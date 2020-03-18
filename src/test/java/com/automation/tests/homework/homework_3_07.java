package com.automation.tests.homework;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

/**
 * @author:
 * @create:
 * @date:
 * Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
 * Step 2. And click on “File Upload".
 * Step 3. Upload any file with .txt extension from your computer.
 * Step 4. Click “Upload” button.
 * Step 5. Verify that subject is: “File Uploaded!”
 * Step 6. Verify that uploaded file name is displayed.
 */
public class homework_3_07 {

    private WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com";
    private By fileUpload = By.linkText("File Upload");
    private By chooseBy = By.cssSelector("#file-upload");
    private By submitBy = By.cssSelector("#file-submit");
    private By subjectBy = By.tagName("h3");
    private By uploadBy = By.id("uploaded-files");
    @Test
    public void test(){
        WebElement chooseElement = driver.findElement(chooseBy);
        File file = new File("/Users/bohuaixiao/Downloads/Untitled (1)");
        if (file.exists()){
            chooseElement.sendKeys(file.getPath());
        }
        driver.findElement(submitBy).click();
        //Step 5. Verify that subject is: “File Uploaded!”
        String expected = "File Uploaded!";
        String actual = driver.findElement(subjectBy).getText();
        Assert.assertEquals(expected,actual);
        //Step 6. Verify that uploaded file name is displayed.
        String uploadName = driver.findElement(uploadBy).getText();
        Assert.assertFalse(uploadName.isEmpty());


    }
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        BrowserUtils.iWait(1);
        driver.findElement(fileUpload).click();
        BrowserUtils.iWait(2);



    }



}
