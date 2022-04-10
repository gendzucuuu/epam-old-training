package by.epam.training.java.information.handler.parser;

import by.epam.training.java.information.composite.Component;
import by.epam.training.java.assanoooovi4k.information.composite.type.ComponentType;
import by.epam.training.java.information.composite.impl.TextComposite;
import by.epam.training.java.information.handler.Handler;
import by.epam.training.java.information.handler.impl.CompositeHandler;
import by.epam.training.java.information.handler.impl.LeafHandler;
import by.epam.training.java.information.handler.impl.LexemeHandler;

public class Parser {
    private Handler symbolHandler;
    private Handler lexemeHandler;
    private Handler lexemeGeneralHandler;
    private Handler sentenceHandler;
    private Handler paragraphHandler;
    private Handler textHandler;
    private Component textComposite;

    public Parser() {
        symbolHandler = new LeafHandler();
        lexemeHandler = new LexemeHandler(symbolHandler);
        lexemeGeneralHandler = new CompositeHandler(lexemeHandler, ComponentType.LEXEME);
        sentenceHandler = new CompositeHandler(lexemeGeneralHandler, ComponentType.SENTENCE);
        paragraphHandler = new CompositeHandler(sentenceHandler, ComponentType.PARAGRAPH);
        textHandler = new CompositeHandler(paragraphHandler, ComponentType.TEXT);
        textComposite = new TextComposite(ComponentType.TEXT);
    }

    public Component parse(String data) {
        textHandler.chain(data, textComposite);
        return textComposite;
    }
}
