package com.automation.tests.day13;

import com.automation.utilities.ConfigurationReader;
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
      String password = ConfigurationReader.getProperty("password");
      String store_manager = ConfigurationReader.getProperty("store_manager");


      System.out.println( browser);
      System.out.println("url = " + url);
      System.out.println("password = " + password);
      System.out.println("store_manager = " + store_manager);

   }





}
