package org.advancedjava.designpattern.behavioral.visitor.shoppingex;

// Visitor interface
public interface Visitor {
    void visit(Book book);
    void visit(Fruit fruit);
}
