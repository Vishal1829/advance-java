package org.advancedjava.designpattern.behavioral.visitor;

public class Client {
    public static void main(String[] args) {
        RoomElement singleRoomObj = new SingleRoom();
        RoomElement doubleRoomObj = new DoubleRoom();
        RoomElement deluxeRoomObj = new DeluxeRoom();

        //performing an operation on the objects
        RoomVisitor pricingVisitorObj = new RoomPricingVisitor();
        singleRoomObj.accept(pricingVisitorObj);
        System.out.println(((SingleRoom)singleRoomObj).roomPrice);

        doubleRoomObj.accept(pricingVisitorObj);
        System.out.println(((DoubleRoom)doubleRoomObj).roomPrice);

        deluxeRoomObj.accept(pricingVisitorObj);
        System.out.println(((DeluxeRoom)deluxeRoomObj).roomPrice);

        System.out.println();

        //performing another operation on the objects
        RoomVisitor maintenanceVisitorObj = new RoomMaintenanceVisitor();
        singleRoomObj.accept(maintenanceVisitorObj);

        doubleRoomObj.accept(maintenanceVisitorObj);

        deluxeRoomObj.accept(maintenanceVisitorObj);
    }
}
/*
What's the problem with the HotelRoom class?

Visitor Pattern: Allows adding new operations to existing classes without modifying them and
encourage OPEN/CLOSED principle.

Note: check this
https://medium.com/@alxkm/visitor-pattern-in-java-0be5fa5af5d7
 */
