package by.epam.training.java.information.comparator;

import by.epam.training.java.information.composite.Component;
import by.epam.training.java.information.composite.impl.TextComposite;
import by.epam.training.java.information.composite.impl.TextLeaf;
import by.epam.training.java.assanoooovi4k.information.composite.type.ComponentType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ComponentsCountComparatorTest {

    private TextComposite composite1;
    private TextComposite composite2;
    private TextComposite composite3;
    private ComponentsCountComparator comparator;

    @BeforeMethod
    public void setUp() {
        Component leaf1 = new TextLeaf('s', ComponentType.SYMBOL);
        Component leaf2 = new TextLeaf('a', ComponentType.SYMBOL);
        Component leaf3 = new TextLeaf('d', ComponentType.SYMBOL);
        Component leaf4 = new TextLeaf('b', ComponentType.SYMBOL);
        Component leaf5 = new TextLeaf('c', ComponentType.SYMBOL);
        Component leaf6 = new TextLeaf('r', ComponentType.SYMBOL);

        composite1 = new TextComposite(ComponentType.SYMBOL);
        composite1.add(leaf1);
        composite1.add(leaf2);
        composite1.add(leaf3);

        composite2 = new TextComposite(ComponentType.SYMBOL);
        composite2.add(leaf4);
        composite2.add(leaf5);
        composite2.add(leaf6);

        composite3 = new TextComposite(ComponentType.SYMBOL);
        composite3.add(leaf4);
        composite3.add(leaf5);

        comparator = new ComponentsCountComparator();
    }


    @Test
    public void testCompareShouldBeNull() {
        int actual = comparator.compare(composite1, composite2);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void testCompareShouldBeOne() {
        int actual = comparator.compare(composite3, composite1);
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void testCompareShouldBeMinusOne() {
        int actual = comparator.compare(composite2, composite3);
        int expected = -1;
        assertEquals(actual, expected);
    }
}