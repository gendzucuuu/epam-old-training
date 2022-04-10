package by.epam.training.java.information.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context {
    private Deque<Long> values = new ArrayDeque<>();

    public Long popValue() {
        return values.pop();
    }
    public void pushValue(Long value) {
        values.push(value);
    }
}
