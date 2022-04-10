import by.epam.java.training.xml.entity.Paper;
import by.epam.java.training.xml.parser.dom.DomBuilder;
import by.epam.java.training.xml.parser.sax.SaxBuilder;
import by.epam.java.training.xml.parser.stax.StaxBuilder;
import com.beust.jcommander.ParameterException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestBuilder {
    @Test
    public void testOnValidFilePath() throws  ParameterException {
        SaxBuilder saxBuilder = new SaxBuilder();
        saxBuilder.buildListOfPapers("resources/papers.xml");

    }

    @Test (expectedExceptions = RuntimeException.class)
    public void testOnInvalidFilePath() throws ParameterException {
        SaxBuilder saxBuilder = new SaxBuilder();
        saxBuilder.buildListOfPapers("papers.xml");
    }

    @Test ()
    public void testIncorrectXML() {
        List<Paper> papers = new ArrayList<>();
        SaxBuilder saxBuilder = new SaxBuilder();
        saxBuilder.buildListOfPapers("resources/incorrectTest.xml");
        Assert.assertEquals(papers, saxBuilder.getPapers());
    }

    @Test
    public void testCorrectParsingSaxStaxShouldBeEquals() {
        SaxBuilder saxBuilder = new SaxBuilder();
        StaxBuilder staxBuilder = new StaxBuilder();

        saxBuilder.buildListOfPapers("resources/papers.xml");
        staxBuilder.buildListOfPapers("resources/papers.xml");


        Assert.assertEquals(saxBuilder.getPapers(), staxBuilder.getPapers());
    }

    @Test
    public void testCorrectParsingSaxDomShouldBeNotEquals() {
        SaxBuilder saxBuilder = new SaxBuilder();
        DomBuilder domBuilder = new DomBuilder();

        saxBuilder.buildListOfPapers("resources/papers.xml");
        domBuilder.buildListOfPapers("resources/papers.xml");


        Assert.assertNotEquals(saxBuilder.getPapers(), domBuilder.getPapers());
    }
}
