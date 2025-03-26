package org.advancedjava.javaconcepts.comparablecomparator;

import java.util.Arrays;

public class PrimitiveSorting {
    public static void main(String[] args) {
        int[] numbers = { 5, 3, 8, 2, 1 };
        System.out.println("Original array: " + Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        char[] characters = { 'o', 'i', 'e', 'u', 'a' };
        System.out.println("Original array: " + Arrays.toString(characters));

        Arrays.sort(characters);
        System.out.println("Sorted array: " + Arrays.toString(characters));
    }
}
