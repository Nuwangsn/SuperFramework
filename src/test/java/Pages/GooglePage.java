package Pages;

import Configurations.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends TestBase {

    @FindBy(xpath = "//img[@class='lnXdpd']")
    private WebElement googleImage;

    public boolean validateImage(){
        boolean flag = true;
        if(!googleImage.isDisplayed()){
            System.out.println("Element is not displayed");
            flag=false;
        }
        return flag;
    }





}
