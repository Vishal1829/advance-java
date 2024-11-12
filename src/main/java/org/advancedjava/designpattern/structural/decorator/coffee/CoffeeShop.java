package org.advancedjava.designpattern.structural.decorator.coffee;

public class CoffeeShop {
    public static void main(String[] args) {
        Coffee myCoffee = new SimpleCoffee();
        System.out.println(myCoffee.getDescription() + " $" + myCoffee.cost());

        myCoffee = new WithMilk(myCoffee);
        System.out.println(myCoffee.getDescription() + " $" + myCoffee.cost());

        myCoffee = new WithSugar(myCoffee);
        System.out.println(myCoffee.getDescription() + " $" + myCoffee.cost());

        System.out.println();
        Coffee myCoffee1 = new WithSugar(new WithMilk(new SimpleCoffee()));
        System.out.println(myCoffee1.getDescription() + " $" + myCoffee1.cost());
    }
}
/*
The Decorator Design Pattern is a structural design pattern that allows you to add new behaviors or functionalities
to objects dynamically. It’s an alternative to subclassing for extending functionality.

Concept
Think of the Decorator pattern like decorating a Christmas tree. You start with a simple tree, and then you add
decorations like lights, tinsel, and ornaments. Each decoration adds something to the tree, but the tree itself
doesn’t change; it’s just adorned with new features.

In programming, the Decorator pattern works similarly. You start with a basic object and then add “decorations” to it
without changing the object’s code. Each decorator adds some behavior or state to the original object.

Implementation
The Decorator pattern uses composition instead of inheritance. It involves a set of decorator classes that are used
to wrap concrete components. The decorator classes mirror the type of the components they decorate
(they have the same base type or interface).

Steps:-
Step 1: Define the Component Interface
Step 2: Create Concrete Components
Step 3: Create Decorator Abstract Class
Step 4: Create Concrete Decorators
Step 5: Using the Decorator
 */
