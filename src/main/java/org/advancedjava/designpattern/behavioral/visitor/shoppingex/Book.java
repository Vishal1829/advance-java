package org.advancedjava.designpattern.behavioral.visitor.shoppingex;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
// Concrete Element - Book
public class Book implements ItemElement {
    private String title;
    private double price;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
