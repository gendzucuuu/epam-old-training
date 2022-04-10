package by.epam.training.java.triangle.creator;

import by.epam.training.java.triangle.entity.Point;
import by.epam.training.java.triangle.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.*;

public class TriangleFactoryTest {

    @Test(dataProvider = "dataForTriangleCreator")
    public void getImpossibleTetrahedronTest(Point a, Point b, Point c) {
        Optional<Triangle> optional = TriangleFactory.createTriangle(a, b, c);
        boolean actual = optional.isPresent();
        Assert.assertTrue(actual);
    }

    @DataProvider(name = "dataForTriangleCreator")
    public Object[][] dataForTriangleCreator() {
        return new Object[][] { { new Point(1, 0), new Point(2, 3), new Point(4, 5)}};
    }

}