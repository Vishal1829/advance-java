package org.advancedjava.designpattern.behavioral.visitor;

public interface RoomElement {
    void accept(RoomVisitor visitor);
}
