package org.advancedjava.javaconcepts.comparablecomparator;

import java.util.Comparator;

/*
Comparator Interface
The Comparator interface in Java provides a way to define multiple ways to compare and sort objects.
Unlike the Comparable interface, which allows only a single natural ordering, Comparator is designed
to offer flexibility by allowing multiple sorting strategies. This makes it particularly useful
for scenarios where objects need to be sorted in different ways.

The Comparator interface defines a single method, compare(), which compares two objects and returns:

- A negative integer if the first object is less than the second object.
- Zero if the first object is equal to the second object.
- A positive integer if the first object is greater than the second object.
This method provides a way to define custom ordering for objects without modifying the class itself.
*/
public class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}
