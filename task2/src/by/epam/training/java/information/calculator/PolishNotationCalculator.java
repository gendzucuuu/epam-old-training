package by.epam.training.java.information.calculator;

import by.epam.training.java.information.interpreter.BitwiseOperator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolishNotationCalculator {
    private static final String SPLIT_REGEX =
            "(<<)|(>>>)|(>>)|(\\D(?=[\\d()|~&]|))|(\\d+(?=[\\D]|))";
    private static final String LEFT_BKT_REGEX = "(";
    private static final String RIGHT_BKT_REGEX = ")";

    private PolishNotationCalculator() {

    }

    public static List<String> calculate(String data) {
        List<String> members = split(data);
        List<String> polishNotation = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        for (String member : members) {
            if (Character.isDigit(member.charAt(0))) {
                polishNotation.add(member);
            } else if (member.equals(LEFT_BKT_REGEX) || member.equals(BitwiseOperator.NOT.getBitwiseOperator())) {
                stack.push(member);
            } else if (member.equals(RIGHT_BKT_REGEX)) {
                while (!stack.getFirst().equals(LEFT_BKT_REGEX)) {
                    polishNotation.add(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && (stack.getFirst().equals(BitwiseOperator.NOT.getBitwiseOperator()) ||
                        BitwiseOperator.getPriorityOfOperation(stack.getFirst())
                                >= BitwiseOperator.getPriorityOfOperation(member))) {
                    polishNotation.add(stack.pop());
                }
                stack.push(member);
            }
        }
        polishNotation.addAll(stack);

        return polishNotation;
    }

    private static List<String> split(String expression) {
        Pattern pattern = Pattern.compile(SPLIT_REGEX);
        Matcher matcher = pattern.matcher(expression);

        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.add(matcher.group());
        }

        return result;
    }
}
