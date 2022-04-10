package by.epam.training.java.triangle.warehouse;

import by.epam.training.java.triangle.entity.TriangleCondition;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<Long, TriangleCondition> triangleConditionMap;

    private Warehouse() {
        triangleConditionMap = new HashMap<>();
    }

    private static class SingletonHolder{
        private static final Warehouse INSTANSE = new Warehouse();
    }

    public static Warehouse getInstance() {
        return SingletonHolder.INSTANSE;
    }

    public  TriangleCondition get(long id) {
        TriangleCondition triangleCondition = triangleConditionMap.get(id);
        return  triangleCondition;
    }

    public void add(long id, TriangleCondition triangleCondition) {
        triangleConditionMap.put(id, triangleCondition);
    }

    public TriangleCondition remove(long id) {
        TriangleCondition triangleCondition = triangleConditionMap.remove(id);
        return triangleCondition;
    }
}
