package by.epam.training.java.triangle.creator;

import by.epam.training.java.triangle.entity.Triangle;
import by.epam.training.java.triangle.entity.TriangleCondition;

public class TriangleConditionFactory {
    private TriangleConditionFactory() {

    }

    public static TriangleCondition createTriangleCondition(Triangle triangle) {
        return new TriangleCondition(triangle);
    }
}
