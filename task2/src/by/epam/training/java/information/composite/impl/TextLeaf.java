package by.epam.training.java.information.composite.impl;

import by.epam.training.java.information.composite.Component;
import by.epam.training.java.assanoooovi4k.information.composite.type.ComponentType;

import java.util.List;

public class TextLeaf implements Component {
    private char leaf;
    private ComponentType componentType;


    public TextLeaf(char leaf, ComponentType componentType) {
        this.leaf = leaf;
        this.componentType = componentType;
    }

    @Override
    public void add(Component component) {
        //exception
    }

    @Override
    public void remove(Component component) {
        //exception
    }

    @Override
    public List<Component> getComponents() {
        return null;
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public String toString() {
        return String.valueOf(leaf);
    }
}
