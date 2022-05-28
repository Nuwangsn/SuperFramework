package Configurations.SetUp;



import Configurations.Base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterMethod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SetUp extends  TestBase{
    public static ExtentReports extent;
    public static ExtentSparkReporter spark;
    public ExtentReports setUp(){
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH-mm");
            LocalDateTime now = LocalDateTime.now();
            String finalDateTime = dateTimeFormatter.format(now);
            System.out.println("Date Time "+finalDateTime);
            System.out.println("-----------------------------------------------------------------");

            extent = new ExtentReports();
            spark = new ExtentSparkReporter("./src/test/java/reports/test-report.html");
            extent.attachReporter(spark);

        }catch (Exception e){
            System.out.println("Error occurred in extent report setup");
            logger.warn("Error occurred in extent report setup");
        }
        return extent;
    }
}
