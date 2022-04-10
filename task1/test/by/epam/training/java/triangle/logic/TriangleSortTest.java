package by.epam.training.java.triangle.logic;

import by.epam.training.java.triangle.entity.Point;
import by.epam.training.java.triangle.entity.Triangle;
import by.epam.training.java.triangle.util.TriangleEnum;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleSortTest {
    private static Triangle triangle1;
    private static Triangle triangle2;
    private static Triangle triangle3;


    @BeforeClass
    public void setUp() {
        Point point1 = new Point(2, 4);
        Point point2 = new Point(0, 0);
        Point point3 = new Point(0, 5);
        triangle1 = new Triangle(point1, point2, point3);

        point1 = new Point(0, 0);
        point2 = new Point(2, 10);
        point3 = new Point(0, 5);
        triangle2 = new Triangle(point1, point2, point3);

        point1 = new Point(0, 0);
        point2 = new Point(0.5, Math.sqrt(3)/2);
        point3 = new Point(1, 0);
        triangle3 = new Triangle(point1, point2, point3);
    }

    @Test
    public void point1XTest() {
        int expected = 1;
        TriangleSort triangleSort = new TriangleSort(TriangleEnum.POINT1_X);
        int actual = triangleSort.compare(triangle1, triangle2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void point2XTest() {
        int expected = -1;
        TriangleSort triangleSort = new TriangleSort(TriangleEnum.POINT2_X);
        int actual = triangleSort.compare(triangle1, triangle2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void point3XTest() {
        int expected = 0;
        TriangleSort triangleSort = new TriangleSort(TriangleEnum.POINT3_X);
        int actual = triangleSort.compare(triangle1, triangle2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void point1YTest() {
        int expected = 1;
        TriangleSort triangleSort = new TriangleSort(TriangleEnum.POINT1_Y);
        int actual = triangleSort.compare(triangle1, triangle2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void point2YTest() {
        int expected = -1;
        TriangleSort triangleSort = new TriangleSort(TriangleEnum.POINT2_Y);
        int actual = triangleSort.compare(triangle1, triangle2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void point3YTest() {
        int expected = 0;
        TriangleSort triangleSort = new TriangleSort(TriangleEnum.POINT3_Y);
        int actual = triangleSort.compare(triangle1, triangle2);
        Assert.assertEquals(expected, actual);
    }
}