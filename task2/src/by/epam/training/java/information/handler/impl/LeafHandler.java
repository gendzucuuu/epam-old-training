package by.epam.training.java.information.handler.impl;

import by.epam.training.java.information.composite.Component;
import by.epam.training.java.assanoooovi4k.information.composite.type.ComponentType;
import by.epam.training.java.information.composite.impl.TextLeaf;
import by.epam.training.java.information.handler.Handler;

import java.util.List;

public class LeafHandler implements Handler {

    @Override
    public List<String> parse(String data, Component component) {
        char[] charsOfData = data.toCharArray();
        for (char c : charsOfData) {
            Component symbol = new TextLeaf(c, ComponentType.SYMBOL);
            component.add(symbol);
        }
        return null;

    }

    @Override
    public void chain(String dataToParse, Component component) {
        parse(dataToParse, component);

    }

}
