package org.advancedjava.designpattern.creational.factory;

public class Main {
    public static void main(String[] args) {
        Shape circleObj = ShapeInstanceFactory.getShapeInstance("Circle");
        circleObj.computeArea();
    }
}
/*
Factory Pattern:
It is used when all the object creation and its business logic we need to keep at one place.

Here for the above example:
we have an interface shape which can have many concrete classes and so if the client wants to use any specific
concrete class then he/she has to create its object, now to simplify the object creation here in this case we
have created a factory which will give the instance of a particular concrete class based on input.
 */