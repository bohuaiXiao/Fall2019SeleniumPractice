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

/**
 * @author:
 * @create:
 * @date:
 * 1. go to https://amazon.com
 * 2. search for "wooden spoon"
 * 3. click search
 * 4. remember the name and the price of a random result
 * 5. click on that random result
 * 6. verify default quantity of items is 1
 * 7. verify that the name and the price is the same as the one from step 5
 * 8. verify button "Add to Cart" is visible
 */
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
    public void test(){
        wait.until(ExpectedConditions.elementToBeClickable(submitBy));
        driver.findElement(searchBy).sendKeys("wooden spoon");
        driver.findElement(submitBy).click();

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



}
