package by.epam.training.java.triangle.specification;

import by.epam.training.java.triangle.entity.Triangle;

public class BetweenCoordinatesSpecification implements TriangleSpecification {
    private double xStart;
    private double yStart;
    private double xEnd;
    private double yEnd;

    public BetweenCoordinatesSpecification(double xStart, double yStart, double xEnd, double yEnd) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    @Override
    public boolean specified(Triangle triangle) {
        if (triangle == null) {
            return false;
        }

        return triangle.getPoint1().getX() >= xStart && triangle.getPoint1().getY() >= yStart
                && triangle.getPoint2().getX() >= xStart && triangle.getPoint2().getY() >= yStart
                && triangle.getPoint3().getX() >= xStart && triangle.getPoint3().getY() >= yStart
                && triangle.getPoint1().getX() <= xEnd && triangle.getPoint1().getY() <= yEnd
                && triangle.getPoint2().getX() <= xEnd && triangle.getPoint2().getY() <= yEnd
                && triangle.getPoint3().getX() <= xEnd && triangle.getPoint3().getY() <= yEnd;
    }
}
