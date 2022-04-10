package by.epam.training.java.triangle.specification;

import by.epam.training.java.triangle.entity.Triangle;
import by.epam.training.java.triangle.entity.TriangleCondition;
import by.epam.training.java.triangle.logic.TriangleCalculator;
import by.epam.training.java.triangle.warehouse.Warehouse;

public class PerimeterSpecification implements TriangleSpecification{
    private double start;
    private double end;

    public PerimeterSpecification(double start, double end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean specified(Triangle triangle) {
        if (triangle == null) {
            return false;
        }

        Warehouse warehouse = Warehouse.getInstance();
        TriangleCondition triangleCondition = warehouse.get(triangle.getTriangleId());
        double perimeter = (triangleCondition != null)
                ? triangleCondition.getPerimeter() : TriangleCalculator.calculatePerimeter(triangle);
        return (perimeter >= start && perimeter <= end);
    }
}
