package by.epam.java.training.xml.parser;

import by.epam.java.training.xml.entity.Paper;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBuilder {
    protected List<Paper> papers;

    public AbstractBuilder() {
        papers = new ArrayList<>();
    }

    public List<Paper> getPapers() {
        return papers;
    }

    abstract public void buildListOfPapers(String filePath);
}
