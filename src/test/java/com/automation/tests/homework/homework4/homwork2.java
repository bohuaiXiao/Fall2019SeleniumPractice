package com.automation.tests.homework.homework4;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author:
 * @create:
 * @date:
 */
public class homwork2 {
    /**
     * TODAYS DATE
     * 1. go to http://practice.cybertekschool.com/dropdown
     * 2. verify that dropdowns under Select your date of birth display current year, month, day
     * YEARS, MONTHS, DAYS
     * 1. go to http://practice.cybertekschool.com/dropdown
     * 2. select a random year under Select your date of birth
     * 3. select month January
     * 4. verify that days dropdown has current number of days
     * 5. repeat steps 3, 4 for all the months
     * NOTE: if you randomly select a leap year, verify February has 29 days
     */
    private WebDriver driver;
    private By yearBy = By.xpath("//select[@id='year']");
    private By monthBy = By.xpath("//select[@id='month']");
    private By dayBy = By.xpath("//select[@id='day']");

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test(description = "verify that dropdowns under Select your " +
            "date of birth display " +
            "current year, month, day\n" +
            "     * YEARS, MONTHS, DAYS")
    public void test1() {
        // get the locators Year month and day
        String dateAndYear = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));

        System.out.println("dateAndYear = " + dateAndYear);
        System.out.println(driver.findElement(By.cssSelector("#content > h6:nth-child(9)")).getText());
        String year = "2020";
        String month = "March";
        String days = "24";
        String result = month + " " + days + ", " + year;
        Assert.assertEquals(result, dateAndYear);

    }

    @Test(description =
            "     * 2. select a random year under Select your date of birth\n" +
                    "     * 3. select month January\n" +
                    "     * 4. verify that days dropdown has current number of days\n" +
                    "     * 5. repeat steps 3, 4 for all the months\n" +
                    "     * NOTE: if you randomly select a leap year, verify February has 29 days")
    public void test2() {
        Select selectYear = new Select(driver.findElement(yearBy));
        Select selectDays = new Select(driver.findElement(dayBy));
        Select selectMonth = new Select(driver.findElement(monthBy));
        Random random = new Random();
        int a = random.nextInt(99);
        String value = (a + 1921) + "";
        Integer yearInt = Integer.valueOf(value);
        System.out.println("yearInt = " + yearInt);
        selectYear.selectByValue(value);

        boolean isLeap = false;
        if (yearInt%4==0&&yearInt%100!=0||yearInt%400==0){
            isLeap = true;
        }


        for (int i = 0; i <= 11; i++) {
            System.out.println("i = " + i);
            selectMonth.selectByIndex(i);
            BrowserUtils.iWait(1);

            if (i == 3 || i == 5 || i == 8 || i == 10) {
                for (int j = 1; j <= 30; j++) {
                    selectDays.selectByIndex((j-1));
                    BrowserUtils.iWait(1);
                }
            } else if (i == 1 && !isLeap) {
                for (int j = 1; j <= 28; j++) {
                    selectDays.selectByIndex((j-1));
                    BrowserUtils.iWait(1);
                }
            } else if (i == 1 && isLeap) {
                for (int j = 1; j <= 29; j++) {
                    selectDays.selectByIndex((j-1));
                    BrowserUtils.iWait(1);
                }
            } else {
                for (int j = 1; j <= 31; j++) {
                    selectDays.selectByIndex((j-1));
                    BrowserUtils.iWait(1);
                }
            }
        }


    }
}

