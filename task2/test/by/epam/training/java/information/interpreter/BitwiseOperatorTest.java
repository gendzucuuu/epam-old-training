package by.epam.training.java.information.interpreter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BitwiseOperatorTest {

    @DataProvider(name = "dataForPriority")
    public static Object[][] dataForPriority() {
        return new Object[][]{
                {"|",1},
                {"^",2},
                {"&",3},
                {"<<",4},
                {">>",4},
                {">>>",4},
                {"~",5},
        };
    }

    @Test(dataProvider = "dataForPriority")
    public void testGetPriorityOfOperation(String data, int expected) {
        int actual = BitwiseOperator.getPriorityOfOperation(data);
        assertEquals(actual,expected);
    }
}