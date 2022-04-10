package by.epam.training.java.information.composite.impl;

import by.epam.training.java.information.composite.Component;
import by.epam.training.java.assanoooovi4k.information.composite.type.ComponentType;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {
    private static final String TABULATION = "\t";
    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";

    private List<Component> components;
    private ComponentType componentType;


    public TextComposite(ComponentType componentType) {
        components = new ArrayList<Component>();
        this.componentType = componentType;
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Component component : components) {
            if (component.getComponentType() == ComponentType.PARAGRAPH) {
                sb.append(NEW_LINE).append(TABULATION);
            }
            if (component.getComponentType() == ComponentType.LEXEME) {
                sb.append(SPACE);
            }

            sb.append(component.toString());

        }
        return sb.toString();
    }
}
