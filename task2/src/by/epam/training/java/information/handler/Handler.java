package by.epam.training.java.information.handler;

import by.epam.training.java.information.composite.Component;

import java.util.List;

public interface Handler {
    List<String> parse(String data, Component component);

    void chain(String data, Component component);
}
