package by.epam.training.java.information.handler.impl;

import by.epam.training.java.information.composite.Component;
import by.epam.training.java.assanoooovi4k.information.composite.type.ComponentType;
import by.epam.training.java.information.composite.impl.TextComposite;
import by.epam.training.java.information.handler.Handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CompositeHandler implements Handler {
    private Handler successor = DefaultHandleRequest.getHandleRequest();;
    private ComponentType componentType;

    public CompositeHandler(Handler successor, ComponentType componentType) {
        this.successor = successor;
        this.componentType = componentType;

    }

    public CompositeHandler(ComponentType componentType) {
        this.componentType = componentType;
    }

    public void setNextSuccessor(Handler successor) {
        this.successor = successor;
    }

    @Override
    public List<String> parse(String data, Component component) {
        Pattern pattern = Pattern.compile(componentType.getRegex());
        Matcher matcher = pattern.matcher(data);

        String content;
        List<String> componentList = new ArrayList<>();
        while (matcher.find()){
            content = matcher.group();
            componentList.add(content);
            Component newComposite = new TextComposite(componentType);
            component.add(newComposite);
        }
        return componentList;
    }

    @Override
    public void chain(String data, Component component) {
        List<String> componentList = parse(data, component);
        Iterator<String> componentIterator = componentList.iterator();
        List<Component> composites = component.getComponents();
        Iterator<Component> compositesIterator = composites.iterator();
        while (componentIterator.hasNext()){
            String content = componentIterator.next();
            Component composite = compositesIterator.next();
            successor.chain(content, composite);
        }


    }

    private static class DefaultHandleRequest implements Handler {
        private static DefaultHandleRequest handler = new DefaultHandleRequest();

        private DefaultHandleRequest() {

        }


        public static DefaultHandleRequest getHandleRequest() {
            return handler;
        }

        @Override
        public List<String> parse(String data, Component component) {
            return null;
        }


        @Override
        public void chain(String data, Component component) {

        }

    }
}
