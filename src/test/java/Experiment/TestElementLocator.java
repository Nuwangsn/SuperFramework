package Experiment;

import Configurations.Base.TestBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocator;

import java.lang.reflect.Field;
import java.util.UUID;

public class TestElementLocator extends DefaultElementLocator {

    final String UNNAMED = UUID.randomUUID().toString();
    final String elementName;

    public TestElementLocator(SearchContext searchContext, Field field) {
        super(searchContext, field);
        Name elementNameAnnotated = field.getAnnotation(Name.class);
        if(elementNameAnnotated != null){
            elementName = elementNameAnnotated.value();
        }else {
            elementName = UNNAMED;
        }
    }

    private String log(){
        String name = null;
        if(!UNNAMED.equals(elementName)){
            name = elementName;
        }
        return name;
    }

    @Override
    public WebElement findElement(){
        System.out.println(log());
        return super.findElement();
    }

}
