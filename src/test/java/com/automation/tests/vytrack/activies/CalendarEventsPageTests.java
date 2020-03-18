package com.automation.tests.vytrack.activies;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author:
 * @create:
 * @date:
 */
public class CalendarEventsPageTests {
    private WebDriver driver;
    private String URL = "http://qa3.vytrack.com";
    private String username = "storemanager85";   //   valid username
    private String password = "UserUser123";      //   valid password
    private By activitesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By creatBy = By.cssSelector("a[title='Create Calendar event']");
    private By name = By.cssSelector("#user-menu>a");
    private By titleBy = By.name("oro_calendar_event_form[title]");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");
    private By endDateBy = By.cssSelector("[name*='date_selector_oro_calendar_event_form_end-uid']");
    private By endTimeBy = By.cssSelector("[name*='time_selector_oro_calendar_event_form_end-uid']");

    @Test
    public void test2(){
        driver.findElement(By.xpath("//ul[@class='quick-launchpad-toolbar']/li[2]/a")).click();
        driver.findElement(By.xpath("//div[@class='btn-group']/a[@title='Create Contact']")).click();
    }



    @Test
    public  void verifyCreateButton(){
        WebElement element = driver.findElement(creatBy);
        Assert.assertTrue(element.isDisplayed());
    }
    /**
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Default owner name should be current user
     * Default title should be blank
     * Default start date should be current date
     * Default start time should be current time
     */
    @Test(description = "Default options")
    public void verifyDefaultValues(){

        //Click on Create Calender Event
        driver.findElement(creatBy).click();

        String nameDefault = driver.findElement(name).getText().trim();
        BrowserUtils.iWait(5);
        String text = driver.findElement(By.cssSelector(".select2-chosen")).getText().trim();
        Assert.assertEquals(nameDefault,text);
        BrowserUtils.iWait(3);
        WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());
        // Text that upi enter into input box will be stored inside"value"
        // time syntax = https://www.journaldev.com/17899/java-simpledateformat-java-date-format
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");
        Assert.assertEquals(expectedDate,actualDate);

        String expectedTime = LocalTime.now().format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime = driver.findElement(startTimeBy).getAttribute("value");
        Assert.assertEquals(expectedTime,actualTime);



    }
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);
        BrowserUtils.iWait(3);



    }
    @AfterMethod
    public void tearDown() {
        BrowserUtils.iWait(3);
       // driver.close();
    }
}
