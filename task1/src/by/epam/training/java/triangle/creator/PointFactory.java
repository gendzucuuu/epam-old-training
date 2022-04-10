package by.epam.training.java.triangle.creator;

import by.epam.training.java.triangle.entity.Point;

public class PointFactory {
    private PointFactory() {

    }

    public static Point createPoint(double x, double y) {
        return new Point(x, y);
    }
}
