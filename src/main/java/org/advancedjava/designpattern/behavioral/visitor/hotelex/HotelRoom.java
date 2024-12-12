package org.advancedjava.designpattern.behavioral.visitor.hotelex;


//What's the problem with the below class?
public class HotelRoom {

    public void getRoomPrice() {
        //price computation logic
    }

    public void initiateRoomMaintenance() {
        //start room maintenance
    }

    public void reserveRoom() {
        //perform operation to reserve the room
    }

    //many more operations can come over the time
}
/*
Visitor Pattern: Allows adding new operations to existing classes without modifying them and
encourage OPEN/CLOSED principle.
 */