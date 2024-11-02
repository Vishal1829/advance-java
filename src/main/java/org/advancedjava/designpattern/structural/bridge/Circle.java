package org.advancedjava.designpattern.structural.bridge;

public class Circle extends Shape {

    public Circle(IShapeColor color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Circle filled with ");
        color.fillColor();
    }
}
