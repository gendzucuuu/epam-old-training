package by.epam.training.java.triangle.logic;

import by.epam.training.java.triangle.entity.Point;
import by.epam.training.java.triangle.entity.Triangle;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleCalculatorTest {
    private static Triangle triangle;
    private static Triangle rectTriangle;
    private static Triangle equilTriangle;


    @BeforeClass
    public void setUp() {
        //Random triangle
        Point point1 = new Point(2, 4);
        Point point2 = new Point(2, 10);
        Point point3 = new Point(3, 5);
        triangle = new Triangle(point1, point2, point3);

        //Rectangular, isosceles triangle
        point1 = new Point(0, 0);
        point2 = new Point(2, 0);
        point3 = new Point(0, 2);
        rectTriangle = new Triangle(point1, point2, point3);

        //Equilateral, acute-angle triangle
        point1 = new Point(0, 0);
        point2 = new Point(0.5, Math.sqrt(3)/2);
        point3 = new Point(1, 0);
        equilTriangle = new Triangle(point1, point2, point3);
    }



    @Test
    public void testCalculatePerimeterShouldBeOk() {
        double expected = 12.51;
        double actual = TriangleCalculator.calculatePerimeter(triangle);
        assertEquals(actual, expected, 0.01);
    }

    @Test
    public void testCalculateAreaShouldBeOk() {
        double expected = 3;
        double actual = TriangleCalculator.calculateArea(triangle);
        assertEquals(actual, expected, 0.01);
    }

    @Test
    public void testIsRectangularShouldBeFalse() {
        boolean actual = TriangleCalculator.isRectangular(triangle);
        assertFalse(actual);
    }

    @Test
    public void testIsRectangularShouldBeTrue() {
        boolean actual = TriangleCalculator.isRectangular(rectTriangle);
        assertTrue(actual);
    }

    @Test
    public void testIsIsoscelesShouldBeFalse() {
        boolean actual = TriangleCalculator.isIsosceles(triangle);
        assertFalse(actual);
    }

    @Test
    public void testIsIsoscelesShouldBeTrue() {
        boolean actual = TriangleCalculator.isIsosceles(rectTriangle);
        assertTrue(actual);
    }

    @Test
    public void testIsEquilateralShouldBeFalse() {
        boolean actual = TriangleCalculator.isEquilateral(triangle);
        assertFalse(actual);
    }

    @Test
    public void testIsEquilateralShouldBeTrue() {
        boolean actual = TriangleCalculator.isEquilateral(equilTriangle);
        assertTrue(actual);
    }


    @Test
    public void testIsAcuteAngleShouldBeTrue() {
        boolean actual = TriangleCalculator.isAcuteAngle(equilTriangle);
        assertTrue(actual);
    }

    @Test
    public void testIsAcuteAngleShouldBeFalse() {
        boolean actual = TriangleCalculator.isAcuteAngle(triangle);
        assertFalse(actual);
    }

    @Test
    public void testIsObtuseShouldBeTrue() {
        boolean actual = TriangleCalculator.isObtuse(triangle);
        assertTrue(actual);
    }
}