package by.epam.training.java.information.calculator;

import by.epam.training.java.information.interpreter.BitwiseOperator;
import by.epam.training.java.information.interpreter.Interpreter;

import java.util.ArrayList;
import java.util.List;

public class BitwiseExpressionCalculator {
    public static List<Interpreter> calculate(String data) {
        List<Interpreter> expressions = new ArrayList<>();
        List<String> polishNotation = PolishNotationCalculator.calculate(data);
        for (String element : polishNotation) {
            if (Character.isDigit(element.charAt(0))) {
                expressions.add(c -> c.pushValue( Long.parseLong(element)));
            } else {
                for (BitwiseOperator operator : BitwiseOperator.values()) {
                    if (element.equals(operator.getBitwiseOperator())) {
                        expressions.add(operator.getBitwiseExpression());
                    }
                }
            }
        }

        return expressions;
    }
}
