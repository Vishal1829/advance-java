package org.advancedjava.javaconcepts.comparablecomparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomClassSorting {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Alice", 30, 65.5),
                new Person("Bob", 25, 75.0),
                new Person("Charlie", 35, 80.0)
        ));
        System.out.println("Original people list: " + people);

        //we will get compilation error as java built-in sort methods doesn't know how to
        //compare user-defined objects.
//        Collections.sort(people);
        System.out.println("Sorted people list: " + people);
    }
}
