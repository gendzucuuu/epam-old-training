package by.epam.training.java.information.calculator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class PolishNotationCalculatorTest {

    @DataProvider(name = "dataForPolishNotation")
    public static Object[][] dataForPolishNotation() {
        return new Object[][]{
                {"13<<2", Arrays.asList("13", "2", "<<")},
                {"5|13>>2&5", Arrays.asList("5", "13", "2", ">>", "5", "&", "|")},
                {"2&5|13>>2&5>>>5", Arrays.asList("2", "5", "&", "13", "2", ">>", "5", "5", ">>>", "&", "|")},
                {"2&(5|13)>>2&5>>>(5|2|3)", Arrays.asList("2", "5", "13", "|", "2", ">>",
                        "&", "5", "5", "2", "|", "3", "|", ">>>", "&")}
        };
    }

    @Test(dataProvider = "dataForPolishNotation")
    public void testCalculate(String data, List<String> expected) {
        List<String> actual = PolishNotationCalculator.calculate(data);
        assertEquals(actual, expected);
    }
}