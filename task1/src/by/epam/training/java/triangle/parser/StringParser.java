package by.epam.training.java.triangle.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParser {
    private static final String REGEX_DELIMITER = "\\s+";

    private StringParser() {
    }

    public static List<String> parseToStringArray(String line) {
        return Arrays.asList(line.split(REGEX_DELIMITER));
    }

    public static List<Double> parseToDoubleArray(String line) {
        List<String> stringValues = parseToStringArray(line);
        List<Double> values = new ArrayList<>();

        for (String s : stringValues) {
            values.add(Double.parseDouble(s));
        }

        return values;
    }
}
