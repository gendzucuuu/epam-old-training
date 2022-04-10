package by.epam.training.java.triangle.repository;

import by.epam.training.java.triangle.entity.Triangle;
import by.epam.training.java.triangle.specification.TriangleSpecification;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepository implements Repository {
    private List<Triangle> triangles;

    private TriangleRepository() {
        triangles = new LinkedList<>();
    }

    private static class SingletonHolder{
        private static final TriangleRepository INSTANSE = new TriangleRepository();
    }

    public static TriangleRepository getInstance() {
        return SingletonHolder.INSTANSE;
    }

    @Override
    public void add(Triangle triangle) {
        triangles.add(triangle);
    }

    @Override
    public void remove(Triangle triangle) {
        triangles.remove(triangle);
    }

    @Override
    public List<Triangle> query(TriangleSpecification triangleSpecification) {
        return triangles.stream().filter(triangleSpecification::specified).collect(Collectors.toList());
    }
}
