package org.advancedjava.javaconcepts.comparablecomparator;

/*
Comparable Interface
Java provides a Comparable interface to define a natural ordering for objects of a user-defined class.
By implementing the Comparable interface, a class can provide a single natural ordering that can be
used to sort its instances. This is particularly useful when you need a default way to compare and sort objects.

The Comparable interface contains a single method, compareTo(), which compares the current object with
the specified object for order. The method returns:

- A negative integer if the current object is less than the specified object.
- Zero if the current object is equal to the specified object.
- A positive integer if the current object is greater than the specified object.
*/
public class PersonV2 implements Comparable<PersonV2> {
    String name;
    int age;
    double weight;

    public PersonV2(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PersonV2 [name=" + name + ", age=" + age + ", weight=" + weight + " kgs]";
    }

    @Override
    public int compareTo(PersonV2 other) {
        return this.age - other.age;
    }
}
