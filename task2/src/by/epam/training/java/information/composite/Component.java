package by.epam.training.java.information.composite;

import by.epam.training.java.assanoooovi4k.information.composite.type.ComponentType;

import java.util.List;

public interface Component {
    void add(Component component);

    void remove(Component component);

    List<Component> getComponents();

    ComponentType getComponentType();

    String toString();
}
