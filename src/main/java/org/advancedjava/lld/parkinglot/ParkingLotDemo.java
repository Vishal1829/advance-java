package org.advancedjava.lld.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// ParkingLotDemo as Invoker
public class ParkingLotDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        ParkingLot parkingLot = new ParkingLot(size);

        // Initialize ParkingLot
        System.out.println("Enter the size of parking lot: ");
        int size = sc.nextInt();
        // Prompt for parking strategy
        System.out.println("Enter the parking strategy (nearest/furthest): ");
        String strategyType = sc.next();
        // Create parking strategy using factory
        ParkingStrategy strategy = ParkingStrategyFactory.getParkingStrategy(strategyType);
//        ParkingStrategy nearestStrategy = new NearestSlotStrategy();
        // Create the ParkingLot instance using the strategy
        ParkingLot parkingLot = ParkingLot.getInstance(size, strategy);

        // Command map
        Map<Integer, Command> commandMap = new HashMap<>();
        commandMap.put(1, new ParkCarCommand(parkingLot, sc));
        commandMap.put(2, new EmptySlotCommand(parkingLot, sc));
        commandMap.put(3, new GetRegistrationNumbersByColorCommand(parkingLot, sc));
        commandMap.put(4, new GetSlotByRegistrationNumberCommand(parkingLot, sc));
        commandMap.put(5, new GetSlotNumbersByColorCommand(parkingLot, sc));
        commandMap.put(6, new ExitCommand());

        // Main loop
        while(true) {
            System.out.println("1. Park a Car");
            System.out.println("2. Empty a slot");
            System.out.println("3. Get all registration numbers of a particular car color");
            System.out.println("4. Get Slot number from a registration number");
            System.out.println("5. Get all slot numbers of a particular car color");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            Command command = commandMap.getOrDefault(choice, () -> System.out.println("Invalid choice"));
            command.execute();

//            switch(choice) {
//                case 1:
//                    System.out.println("Enter the car details: ");
//                    String registrationNumber = sc.next();
//                    String color = sc.next();
//                    System.out.println(parkingLot.park(new Car(registrationNumber, Color.valueOf(color))));
//                    break;
//                case 2:
//                    System.out.println("Enter the slot number: ");
//                    int slot = sc.nextInt();
//                    System.out.println(parkingLot.unPark(slot));
//                    break;
//                case 3:
//                    System.out.println("Enter the car color: ");
//                    String carColor = sc.next();
//                    parkingLot.getRegistrationNumbersByColor(Color.valueOf(carColor)).forEach(System.out::println);
//                    break;
//                case 4:
//                    System.out.println("Enter the car registration number: ");
//                    String regNo = sc.next();
//                    System.out.println("Slot no : " + parkingLot.getSlotNumberByRegNo(regNo));
//                    break;
//                case 5:
//                    System.out.println("Enter the car color: ");
//                    String carColor1 = sc.next();
//                    parkingLot.getSlotNumbersByColor(Color.valueOf(carColor1)).forEach(System.out::println);
//                    break;
//                case 6:
//                    System.out.println("Exiting the program..........");
//                    return;
//                default:
//                    System.out.println("Invalid choice");
//            }
        }
    }
}
/*
Problem Statement: (Design a Parking System)

I own a parking lot that can hold upto ‘n’ cars at any given point in time. Each slot is given a number
starting at increasing with increasing distance from the entry point in steps of one. I want to create an
automated ticketing system that allows my customers to use my parking lot without human intervention.

When a car enters my parking lot, I want to have a ticket issued to the driver. The ticket issuing process
includes us documenting the registration number(number plate) and the colour of the car and allocating an
available parking slot to the car before actually handing over a ticket to the driver (we assume that our
customers are nice enough to always park in the slots allocated to them). The customer should be allocated
a parking slot which is nearest to the entry. At the exit the customer returns the ticket which then marks
the slot they were using as being available.

Due to government regulation, the system should provide me the ability to find out:
1. Registration numbers of all cars of a particular colour.
2. Slot number in which a car with a given registration number is placed.
3. Slot numbers of all slots where a car of a particular colour is parked.
 */

/*
In this solution, we've incorporated the following design patterns:
1. Singleton Pattern
Where: ParkingLot class.
Purpose: Ensures only one instance of the ParkingLot exists across the application, using double-checked
locking for thread safety and lazy initialization.

2. Command Pattern
Where: Handling user commands in ParkingLotDemo (e.g., ParkCarCommand, EmptySlotCommand).
Purpose: Encapsulates commands as objects, enabling extensibility, reusability, and separation of command
execution logic from user input handling.

3. Strategy Pattern
Where: Parking strategies (ParkingStrategy interface and NearestSlotStrategy implementation).
Purpose: Allows dynamic selection of parking allocation strategies without modifying the core ParkingLot class.

4. Factory Method Pattern
Where: In potential creation of different parking strategies (e.g., NearestSlotStrategy).
Purpose: Provides an interface to create objects (parking strategies) without specifying their concrete classes.

5. Data Access Object (DAO) Pattern (implicit)
Where: SlotManager class.
Purpose: Abstracts the persistence layer, handling the storage and retrieval of Slot data.
While we aren't persisting to a database in this example, SlotManager acts like a DAO in managing in-memory slots.
 */