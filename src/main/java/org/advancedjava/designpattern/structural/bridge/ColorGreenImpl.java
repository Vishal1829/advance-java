package org.advancedjava.designpattern.structural.bridge;

public class ColorGreenImpl implements IShapeColor {

    @Override
    public void fillColor() {
        System.out.println("Green Color");
    }
}
