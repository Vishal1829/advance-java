package org.advancedjava.designpattern.structural.bridge;

public class Rectangle extends Shape {

    public Rectangle(IShapeColor color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Rectangle filled with ");
        color.fillColor();
    }
}
