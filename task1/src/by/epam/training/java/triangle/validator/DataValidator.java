package by.epam.training.java.triangle.validator;

import by.epam.training.java.triangle.parser.StringParser;

import java.util.List;
import java.util.regex.Pattern;

public class DataValidator {
    private static final String REGEX_DOUBLE = "^[+-]?(\\d*\\.)?\\d+$";
    private static final int NUMBER_OF_ARGS = 6;

    public boolean isValidTriangleData(String lineOfValues) {
        boolean result = true;
        List<String> values = StringParser.parseToStringArray(lineOfValues);

        if (values.size() == NUMBER_OF_ARGS) {
            for (String string : values) {
                if (!isDouble(string)) {
                    result = false;
                }
            }
        } else {
            result = false;
        }

        return result;
    }

    private boolean isDouble(String value) {
        return Pattern.matches(REGEX_DOUBLE, value);
    }
}
