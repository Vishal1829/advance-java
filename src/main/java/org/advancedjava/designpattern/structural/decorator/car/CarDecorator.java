package org.advancedjava.designpattern.structural.decorator.car;

public abstract class CarDecorator implements Car {

    private final Car car;

    public CarDecorator(Car c) {
        this.car = c;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }
}
