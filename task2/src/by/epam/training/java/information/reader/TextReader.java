package by.epam.training.java.information.reader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextReader {
    public String readText(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Path realPath = Paths.get(this.getClass().getResource(path).toURI());
            if (realPath == null) {
                throw new RuntimeException("Path can't be null");
            }
            Files.lines(realPath, StandardCharsets.UTF_8).map(StringBuilder::new).forEach(stringBuilder::append);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
