package org.advancedjava.designpattern.structural.decorator.car;

public class PaintDecorator extends CarDecorator{

    public PaintDecorator(Car c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print(" with Painted skin");
    }
}
