package org.advancedjava.javaconcepts.comparablecomparator;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsSorting {
    public static void main(String[] args) {
        ArrayList<String> wordsList = new ArrayList<>();
        wordsList.add("banana");
        wordsList.add("apple");
        wordsList.add("cherry");
        wordsList.add("date");
        System.out.println("Original list: " + wordsList);

        Collections.sort(wordsList);
        System.out.println("Sorted list: " + wordsList);
    }
}
/*
String implements Comparable interface so we have an override method compareTo in string and
it will sort the strings in alphabetical order.
 */
