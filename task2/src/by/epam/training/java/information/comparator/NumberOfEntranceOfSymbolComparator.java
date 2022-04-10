package by.epam.training.java.information.comparator;

import by.epam.training.java.information.composite.Component;

import java.util.Comparator;

public class NumberOfEntranceOfSymbolComparator implements Comparator<Component> {
    private char symbol;

    public NumberOfEntranceOfSymbolComparator(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public int compare(Component a, Component b) {
        String literal1 = a.toString();
        String literal2 = b.toString();

        int count1 = (int) literal1.chars().filter(ch -> ch == symbol).count();
        int count2 = (int) literal2.chars().filter(ch -> ch == symbol).count();

        if (count1 - count2 < 0) {
            return 1;
        } else if (count1 - count2 > 0) {
            return -1;
        }
        return 0;
    }
}
