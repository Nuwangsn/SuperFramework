package util;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyHandle {
    private final Properties properties = new Properties();
    private PropertyHandle(){
        try {
            FileInputStream file = new FileInputStream("Automation.properties");
            properties.load(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static class Handler{
        private static final PropertyHandle instance = new PropertyHandle();
    }

    public static PropertyHandle getInstance(){
        return Handler.instance;
    }

    public String getValue(String key){
        return properties.getProperty(key).trim();
    }



}
