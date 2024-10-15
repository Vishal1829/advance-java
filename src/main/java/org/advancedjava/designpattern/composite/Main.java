package org.advancedjava.designpattern.composite;

public class Main {
    public static void main(String[] args) {
        Housing building = new Housing("123 Street");
        Housing floor1 = new Housing("123 Street - First Floor");
        int firstFloor = building.addStructure(floor1);

        Room washroom1m = new Room("1F Men's Washroom");
        Room washroom1w = new Room("1F Women's Washroom");
        Room common1 = new Room("1F Common Area");

        int firstMens = floor1.addStructure(washroom1m);
        int firstWomans = floor1.addStructure(washroom1w);
        int firstCommon = floor1.addStructure(common1);

        building.enter(); // Enter the building
        Housing currentFloor = (Housing) building.getStructure(firstFloor);
        currentFloor.enter(); // Walk into the first floor
        Room currentRoom = (Room) currentFloor.getStructure(firstMens);
        currentRoom.enter(); // Walk into the men's room
        currentRoom = (Room) currentFloor.getStructure(firstCommon);
        currentRoom.enter(); // Walk into the common room

    }
}
/*
Steps for Composite design pattern:-
1. Design the interface that defines the overall type
2. Implement the composite class
3. Implement the leaf class
 */
