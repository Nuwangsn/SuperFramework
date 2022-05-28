package Pages;

import Experiment.Name;
import Experiment.TestElementLocatorFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectWithName {

    @Name("Google Search Input")
    @FindBy(xpath = "//input[@name='q']")
    WebElement button;

    public PageObjectWithName(SearchContext context){
        PageFactory.initElements(new TestElementLocatorFactory(context),this);
    }


    public void clickButton(){
        button.click();
    }


}
