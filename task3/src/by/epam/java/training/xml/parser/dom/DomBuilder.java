package by.epam.java.training.xml.parser.dom;

import by.epam.java.training.assanoooovi4k.xml.entity.*;
import by.epam.java.training.xml.entity.*;
import by.epam.java.training.xml.exception.MethodNotSupportedException;
import by.epam.java.training.xml.parser.AbstractBuilder;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomBuilder extends AbstractBuilder {
    private static final Logger logger = LogManager.getLogger(DomBuilder.class);

    private DocumentBuilder docBuilder;

    public DomBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.log(Level.ERROR, "Parser configuration exception.", e);
        }
    }


    @Override
    public void buildListOfPapers(String filePath) {
        Document doc;

        try {
            doc = docBuilder.parse(filePath);
            Element root = doc.getDocumentElement();

            NodeList newspapersList = root.getElementsByTagName(PaperEnum.NEWSPAPER.getValue());
            NodeList journalsList = root.getElementsByTagName(PaperEnum.JOURNAL.getValue());
            NodeList bookletsList = root.getElementsByTagName(PaperEnum.BOOKLET.getValue());

            for (int i = 0; i < newspapersList.getLength(); i++) {
                Element newspaperElement = (Element) newspapersList.item(i);
                Paper paper = buildNewspaper(newspaperElement);
                papers.add(paper);
            }

            for (int i = 0; i < journalsList.getLength(); i++) {
                Element journalElement = (Element) journalsList.item(i);
                Paper paper = buildJournal(journalElement);
                papers.add(paper);
            }

            for (int i = 0; i < bookletsList.getLength(); i++) {
                Element bookletElement = (Element) bookletsList.item(i);
                Paper paper = buildBooklet(bookletElement);
                papers.add(paper);
            }
        } catch (SAXException e) {
            logger.log(Level.ERROR, "SAX exception.", e);
        } catch (IOException e) {
            logger.log(Level.FATAL, "File not found. Check path to file: " + filePath, e);
            throw new RuntimeException("File not found. Check path to file.", e);
        }
    }

    private Paper buildNewspaper(Element newspaperElement) {
        Paper paper = new Newspaper();
        paper = buildSamePart(paper, newspaperElement);

        NodeList indexList = newspaperElement.getElementsByTagName(PaperEnum.SUBSCRIPTION_INDEX.getValue());
        NodeList typeList = newspaperElement.getElementsByTagName(PaperEnum.NEWSPAPER_TYPE.getValue());

        try {
            paper.setSubscriptionIndex(Integer.parseInt(indexList.item(0).getTextContent()));
            String newspaperType = typeList.item(0).getTextContent();
            if (newspaperType != null) {
                paper.setNewspaperType(NewspaperType.findByValue(newspaperType));
            }
        } catch (MethodNotSupportedException e) {
            logger.log(Level.ERROR, "Method not supported exception.", e);
        }

        return paper;
    }

    private Paper buildJournal(Element journalElement) {
        Paper paper = new Journal();
        paper = buildSamePart(paper, journalElement);

        NodeList indexList = journalElement.getElementsByTagName(PaperEnum.SUBSCRIPTION_INDEX.getValue());
        NodeList typeList = journalElement.getElementsByTagName(PaperEnum.JOURNAL_TYPE.getValue());

        try {
            paper.setSubscriptionIndex(Integer.parseInt(indexList.item(0).getTextContent()));
            String journalType = typeList.item(0).getTextContent();
            if (journalType != null) {
                paper.setJournalType(JournalType.findByValue(journalType));
            }
        } catch (MethodNotSupportedException e) {
            logger.log(Level.ERROR, "Method not supported exception.", e);
        }

        return paper;
    }

    private Paper buildBooklet(Element bookletElement) {
        Paper paper = new Booklet();
        paper = buildSamePart(paper, bookletElement);

        NodeList nameOfCompanyList = bookletElement.getElementsByTagName(PaperEnum.NAME_OF_COMPANY.getValue());
        NodeList typeList = bookletElement.getElementsByTagName(PaperEnum.BOOKLET_TYPE.getValue());

        try {
            paper.setNameOfCompany(nameOfCompanyList.item(0).getTextContent());
            String bookletType = typeList.item(0).getTextContent();
            if (bookletType != null) {
                paper.setBookletType(BookletType.findByValue(bookletType));
            }
        } catch (MethodNotSupportedException e) {
            logger.log(Level.ERROR, "Method not supported exception.", e);
        }

        return paper;
    }

    private Paper buildSamePart(Paper paper, Element element) {
        paper.setId(Long.parseLong(element.getAttribute(PaperEnum.ID.getValue())));
        paper.setTitle(element.getAttribute(PaperEnum.TITLE.getValue()));

        NodeList monthlyList = element.getElementsByTagName(PaperEnum.MONTHLY.getValue());
        NodeList colorList = element.getElementsByTagName(PaperEnum.COLORED.getValue());
        NodeList volumeList = element.getElementsByTagName(PaperEnum.VOLUME.getValue());
        NodeList glossyList = element.getElementsByTagName(PaperEnum.GLOSSY.getValue());

        paper.setMonthly(Boolean.parseBoolean(monthlyList.item(0).getTextContent()));
        paper.setColored(Boolean.parseBoolean(colorList.item(0).getTextContent()));
        paper.setVolume(Integer.parseInt(volumeList.item(0).getTextContent()));
        paper.setGlossy(Boolean.parseBoolean(glossyList.item(0).getTextContent()));

        return paper;
    }
}
