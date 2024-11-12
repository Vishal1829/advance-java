package org.advancedjava.designpattern.structural.decorator.car;

public class RealCar implements Car {

    @Override
    public void assemble() {
        System.out.print("Real Car");
    }
}
