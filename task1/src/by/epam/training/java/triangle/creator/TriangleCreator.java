package by.epam.training.java.triangle.creator;

import by.epam.training.java.triangle.entity.Point;
import by.epam.training.java.triangle.entity.Triangle;
import by.epam.training.java.triangle.parser.StringParser;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class TriangleCreator {
    public List<Triangle> createTriangles(List<String> parsedListOfTriangles) {
        List<Triangle> triangles = new ArrayList<>();

        for (String string : parsedListOfTriangles) {
            triangles.add(createTriangle(string));
        }

        return triangles;
    }

    private Triangle createTriangle(String string) {
        List<Double> values = StringParser.parseToDoubleArray(string);

        return new Triangle(
                new Point(values.get(0), values.get(1)),
                new Point(values.get(2), values.get(3)),
                new Point(values.get(4), values.get(5)));
    }


}
