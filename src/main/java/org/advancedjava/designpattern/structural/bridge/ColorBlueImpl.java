package org.advancedjava.designpattern.structural.bridge;

public class ColorBlueImpl implements IShapeColor {

    @Override
    public void fillColor() {
        System.out.println("Blue Color");
    }
}
