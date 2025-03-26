package org.advancedjava.javaconcepts.comparablecomparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomClassSortingV3 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Bob", 25, 75.0),
                new Person("Alice", 30, 65.5),
                new Person("Charlie", 35, 80.0)
        ));
        System.out.println("Original people list: " + people);

        Collections.sort(people, new PersonNameComparator());
        System.out.println("Sorted people list by name: " + people);

        Collections.sort(people, new PersonAgeComparator());
        System.out.println("Sorted people list by age: " + people);

        Collections.sort(people, (p1, p2) -> p1.getAge() - p2.getAge());
        System.out.println("Sorted people list by age used lambda directly: " + people);

        Collections.sort(people, new PersonWeightComparator());
        System.out.println("Sorted people list by weight: " + people);
    }
}
