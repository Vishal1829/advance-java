package org.advancedjava.designpattern.behavioral.visitor.hotelex;

public interface RoomElement {
    void accept(RoomVisitor visitor);
}
