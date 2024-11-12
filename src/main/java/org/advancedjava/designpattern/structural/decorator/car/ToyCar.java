package org.advancedjava.designpattern.structural.decorator.car;

public class ToyCar implements Car {

    @Override
    public void assemble() {
        System.out.print("Toy Car");
    }
}
