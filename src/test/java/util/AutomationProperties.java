package util;

public class AutomationProperties {
    public static String getProperty(PropertyEnum key){
        return PropertyHandle.getInstance().getValue(key.getKeyText());
    }
}
