package org.advancedjava.designpattern.behavioral.visitor.shoppingex;

// Client
public class VisitorPatternDemo {
    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[]{
                new Book("Design Patterns", 30.00),
                new Fruit("Apple", 2.0, 3.00)
        };

        Visitor visitor = new ShoppingCartVisitor();
        for (ItemElement item : items) {
            item.accept(visitor);
        }
    }
}
/*

What is the Visitor Pattern?
The Visitor Pattern is a behavioral design pattern that allows you to add further operations to objects
without having to modify them. It separates an algorithm from the object structure on which it operates,
allowing you to define new operations without changing the classes of the elements on which it operates.

In Java, the Visitor Pattern is typically used when you have a structure of objects, such as a composite object,
and you want to perform operations on these objects that depend on their concrete classes.

https://medium.com/@alxkm/visitor-pattern-in-java-0be5fa5af5d7

 */
