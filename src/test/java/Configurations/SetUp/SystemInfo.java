package Configurations.SetUp;

import Configurations.Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SystemInfo extends TestBase {
    public void getSystemInfo(WebDriver driver){
    try {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Browser Name is : "+((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase());
        System.out.println("Browser Name is : "+((RemoteWebDriver) driver).getCapabilities().getBrowserVersion().toLowerCase());
        System.out.println("Browser Name is : "+((RemoteWebDriver) driver).getCapabilities().getPlatformName().toString());
        System.out.println("----------------------------------------------------------------");

        logger.info("----------------------------------------------------------------");
        logger.info("Browser Name is : "+((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase());
        logger.info("Browser Name is : "+((RemoteWebDriver) driver).getCapabilities().getBrowserVersion().toLowerCase());
        logger.info("Browser Name is : "+((RemoteWebDriver) driver).getCapabilities().getPlatformName().toString());
        logger.info("----------------------------------------------------------------");

    }catch (Exception e){
        System.out.println("Exception occurred when getting the system information"+e);
        logger.error("Exception occurred when getting the system information");
    }
    }
}
