package by.epam.training.java.triangle.repository;

import by.epam.training.java.triangle.entity.Point;
import by.epam.training.java.triangle.entity.Triangle;
import by.epam.training.java.triangle.entity.TriangleCondition;
import by.epam.training.java.triangle.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RepositoryTrianglesSaverTest {
    Warehouse warehouse = Warehouse.getInstance();

    @Test(dataProvider = "dataForRepositoryTrianglesSaver")
    public void testSaveTriangles(Triangle triangle) {
        TriangleCondition expected = new TriangleCondition(triangle);
        RepositoryTrianglesSaver.saveTriangle(triangle);
        TriangleCondition actual = warehouse.get(triangle.getTriangleId());
        Assert.assertEquals(expected, actual);
    }

    @DataProvider(name = "dataForRepositoryTrianglesSaver")
    public Object[][] dataForSavingTetrahedronWithParamsTest() {
        return new Object[][]{
                {new Triangle(new Point(2, 1), new Point(3, 6), new Point(7, 9))}};
    }
}