package Configurations.Base;

import Configurations.SetUp.SetUp;
import Configurations.SetUp.SystemInfo;
import com.aventstack.extentreports.ExtentReports;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import util.AutomationProperties;
import util.PropertyEnum;

import static Configurations.SetUp.Initialization.InitializeDriver;

public class TestBase {
    public static WebDriver driver;
    protected static Logger logger = LogManager.getLogger(TestBase.class);
    public static ExtentReports extent;

    @BeforeSuite
    public void init(){
        try {
            logger.info("Adding prerequisite Data Started");
            System.out.println(logger.isInfoEnabled());
            logger.info("info! {}","Test");
            System.out.println("Init Method is Starting from here ------------------------------------------------------ ");
            logger.info("Init Method is Starting from here ------------------------------------------------------ ");

//            driver initialization
            driver=InitializeDriver();

//            get System Info
            SystemInfo info = new SystemInfo();
            info.getSystemInfo(driver);

//            set Up method
            SetUp reports = new SetUp();
            extent = reports.setUp();
            driver.quit();
        }catch (Exception e){
            System.out.println("Error occurred in init method......");
            logger.warn("Error occurred in init method......");
        }
    }


    @BeforeMethod
    public void beforeTest() {
        driver=InitializeDriver();
        //            base url initialization
        driver.get(AutomationProperties.getProperty(PropertyEnum.BASE_URL));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public void afterClass() {
        extent.flush();
    }
}
