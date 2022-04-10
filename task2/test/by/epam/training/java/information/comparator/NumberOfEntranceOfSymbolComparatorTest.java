package by.epam.training.java.information.comparator;

import by.epam.training.java.information.composite.Component;
import by.epam.training.java.information.composite.impl.TextComposite;
import by.epam.training.java.information.composite.impl.TextLeaf;
import by.epam.training.java.assanoooovi4k.information.composite.type.ComponentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumberOfEntranceOfSymbolComparatorTest {
    private TextComposite composite1;
    private TextComposite composite2;
    private NumberOfEntranceOfSymbolComparator comparator;

    @BeforeMethod
    public void setUp() {
        char symbol = 's';
        Component leaf1 = new TextLeaf('s', ComponentType.SYMBOL);
        Component leaf2 = new TextLeaf('a', ComponentType.SYMBOL);

        composite1 = new TextComposite(ComponentType.SYMBOL);
        composite1.add(leaf1);
        composite2 = new TextComposite(ComponentType.SYMBOL);
        composite2.add(leaf2);

        comparator = new NumberOfEntranceOfSymbolComparator(symbol);
    }

    @Test
    public void testCompareShouldBeMinusOne() {
        int actual = comparator.compare(composite1, composite2);
        int expected = -1;
        assertEquals(actual, expected);
    }

    @Test
    public void testCompareShouldBeOne() {
        int actual = comparator.compare(composite2, composite1);
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void testCompareShouldBeNull() {
        int actual = comparator.compare(composite1, composite1);
        int expected = 0;
        assertEquals(actual, expected);
    }
}