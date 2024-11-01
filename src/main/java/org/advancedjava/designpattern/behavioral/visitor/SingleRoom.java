package org.advancedjava.designpattern.behavioral.visitor;

public class SingleRoom implements RoomElement {

    public int roomPrice = 0;

    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }
}
