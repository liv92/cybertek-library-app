package com.libraryCT.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;

    static {

        try {
            String path = "configuration.properties";
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String getProperties(String keyName){
        return properties.getProperty(keyName);
    }

}
