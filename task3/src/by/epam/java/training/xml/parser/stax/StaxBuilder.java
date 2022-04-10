package by.epam.java.training.xml.parser.stax;

import by.epam.java.training.assanoooovi4k.xml.entity.*;
import by.epam.java.training.xml.entity.*;
import by.epam.java.training.xml.exception.MethodNotSupportedException;
import by.epam.java.training.xml.exception.ParserException;
import by.epam.java.training.xml.parser.AbstractBuilder;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class StaxBuilder extends AbstractBuilder {
    private static final Logger logger = LogManager.getLogger(StaxBuilder.class);
    private XMLInputFactory xmlInputFactory;

    public StaxBuilder() {
        xmlInputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildListOfPapers(String filePath) {
        FileInputStream fileInputStream;
        XMLStreamReader xmlStreamReader;
        String name;

        try {
            fileInputStream = new FileInputStream(new File(filePath));
            xmlStreamReader = xmlInputFactory.createXMLStreamReader(fileInputStream);

            while (xmlStreamReader.hasNext()) {
                int type = xmlStreamReader.next();

                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = xmlStreamReader.getLocalName();

                    if (PaperEnum.NEWSPAPER.getValue().equals(name)) {
                        Paper paper = buildNewspaper(xmlStreamReader);
                        papers.add(paper);
                    } else if (PaperEnum.JOURNAL.getValue().equals(name)) {
                        Paper paper = buildJournal(xmlStreamReader);
                        papers.add(paper);
                    } else if (PaperEnum.BOOKLET.getValue().equals(name)) {
                        Paper paper = buildBooklet(xmlStreamReader);
                        papers.add(paper);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            logger.log(Level.FATAL, "File not found. Check path to file: " + filePath, e);
            throw new RuntimeException("File not found. Check path to file.", e);
        } catch (XMLStreamException e) {
            logger.log(Level.ERROR, "XML stream exception.", e);
        }

    }


    private Paper buildBooklet(XMLStreamReader reader) {
        Paper paper = new Booklet();

        paper = buildAttributes(paper, reader);
        try {
            paper = buildElements(paper, reader);
        } catch (ParserException e) {
            logger.log(Level.ERROR, "Parser exception.", e);
        }

        return paper;
    }

    private Paper buildJournal(XMLStreamReader reader) {
        Paper paper = new Journal();
        paper = buildAttributes(paper, reader);

        try {
            paper = buildElements(paper, reader);
        } catch (ParserException e) {
            logger.log(Level.ERROR, "Parser exception.", e);
        }

        return paper;
    }

    private Paper buildNewspaper(XMLStreamReader reader) {
        Paper paper = new Newspaper();
        paper = buildAttributes(paper, reader);

        try {
            paper = buildElements(paper, reader);
        } catch (ParserException e) {
            logger.log(Level.ERROR, "Parser exception.", e);
        }
        return paper;
    }

    private Paper buildAttributes(Paper paper, XMLStreamReader reader) {
        Long id = Long.parseLong(reader.getAttributeValue(null, PaperEnum.ID.getValue()));
        paper.setId(id);
        String title = reader.getAttributeValue(null, PaperEnum.TITLE.getValue());
        paper.setTitle(title);
        return paper;
    }

    private Paper buildElements(Paper paper, XMLStreamReader reader) throws ParserException {
        String name;

        try {
            while (reader.hasNext()) {

                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        int subType = type;

                        while (reader.hasNext() && subType != XMLStreamConstants.CHARACTERS) {
                            subType = reader.next();
                        }

                        switch (Objects.requireNonNull(PaperEnum.findByValue(name))) {
                            case MONTHLY:
                                paper.setMonthly(Boolean.parseBoolean(reader.getText()));
                                break;
                            case COLORED:
                                paper.setColored(Boolean.parseBoolean(reader.getText()));
                                break;
                            case VOLUME:
                                paper.setVolume(Integer.parseInt(reader.getText()));
                                break;
                            case GLOSSY:
                                paper.setGlossy(Boolean.parseBoolean(reader.getText()));
                                break;
                            case SUBSCRIPTION_INDEX:
                                paper.setSubscriptionIndex(Integer.parseInt(reader.getText()));
                                break;
                            case NEWSPAPER_TYPE:
                                paper.setNewspaperType(NewspaperType.findByValue(reader.getText()));
                                break;
                            case JOURNAL_TYPE:
                                paper.setJournalType(JournalType.findByValue(reader.getText()));
                                break;
                            case NAME_OF_COMPANY:
                                paper.setNameOfCompany(reader.getText());
                                break;
                            case BOOKLET_TYPE:
                                paper.setBookletType(BookletType.findByValue(reader.getText()));
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (PaperEnum.NEWSPAPER.getValue().equals(name) || PaperEnum.JOURNAL.getValue().equals(name) ||
                                PaperEnum.BOOKLET.getValue().equals(name)) {
                            return paper;
                        }
                        break;
                }
            }
        } catch (XMLStreamException e) {
            logger.log(Level.ERROR, "XML stream exception.", e);
        } catch (MethodNotSupportedException e) {
            logger.log(Level.ERROR, "Method not supported exception.", e);
        }

        throw new ParserException("Unknown element in tag.");
    }
}
