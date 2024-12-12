package org.advancedjava.designpattern.behavioral.visitor.shoppingex;

// Element interface
public interface ItemElement {
    void accept(Visitor visitor);
}
