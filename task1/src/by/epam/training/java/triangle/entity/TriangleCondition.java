package by.epam.training.java.triangle.entity;

import by.epam.training.java.triangle.logic.TriangleCalculator;
import by.epam.training.java.triangle.observer.Observer;

public class TriangleCondition implements Observer {
    private double perimeter;
    private double area;

    public TriangleCondition(Triangle triangle) {
        perimeter = TriangleCalculator.calculatePerimeter(triangle);
        area = TriangleCalculator.calculateArea(triangle);
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    @Override
    public void update(Triangle triangle) {
        if (triangle != null) {
            perimeter = TriangleCalculator.calculatePerimeter(triangle);
            area = TriangleCalculator.calculateArea(triangle);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        TriangleCondition that = (TriangleCondition) obj;

        return (this.perimeter == that.perimeter && this.area == that.area);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;

        temp = Double.doubleToLongBits(perimeter);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(area);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return "Triangle condition. Perimeter: " + perimeter + ". Area: " + area;
    }
}
