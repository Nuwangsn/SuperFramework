package Experiment;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class TestElementLocatorFactory implements ElementLocatorFactory {

    SearchContext context;

    public TestElementLocatorFactory(SearchContext context){
        this.context =context;
    }

    @Override
    public ElementLocator createLocator(Field field) {
        return new TestElementLocator(context,field);
    }
}
