package org.advancedjava.designpattern.creational.factory;

public class ShapeInstanceFactory {
    public static Shape getShapeInstance(String value) {
        return switch (value) {
            case "Circle" -> new Circle();
            case "Square" -> new Square();
            case "Rectangle" -> new Rectangle();
            default -> null;
        };
    }
}
