package com.automation.tests.homework.homework4;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.*;


public class homework6 {
    private WebDriver driver ;
    private By searchBy = By.id("twotabsearchtextbox");
    private By submitBy = By .xpath("//*[@id='nav-search']/form/div[2]/div/input");
    private By randomLink = By.xpath("(//h2)[5]//a");
    private By quantityNumberBy = By.xpath("//*[@id=\"a-autoid-0-announce\"]/span[2]");
    private By priceBy = By.cssSelector("#a-autoid-0-announce");
    private By nameBy = By.cssSelector("#productTitle");
    private By addBy = By.linkText("Add to Cart");
    private WebDriverWait wait ;
    private WebElement primeButton = driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]"));
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.get("https://amazon.com");

    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.iWait(2);
        driver.quit();
    }
// twotabsearchtextbox
    //nav-search-submit-text
    @Test
    public void test1(){

        String randomName = "OXO 1130880 Good Grips Wooden Corner Spoon & Scraper,Brown";
        String randomPrice = "$5.99";
        wait.until(ExpectedConditions.elementToBeClickable(randomLink));
        driver.findElement(randomLink).click();
       // verify
        try{
        Select select = new Select(driver.findElement(By.xpath("//select[@name='quantity']")));
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        String actual = firstSelectedOption.getText().trim();
        System.out.println("actual = " + actual);
        Assert.assertEquals(actual,"1");
        } catch (Exception e) {
            System.out.println("Wrong");
        }

        try{
        String price = driver.findElement(By.xpath("//td[@class='a-span12']//span[1]")).getText();
        Assert.assertEquals(randomPrice,price);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String name  = driver.findElement(By.xpath("(//h1)[1]")).getText();
        Assert.assertEquals(randomName,name);
        Assert.assertTrue(driver.findElement(addBy).isDisplayed());

    }

    @Test
    public void test2(){
        /**
         * PRIME
         * 1. go to https://amazon.com
         * 2. search for "wooden spoon"
         * 3. click search
         * 4. remember name first result that has prime label
         *
         *
         * 5. select Prime checkbox on the left
         * // (//i[@class="a-icon a-icon-checkbox"])[1]
         * 6. verify that name first result that has prime label is same as step 4
         * //  (//h2)[1]
         * 7. check the last checkbox under Brand on the left
         * 8. verify that name first result that has prime label is different
         */

        BrowserUtils.iWait(2);
        String expectName = "Wooden Spoons, 6 Pieces 9 Inch Wood Soup Spoons " +
                "for Eating Mixing Stirring, Long Handle Spoon with Japanese " +
                "Style Kitchen Utensil, ADLORYEA Eco Friendly Table Spoon";

       // wait.until(ExpectedConditions.elementToBeClickable(primeButton)).click();
        primeButton.click();
        BrowserUtils.iWait(2);
        WebElement firstElement = driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-medium\"])[1]//h2"));
        String first_Name = firstElement.getText();
        Assert.assertEquals(expectName,first_Name);
        System.out.println("PASS");
        BrowserUtils.iWait(2);
        WebElement element = driver.findElement(By.cssSelector("#p_89\\/Scanwood > span > a > div > label > i"));
        //wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        BrowserUtils.iWait(2);
        //wait.until(ExpectedConditions.visibilityOfAllElements());
        WebElement scanWood = driver.findElement(By.xpath("(//div[@class='s-expand-height s-include-content-margin s-border-bottom s-latency-cf-section'])[1]//h2"));
        wait.until(ExpectedConditions.visibilityOf(scanWood));
        String title = scanWood.getText();
        boolean isFlag = first_Name.equals(title);
        Assert.assertFalse(isFlag);

    }





}
