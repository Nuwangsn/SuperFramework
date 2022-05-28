package Configurations.SetUp;

import Configurations.Base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import util.AutomationProperties;
import util.MyListener;
import util.PropertyEnum;
import util.WebDriverListeners;

import java.util.concurrent.TimeUnit;
public class Initialization extends TestBase {
    public static WebDriverListeners listeners;
    public static WebDriver InitializeDriver(){
        try {
            boolean browserChrome = Boolean.parseBoolean(AutomationProperties.getProperty(PropertyEnum.BROWSER_CHROME));
            if(browserChrome){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                logger.info("Initialize chromedriver using WebDriverManager....");
            }

            WebDriverListener listener = new MyListener();
            driver = new EventFiringDecorator(listener).decorate(driver);

            driver.manage().window().maximize();
            logger.info("Maximized window");
            driver.manage().timeouts().implicitlyWait(Long.parseLong(AutomationProperties.getProperty(PropertyEnum.IMPLICITLY_MAXIMUM_WAIT_TIME)), TimeUnit.SECONDS);
        }catch (Exception e){
            System.out.println("Exception occurred when initialize the driver");
        }
        return driver;
    }
}
