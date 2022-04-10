package by.epam.training.java.information.handler.impl;

import by.epam.training.java.information.composite.Component;
import by.epam.training.java.information.composite.impl.TextComposite;
import by.epam.training.java.assanoooovi4k.information.composite.type.ComponentType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompositeHandlerTest {

    @DataProvider(name = "dataForParagraphsHandler")
    public Object[][] dataForParagraphsHandler() {
        return new Object[][] {
                {"Test. Test. Test.", 1},
                {"TEST TEST.\n TEST \n TEST TEST.\n TEST.", 4},
                {"Test. \nTest Test.\r\t Test Test.", 3}
        };
    }


    @Test(dataProvider = "dataForParagraphsHandler")
    public void testParseFirst(String data, int expected) {
        CompositeHandler handler = new CompositeHandler( ComponentType.PARAGRAPH);
        Component composite = new TextComposite(ComponentType.TEXT);
        handler.parse(data, composite);
        int actual = composite.getComponents().size();
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForLexemesHandler")
    public Object[][] dataForLexemesHandler() {
        return new Object[][] {
                {"TEST. 13<<2. !.", 3},
                {"(7^5|1&2<<(2|5>>2&71))|1200 \n TEST \n TEST TEST.\n TEST.", 5},
                {"Test. 2323 \nTest Test. - Test Test.", 7}
        };
    }


    @Test(dataProvider = "dataForLexemesHandler")
    public void testParseSecond(String data, int expected) {
        CompositeHandler handler = new CompositeHandler( ComponentType.LEXEME);
        Component composite = new TextComposite(ComponentType.SENTENCE);
        handler.parse(data, composite);
        int actual = composite.getComponents().size();
        assertEquals(actual, expected);
    }
}