package by.epam.training.java.triangle.logic;

import by.epam.training.java.triangle.entity.Point;
import by.epam.training.java.triangle.entity.Triangle;

public class TriangleCalculator {
    private TriangleCalculator() {

    }

    public static double calculatePerimeter(Triangle triangle) {
        double[] abc = calculateAllSidesLength(triangle);

        return abc[0] + abc[1] + abc[2];
    }

    public static double calculateArea(Triangle triangle) {
        double[] abc = calculateAllSidesLength(triangle);
        double semiPer = calculatePerimeter(triangle) / 2;

        return Math.sqrt(semiPer * (semiPer - abc[0]) * (semiPer - abc[1]) * (semiPer - abc[2]));
    }

    public static boolean isRectangular(Triangle triangle) {
        double[] abc = calculateAllSidesLength(triangle);

        return Math.round(abc[0] * abc[0] + abc[1] * abc[1]) == Math.round(abc[2] * abc[2])
                || Math.round(abc[0] * abc[0] + abc[2] * abc[2]) == Math.round(abc[1] * abc[1])
                || Math.round(abc[2] * abc[2] + abc[1] * abc[1]) == Math.round(abc[0] * abc[0]);

    }

    public static boolean isIsosceles(Triangle triangle) {
        double[] abc = calculateAllSidesLength(triangle);

        return abc[0] == abc[1] || abc[1] == abc[2] || abc[0] == abc[2];

    }

    public static boolean isEquilateral(Triangle triangle) {
        double[] abc = calculateAllSidesLength(triangle);

        return (abc[0] == abc[1]) && (abc[0] == abc[2]);
    }

    public static boolean isAcuteAngle(Triangle triangle) {
        double[] abc = calculateAllSidesLength(triangle);

        if (isObtuse(triangle) || isRectangular(triangle)) {
            return false;
        }

        return (abc[0] * abc[0] + abc[1] * abc[1] > abc[2] * abc[2])
                || (abc[0] * abc[0] + abc[2] * abc[2] > abc[1] * abc[1])
                || (abc[2] * abc[2] + abc[1] * abc[1] > abc[0] * abc[0]);
    }

    public static boolean isObtuse(Triangle triangle) {
        double[] abc = calculateAllSidesLength(triangle);

        return (abc[0] * abc[0] + abc[1] * abc[1] < abc[2] * abc[2])
                || (abc[0] * abc[0] + abc[2] * abc[2] < abc[1] * abc[1])
                || (abc[2] * abc[2] + abc[1] * abc[1] < abc[0] * abc[0]);
    }

    private static double calculateSideLength(Point point1, Point point2) {
        double x1 = point1.getX();
        double y1 = point1.getY();
        double x2 = point2.getX();
        double y2 = point2.getY();

        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    private static double[] calculateAllSidesLength(Triangle triangle) {
        double[] abc = new double[3];
        abc[0] = calculateSideLength(triangle.getPoint1(), triangle.getPoint2());
        abc[1] = calculateSideLength(triangle.getPoint2(), triangle.getPoint3());
        abc[2] = calculateSideLength(triangle.getPoint1(), triangle.getPoint3());

        return abc;
    }
}
