package org.advancedjava.designpattern.behavioral.state;

public class Client {
    public static void main(String[] args) {
        Fan fan = new Fan();
        fan.increaseSpeed(); // Turns on low
        fan.increaseSpeed(); // Turns on medium
        fan.increaseSpeed(); // Turns on high
        fan.increaseSpeed(); // Turns off
        fan.increaseSpeed(); // Turns on low
    }
}
/*
https://medium.com/@rajeshvelmani/managing-object-behavior-with-the-state-design-pattern-in-java-c00072e694f9

Key Features of the State Design Pattern:
1. Context: The context represents the object whose behavior changes based on its internal state.
It maintains a reference to the current state object and delegates behavior to it.
2. State: The state interface or abstract class defines the common methods that encapsulate the
behavior associated with a specific state. It typically declares methods for performing operations
based on the state.
3. Concrete States: Concrete state classes implement the state interface or extend the state
abstract class. Each concrete state encapsulates the behavior associated with a specific
state of the context object.
4. Client: The client code interacts with the context object and triggers state transitions based
on certain conditions or events.

 */