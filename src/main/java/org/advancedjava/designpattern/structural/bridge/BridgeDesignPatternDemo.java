package org.advancedjava.designpattern.structural.bridge;

public class BridgeDesignPatternDemo {
    public static void main(String[] args) {

        Shape s1=new Rectangle(new ColorRedImpl());
        Shape s2=new Rectangle(new ColorBlueImpl());
        Shape s3=new Rectangle(new ColorGreenImpl());

        s1.applyColor();
        s2.applyColor();
        s3.applyColor();

        Shape s4=new Circle(new ColorRedImpl());
        Shape s5=new Circle(new ColorBlueImpl());
        Shape s6=new Circle(new ColorGreenImpl());

        s4.applyColor();
        s5.applyColor();
        s6.applyColor();

    }
}
/*
Bridge Design Pattern:
Decouples an abstraction from its implementation so that the two can vary independently.

It states bridge pattern decouples the abstract elements of a class from its implementation by providing a
bridge structure between them. Both types of classes can be altered structurally without affecting each other.
It follows the principle which says “prefer composition over inheritance”.

So for the above example if we do it without bridge pattern then ->
Adding one Color implementation to any shape requires a class addition to each shape type. Think of the scenario
where you have N number of Shape types of N different colors...

https://medium.com/@amritlalsahu5/bridge-design-pattern-9afad7138777
 */