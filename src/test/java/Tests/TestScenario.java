package Tests;

import Configurations.Base.TestBase;
import Pages.GooglePage;
import Pages.PageObjectWithName;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestScenario extends TestBase {

    public PageObjectWithName pageObjectWithName;
    public GooglePage googlePage;


    @BeforeMethod
    public void pageObjectInitialization(){
        googlePage = PageFactory.initElements(driver,GooglePage.class);
    }


    @Test(priority = 1)
    public void checkGoogleTitle() {
        ExtentTest testCase = extent.createTest("checkGoogleTitle","this is the description");
        System.out.println("Title is : "+driver.getTitle());
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Tesla Cars");
        driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
        Assert.assertTrue(googlePage.validateImage(),"Google image is not displaying");
        System.out.println();
        new PageObjectWithName(driver).clickButton();
        testCase.pass("Get title Successfully");

    }

    @Test(priority = 2)
    public void testIncorrectHeaderTitle() {
        ExtentTest negative = extent.createTest("testIncorrectHeaderTitle","this is the description");
        String title = driver.getTitle();
        negative.fail("Error title is not correct");
        logger.warn("Error in title");
        Assert.assertEquals(title,"Google","Error occurred in title");

    }
}
