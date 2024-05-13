package org.advancedjava.designpattern.decorator;

public class ExtraCheese extends ToppingDecorator {

    BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 10;
    }
}

/*
extraCheese and mushroom is extending toppingdecorator.
So here extracheese adds some additional feature on the basepizza so here we have a "has-a" relationship.
 */