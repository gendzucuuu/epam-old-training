package by.epam.java.training.xml.parser.sax;

import by.epam.java.training.xml.parser.AbstractBuilder;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SaxBuilder extends AbstractBuilder {
    private static final Logger logger = LogManager.getLogger(SaxBuilder.class);

    private PaperHandler handler;
    private XMLReader xmlReader;

    public SaxBuilder() {
        handler = new PaperHandler();
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(handler);
        } catch (SAXException e) {
            logger.log(Level.ERROR, "SAX exception.", e);
        }
    }

    @Override
    public void buildListOfPapers(String filePath) {
        try {
            xmlReader.parse(filePath);
        } catch (SAXException e) {
            logger.log(Level.ERROR, "SAX exception.", e);
        } catch (IOException e) {
            logger.log(Level.FATAL, "File not found. Check path to file: " + filePath, e);
            throw new RuntimeException("File not found. Check path to file.", e);
        }

        papers = handler.getPapers();
    }
}
