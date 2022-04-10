package by.epam.java.training.xml.parser.sax;

import by.epam.java.training.assanoooovi4k.xml.entity.*;
import by.epam.java.training.xml.entity.*;
import by.epam.java.training.xml.exception.MethodNotSupportedException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static by.epam.java.training.xml.entity.PaperEnum.*;

public class PaperHandler extends DefaultHandler {
    private static final Logger logger = LogManager.getLogger(PaperHandler.class);

    private String thisElement;
    private List<Paper> papers;
    private Paper paper;


    public PaperHandler() {
        papers = new ArrayList<>();
    }

    public List<Paper> getPapers() {
        return papers;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        this.thisElement = qName;

        if (localName.equalsIgnoreCase(PaperEnum.JOURNAL.getValue())) {
            paper = new Journal();
        }
        if (localName.equalsIgnoreCase(PaperEnum.NEWSPAPER.getValue())) {
            paper = new Newspaper();
        }
        if (localName.equalsIgnoreCase(PaperEnum.BOOKLET.getValue())) {
            paper = new Booklet();
        }

        for (int index = 0; index < attributes.getLength(); index++) {
            String attribute = attributes.getLocalName(index);
            String value = attributes.getValue(index);
            buildAttributes(attribute, value);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length).trim();

        if (thisElement.equalsIgnoreCase(MONTHLY.getValue())) {
            paper.setMonthly(Boolean.parseBoolean(value));
        }
        if (thisElement.equals(COLORED.getValue())) {
            paper.setColored(Boolean.parseBoolean(value));
        }
        if (thisElement.equals(VOLUME.getValue())) {
            paper.setVolume(Integer.parseInt(value));
        }
        if (thisElement.equals(GLOSSY.getValue())) {
            paper.setGlossy(Boolean.parseBoolean(value));
        }
        if (thisElement.equals(NAME_OF_COMPANY.getValue())) {
            try {
                paper.setNameOfCompany(value);
            } catch (MethodNotSupportedException e) {
                e.printStackTrace();
            }
        }
        if (thisElement.equals(BOOKLET_TYPE.getValue())) {
            try {
                paper.setBookletType(BookletType.findByValue(value));
            } catch (MethodNotSupportedException e) {
                e.printStackTrace();
            }
        }
        if (thisElement.equals(SUBSCRIPTION_INDEX.getValue())) {
            try {
                paper.setSubscriptionIndex(Integer.parseInt(value));
            } catch (MethodNotSupportedException e) {
                e.printStackTrace();
            }
        }
        if (thisElement.equals(JOURNAL_TYPE.getValue())) {
            try {
                paper.setJournalType(JournalType.findByValue(value));
            } catch (MethodNotSupportedException e) {
                e.printStackTrace();
            }
        }
        if (thisElement.equals(NEWSPAPER_TYPE.getValue())) {
            try {
                paper.setNewspaperType(NewspaperType.findByValue(value));
            } catch (MethodNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals(PaperEnum.JOURNAL.getValue()) || qName.equals(PaperEnum.BOOKLET.getValue()) ||
                qName.equals(PaperEnum.NEWSPAPER.getValue())) {
            papers.add(paper);
        }

        this.thisElement = "";
    }

    private void buildAttributes(String attribute, String value) {
        if (attribute.equals(ID.getValue())) {
            paper.setId(Long.parseLong(value));
        } else if (attribute.equals(TITLE.getValue())) {
            paper.setTitle(value);
        } else {
            logger.log(Level.ERROR, "Unknown attribute: " + attribute);
        }
    }
}
