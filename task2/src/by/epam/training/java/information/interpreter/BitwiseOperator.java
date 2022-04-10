package by.epam.training.java.information.interpreter;


public enum BitwiseOperator {
    OR("|", c -> c.pushValue(c.popValue() | c.popValue()), 1),
    XOR("^", c -> c.pushValue(c.popValue() ^ c.popValue()), 2),
    AND("&", c -> c.pushValue(c.popValue() & c.popValue()), 3),
    LEFT_SHIFT("<<", c -> {long temp = c.popValue(); c.pushValue(c.popValue() << temp);}, 4),
    RIGHT_SHIFT(">>", c -> {long temp = c.popValue(); c.pushValue(c.popValue() >> temp);}, 4),
    RIGHT_SHIFT_WITH_ZERO_PADDING(">>>", c -> {long temp = c.popValue(); c.pushValue(c.popValue() >>> temp);}, 4),
    NOT("~", c -> c.pushValue(~c.popValue()), 5);

    private String bitwiseOperator;
    private Interpreter bitwiseExpression;
    private int priority;

    BitwiseOperator(String bitwiseOperator, Interpreter bitwiseExpression, int priority) {
        this.bitwiseOperator = bitwiseOperator;
        this.bitwiseExpression = bitwiseExpression;
        this.priority = priority;
    }

    public String getBitwiseOperator() {
        return bitwiseOperator;
    }

    public Interpreter getBitwiseExpression() {
        return bitwiseExpression;
    }

    public int getPriority() {
        return priority;
    }

    public static int getPriorityOfOperation(String operation) {
        for (BitwiseOperator bitwiseOperation : BitwiseOperator.values()) {
            if (operation.equals(bitwiseOperation.getBitwiseOperator())) {
                return bitwiseOperation.getPriority();
            }
        }
        return 0;
    }
}
