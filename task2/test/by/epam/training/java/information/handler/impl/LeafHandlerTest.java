package by.epam.training.java.information.handler.impl;

import by.epam.training.java.information.composite.Component;
import by.epam.training.java.information.composite.impl.TextComposite;
import by.epam.training.java.assanoooovi4k.information.composite.type.ComponentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LeafHandlerTest {

    @DataProvider(name = "dataForLeafHandler")
    public Object[][] dataForLeafHandler() {
        return new Object[][] {
                {"test", 4},
                {"test test", 9},
                {"test , test", 11},
        };
    }

    @Test(dataProvider = "dataForLeafHandler")
    public void testParse(String data, int expected) {
        LeafHandler handler = new LeafHandler();
        Component composite = new TextComposite(ComponentType.SENTENCE);
        handler.parse(data, composite);
        int actual = composite.getComponents().size();
        assertEquals(actual, expected);
    }
}