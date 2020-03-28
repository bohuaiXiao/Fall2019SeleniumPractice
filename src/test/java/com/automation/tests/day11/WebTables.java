package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author:
 * @create:
 * @date:
 */
public class WebTables {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/tables");
    }
    @Test
    public void verifyRowCount(){
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        Assert.assertEquals(rows.size(),4);
        System.out.println("rows = " + rows);
    }
    /*
    To get specific column, skip row index, and just provide tf index
     */
    @Test
    public void getSpecificColumn(){
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getElementText(links));

    }


    @Test
    /*
    Go to tables example page
    Delete record based on with jsmith@gmail.com email
    verify that number of row is equals to 3
    very
     */
    public void test3(){
        driver.findElement(By.cssSelector("#table1 > tbody > tr:nth-child(1) > td:nth-child(6) > a.cell")).click();
    String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";

    int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();

   Assert.assertEquals(rowCount,3);

    List<WebElement> emails = driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']"));

    Assert.assertTrue(emails.isEmpty());
    }


    /*
    Let's write a function that will return column index based on the Name
     */
    @Test
    public void getColumnIndexByName(){
        String columnName = "Email";
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[2]//th"));
        int index = 0;
        for (int i = 0; i < columnNames.size(); i++) {
            String actualColumnName = columnNames.get(i).getText();


            System.out.println(String.format("Column name: %s",actualColumnName,i));
            if (actualColumnName.equals(columnName)){
                index = i+1;
                break;
            }
        }
        Assert.assertEquals(index,3);
    }
    @Test
    public void getSpecificCell(){
        int row =3;
        int column =5;
        String xpath= "//table[1]//tbody//tr["+row+"]//td["+column+"]";
        WebElement cell = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(cell.getText(),"http://www.jdoe.com");

    }



}
