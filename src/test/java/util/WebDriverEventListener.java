package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface WebDriverEventListener {

    void beforeFindBy(By by, WebElement element, WebDriver driver);


}
