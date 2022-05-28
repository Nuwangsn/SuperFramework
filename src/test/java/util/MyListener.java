package util;

import Configurations.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class MyListener extends TestBase implements WebDriverListener{

    public void beforeFindElement(WebDriver driver, By locator) {
        logger.info("try to find "+locator+" driver is "+locator.getClass().getName());
    }

    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        logger.info("Found "+locator+ "and the result is " +result);
    }



}
