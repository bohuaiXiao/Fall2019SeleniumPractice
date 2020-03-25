package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author:
 * @create:
 * @date:
 */
public class ConfigurationReader {
    private static Properties configFile;
    static {
        try {
            //location of properties file
            String path = System.getProperty("user.dir")+ "/configuration.properties";
           //get that file as a stream
            FileInputStream input = new FileInputStream(path);
            //create object of properties class
            configFile = new Properties();
           //load properties file into properties object
            configFile.load(input);
            // close the input stream at the end
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }
    /*
    This method returns property value from configuration.properties file
    @param keyName property name
    @return property value
     */
    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }
}