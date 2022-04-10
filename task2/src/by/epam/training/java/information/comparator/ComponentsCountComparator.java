package by.epam.training.java.information.comparator;

import by.epam.training.java.information.composite.Component;

import java.util.Comparator;

public class ComponentsCountComparator implements Comparator<Component> {

    public ComponentsCountComparator() {

    }

    @Override
    public int compare(Component a, Component b) {
        int countOfComponents1 = a.getComponents().size();
        int countOfComponents2 = b.getComponents().size();

        if (countOfComponents1 - countOfComponents2 < 0) {
            return 1;
        }
        else if (countOfComponents1 - countOfComponents2 > 0) {
            return -1;
        }
        return 0;
    }
}
