package day12;

import com.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author:
 * @create:
 * @date:
 */
public class ImplicitWait {

    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void waitTest(){
        driver.findElement(By.tagName("button")).click();
        WebElement finish = driver.findElement(By.id("finish"));
        System.out.println("finish.getText() = " + finish.getText());


    }

    /*
    Explicit wait - provides better way to wait over implicit wait.
    Explicit wait - exact condition and exact element,Implicit wait - only one condition (presence of element in the DOM)
    and it applies for every findElement() method invocation.

     */
    // How to implement Explicit wait?
    // For this , we use WebDriverWait class

}
