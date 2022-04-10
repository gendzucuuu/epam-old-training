package by.epam.training.java.information.handler.impl;

import by.epam.training.java.information.calculator.BitwiseExpressionCalculator;
import by.epam.training.java.information.composite.Component;
import by.epam.training.java.information.composite.impl.TextLeaf;
import by.epam.training.java.assanoooovi4k.information.composite.type.ComponentType;
import by.epam.training.java.information.composite.impl.TextComposite;
import by.epam.training.java.information.handler.Handler;
import by.epam.training.java.information.interpreter.Context;
import by.epam.training.java.information.interpreter.Interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeHandler implements Handler {
    private Handler successor = DefaultHandleRequest.getHandleRequest();

    public LexemeHandler(Handler successor) {
        this.successor = successor;

    }

    public LexemeHandler() {
    }

    public void setNextSuccessor(Handler successor) {
        this.successor = successor;
    }


    @Override
    public List<String> parse(String data, Component component) {
        List<String> componentList = new ArrayList<>();
        Pattern pattern = Pattern.compile(component.getComponentType().getRegex());
        Matcher matcher = pattern.matcher(data);

        if (matcher.find()){
            String content = matcher.group();
            if (isBitwiseExpression(content)){
                Component expressionComposite = new TextComposite(ComponentType.EXPRESSION);
                component.add(expressionComposite);
                content = calculateBitwiseExpression(content);
            }
            else if(isPunctuationMark(content)){
                Component markComposite = new TextLeaf(content.charAt(0), ComponentType.PUNCTUATION_MARK);
                component.add(markComposite);
            }
            else {
                Component wordComposite = new TextComposite(ComponentType.WORD);
                component.add(wordComposite);
            }

            componentList.add(content);
        }

        return componentList;


    }

    @Override
    public void chain(String data, Component component) {
        List<String> componentContents = parse(data, component);
        Iterator <String> contentIterator = componentContents.iterator();
        List <Component> nestedComposites = component.getComponents();
        Iterator <Component> compositesIterator = nestedComposites.iterator();
        while (contentIterator.hasNext()){
            String componentContent = contentIterator.next();
            Component nestedComposite = compositesIterator.next();
            successor.chain(componentContent, nestedComposite);
        }

    }

    private String calculateBitwiseExpression(String data) {
        Pattern bitwiseExpression = Pattern.compile(ComponentType.EXPRESSION.getRegex());
        Matcher bitwiseMatcher = bitwiseExpression.matcher(data);

        while (bitwiseMatcher.find()) {
            Context context = new Context();
            List<Interpreter> expressions = BitwiseExpressionCalculator.calculate(bitwiseMatcher.group());

            for (Interpreter expression : expressions) {
                expression.interpret(context);
            }

            Long number = context.popValue();
            data = data.replaceFirst(ComponentType.EXPRESSION.getRegex(), String.valueOf(number));
        }

        return data;
    }

    private boolean isPunctuationMark(String data) {
        Pattern punctuationMark = Pattern.compile(ComponentType.PUNCTUATION_MARK.getRegex());
        Matcher matcher = punctuationMark.matcher(data);
        return matcher.matches();
    }

    private boolean isBitwiseExpression(String data) {
        Pattern bitwiseExpression = Pattern.compile(ComponentType.EXPRESSION.getRegex());
        Matcher matcher = bitwiseExpression.matcher(data);
        return matcher.matches();
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
