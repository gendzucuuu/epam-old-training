package by.epam.training.java.triangle.reader;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader {
    private static final Logger logger = LogManager.getLogger(DataReader.class);

    public List<String> readData(String filePath) {
        List<String> lines;

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            lines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.log(Level.FATAL, "Error while opening file. Check path to file: " + filePath, e);
            throw new RuntimeException("Error while opening file. Check path to file.", e);
        }

        return lines;
    }
}
