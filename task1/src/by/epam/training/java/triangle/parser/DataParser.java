package by.epam.training.java.triangle.parser;

import by.epam.training.java.triangle.exception.DataFormatException;
import by.epam.training.java.triangle.validator.DataValidator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    private static Logger logger = LogManager.getLogger(DataParser.class);

    public List<String> parseData(List<String> listOfTriangles) throws DataFormatException {
        List<String> parsedList = new ArrayList<>();
        DataValidator dataValidator = new DataValidator();

        for (String pointLine : listOfTriangles) {
            if (dataValidator.isValidTriangleData(pointLine)) {
                parsedList.add(pointLine);
            }
            else {
                logger.log(Level.ERROR, "This line is incorrect: " + pointLine);
            }
        }

        return parsedList;
    }

}
