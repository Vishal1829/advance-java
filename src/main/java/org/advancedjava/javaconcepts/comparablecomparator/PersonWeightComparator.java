package org.advancedjava.javaconcepts.comparablecomparator;

import java.util.Comparator;

public class PersonWeightComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return (int) (p1.getWeight() - p2.getWeight());
    }
}
