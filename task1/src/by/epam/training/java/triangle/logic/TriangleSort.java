package by.epam.training.java.triangle.logic;

import by.epam.training.java.triangle.entity.Triangle;
import by.epam.training.java.triangle.util.TriangleEnum;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class TriangleSort implements Comparator<Triangle> {
    private static Logger logger = LogManager.getLogger(TriangleSort.class);

    private TriangleEnum sortingIndex;

    public  TriangleSort(TriangleEnum sortingIndex) {
        setSortingIndex(sortingIndex);
    }

    public TriangleEnum getSortingIndex() {
        return sortingIndex;
    }

    public void setSortingIndex(TriangleEnum sortingIndex) {
        if (sortingIndex == null) {
            logger.log(Level.ERROR, "Index can not be null");
        }
        else {
            this.sortingIndex = sortingIndex;
        }
    }

    @Override
    public int compare(Triangle a, Triangle b) {
        switch (sortingIndex) {
            case TRIANGLE_ID:
                return Long.compare(a.getTriangleId(), b.getTriangleId());
            case POINT1_X:
                return Double.compare(a.getPoint1().getX(), b.getPoint1().getX());
            case POINT1_Y:
                return Double.compare(a.getPoint1().getY(), b.getPoint1().getY());
            case POINT2_X:
                return Double.compare(a.getPoint2().getX(), b.getPoint2().getX());
            case POINT2_Y:
                return Double.compare(a.getPoint2().getY(), b.getPoint2().getY());
            case POINT3_X:
                return Double.compare(a.getPoint3().getX(), b.getPoint3().getX());
            case POINT3_Y:
                return Double.compare(a.getPoint3().getY(), b.getPoint3().getY());
            default:
                throw new EnumConstantNotPresentException(TriangleEnum.class, sortingIndex.name());
        }

    }
}
