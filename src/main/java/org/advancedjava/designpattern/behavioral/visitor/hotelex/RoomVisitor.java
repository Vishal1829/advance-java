package org.advancedjava.designpattern.behavioral.visitor.hotelex;

public interface RoomVisitor {
    void visit(SingleRoom singleRoomObj);
    void visit(DoubleRoom doubleRoomObj);
    void visit(DeluxeRoom deluxeRoomObj);
}
