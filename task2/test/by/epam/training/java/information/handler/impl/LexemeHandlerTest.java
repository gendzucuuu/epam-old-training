package by.epam.training.java.information.handler.impl;

import by.epam.training.java.information.composite.Component;
import by.epam.training.java.information.composite.impl.TextComposite;
import by.epam.training.java.assanoooovi4k.information.composite.type.ComponentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LexemeHandlerTest {

    @DataProvider(name = "dataForExpressionHandler")
    public Object[][] dataForExpressionHandler() {
        return new Object[][] {
                {"test", 0},
                {"First qwe 13<<2 , qwe.", 1},
        };
    }

    @Test(dataProvider = "dataForExpressionHandler")
    public void testParse(String data, int expected) {
        LexemeHandler handler = new LexemeHandler(null);
        Component composite = new TextComposite(ComponentType.EXPRESSION);
        handler.parse(data, composite);
        int actual = composite.getComponents().size();
        assertEquals(actual, expected);
    }
}