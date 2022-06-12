package Configurations.SetUp;

import Configurations.Base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import util.AutomationProperties;
import util.MyListener;
import util.PropertyEnum;
import util.WebDriverListeners;

import java.net.URL;
import java.util.concurrent.TimeUnit;
public class Initialization extends TestBase {
    public static WebDriverListeners listeners;
    public static WebDriver InitializeDriver(){
        try {
            boolean browserChrome = Boolean.parseBoolean(AutomationProperties.getProperty(PropertyEnum.BROWSER_CHROME));
            boolean browserDocker = Boolean.parseBoolean(AutomationProperties.getProperty(PropertyEnum.BROWSER_DOCKER));
            System.out.println(browserDocker);
            System.out.println(browserChrome);
            if(browserChrome){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                logger.info("Initialize chromedriver using WebDriverManager....");
            }else if(browserDocker){
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName("chrome");
                driver = new RemoteWebDriver(new URL("http://localhost:4444"),desiredCapabilities);
                driver.manage().window().maximize();
            }

//            WebDriverListener listener = new MyListener();
//            driver = new EventFiringDecorator(listener).decorate(driver);

            driver.manage().window().maximize();
            logger.info("Maximized window");
            driver.manage().timeouts().implicitlyWait(Long.parseLong(AutomationProperties.getProperty(PropertyEnum.IMPLICITLY_MAXIMUM_WAIT_TIME)), TimeUnit.SECONDS);
        }catch (Exception e){
            System.out.println("Exception occurred when initialize the driver");
        }
        return driver;
    }
}
