package day13;

import com.utilities.ConfigurationReader;
import org.testng.annotations.Test;

/**
 * @author:
 * @create:
 * @date:
 */
public class ConfigurationReaderTest {

   @Test
   public void readProperties(){
      String browser = ConfigurationReader.getProperty("browser");
      String url = ConfigurationReader.getProperty("qal");
      System.out.println( browser);


   }





}
