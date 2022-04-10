package by.epam.training.java.triangle.repository;

import by.epam.training.java.triangle.entity.Triangle;
import by.epam.training.java.triangle.specification.TriangleSpecification;

import java.util.List;

public interface Repository {
    void add(Triangle triangle);
    void remove(Triangle triangle);
    //void update(Triangle triangle);

    List<Triangle> query(TriangleSpecification specification);
}
