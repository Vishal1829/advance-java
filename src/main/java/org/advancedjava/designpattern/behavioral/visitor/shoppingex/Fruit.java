package org.advancedjava.designpattern.behavioral.visitor.shoppingex;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
// Concrete Element - Fruit
public class Fruit implements ItemElement {
    private String name;
    private double weight;
    private double price;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
