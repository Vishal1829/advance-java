package org.advancedjava.designpattern.structural.decorator.coffee;

public class WithSugar extends CoffeeDecorator {

    public WithSugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", with sugar";
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost() + 0.3;
    }
}
