package util;

import Configurations.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WebDriverListeners extends TestBase implements WebDriverEventListener {

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info(element.getAccessibleName()+" is Finding..................");
    }
}
