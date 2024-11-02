package org.advancedjava.designpattern.structural.bridge;

public class ColorRedImpl implements IShapeColor {

    @Override
    public void fillColor() {
        System.out.println("Red Color");
    }
}
