package org.advancedjava.designpattern.structural.decorator.car;

public class SportsDecorator extends CarDecorator {

    public SportsDecorator(Car c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print(" with Sports mode");
    }
}
