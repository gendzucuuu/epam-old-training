package by.epam.training.java.triangle.specification;

import by.epam.training.java.triangle.entity.Triangle;


public class BeforeCoordinatesSpecification implements TriangleSpecification {
    private double x;
    private double y;

    public BeforeCoordinatesSpecification(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean specified(Triangle triangle) {
        if (triangle == null) {
            return false;
        }

        return triangle.getPoint1().getX() <= x && triangle.getPoint1().getY() <= y
                && triangle.getPoint2().getX() <= x && triangle.getPoint2().getY() <= y
                && triangle.getPoint3().getX() <= x && triangle.getPoint3().getY() <= y;
    }
}
