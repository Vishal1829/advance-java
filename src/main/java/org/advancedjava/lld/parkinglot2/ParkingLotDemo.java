package org.advancedjava.lld.parkinglot2;

import java.util.*;

public class ParkingLotDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLotRegistry parkingLotRegistry = ParkingLotRegistry.getInstance();
        CommandFactory commandFactory = CommandFactory.getInstance(parkingLotRegistry);
        CommandInvoker invoker = new CommandInvoker();

        while (true) {
            // Read the entire input line
            String input = scanner.nextLine().trim();
            // Split the input line into tokens based on spaces
            String[] tokens = input.split(" ");
            String commandType = tokens[0];

            switch (commandType) {
                case "create_parking_lot":
                    if (tokens.length >= 4) {
                        String parkingLotId = tokens[1];
                        int noOfFloors = Integer.parseInt(tokens[2]);

                        int[] slotsPerFloor;
                        SlotDistributionStrategy distributionStrategy;
                        if (tokens.length == 4) {
                            // create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>
                            // Uniform slots for all floors with DefaultSlotDistributionStrategy
                            int numSlots = Integer.parseInt(tokens[3]);
                            slotsPerFloor = new int[noOfFloors];
                            Arrays.fill(slotsPerFloor, numSlots);
                            distributionStrategy = new DefaultSlotDistributionStrategy();
                        } else if (tokens.length == noOfFloors + 3) {
                            // create_parking_lot <parking_lot_id> <no_of_floors> <slots_on_floor_1> <slots_on_floor_2> ...
                            // Different slots for all floors with DefaultSlotDistributionStrategy
                            // Custom slots per floor
                            slotsPerFloor = new int[noOfFloors];
                            for (int i = 0; i < noOfFloors; i++) {
                                slotsPerFloor[i] = Integer.parseInt(tokens[3 + i]);
                            }
                            distributionStrategy = new DefaultSlotDistributionStrategy();
                        } else if (tokens.length == noOfFloors * 3 + 3) {
                            /*
                                create_parking_lot <parking_lot_id> <no_of_floors> <truck_slots_floor_1> <bike_slots_floor_1>
                                <car_slots_floor_1> <truck_slots_floor_2> <bike_slots_floor_2> <car_slots_floor_2> ...
                             */
                            // Different slots for all floors with CustomSlotDistributionStrategy
                            // Custom slot distribution per floor
                            slotsPerFloor = new int[noOfFloors];
                            Map<Integer, Map<VehicleType, Integer>> perFloorDistribution = new HashMap<>();
                            for (int i = 0; i < noOfFloors; i++) {
                                int truckSlot = Integer.parseInt(tokens[3 + i * 3]);
                                int bikeSlot = Integer.parseInt(tokens[4 + i * 3]);
                                int carSlot = Integer.parseInt(tokens[5 + i * 3]);
                                Map<VehicleType, Integer> customDistribution = new EnumMap<>(VehicleType.class);
                                customDistribution.put(VehicleType.TRUCK, truckSlot);
                                customDistribution.put(VehicleType.BIKE, bikeSlot);
                                customDistribution.put(VehicleType.CAR, carSlot);
                                slotsPerFloor[i] = truckSlot + bikeSlot + carSlot;
                                perFloorDistribution.put(i+1, customDistribution);
                                System.out.println(slotsPerFloor[i] + " for floor " + i + " - " + truckSlot + "," + bikeSlot + "," + carSlot);
                            }
                            distributionStrategy = new CustomSlotDistributionStrategy(perFloorDistribution);
                        } else {
                            System.out.println("Invalid command format for create_parking_lot.");
                            break;
                        }
                        invoker.executeCommand(commandFactory.createCreateParkingLotCommand(parkingLotId,
                                noOfFloors, slotsPerFloor, distributionStrategy));
                    }
                    else {
                        System.out.println("Invalid command format for create_parking_lot.");
                    }
                    break;
                case "park_vehicle":
                    if (tokens.length == 5) {
                        String parkingLotId = tokens[1];
                        String vehicleType = tokens[2];
                        String regNo = tokens[3];
                        String color = tokens[4];
                        invoker.executeCommand(commandFactory.createParkVehicleCommand(parkingLotId, vehicleType, regNo, color));
                    } else {
                        System.out.println("Invalid command format for park_vehicle.");
                    }
                    break;
                case "unpark_vehicle":
                    if (tokens.length == 3) {
                        String parkingLotId = tokens[1];
                        String ticketId = tokens[2];
                        invoker.executeCommand(commandFactory.createUnparkVehicleCommand(parkingLotId, ticketId));
                    } else {
                        System.out.println("Invalid command format for unpark_vehicle.");
                    }
                    break;
                case "display":
                    if (tokens.length == 4) {
                        String parkingLotId = tokens[1];
                        String displayType = tokens[2];
                        String vehicleType = tokens[3];
                        invoker.executeCommand(commandFactory.createDisplayCommand(parkingLotId, displayType, vehicleType));
                    } else {
                        System.out.println("Invalid command format for display.");
                    }
                    break;
                case "exit":
                    invoker.executeCommand(commandFactory.createExitCommand());
                default:
                    System.out.println("Unknown command: " + commandType);
            }

        }

    }
}
/*
Commands:
1. create parking-lot
create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>
create_parking_lot <parking_lot_id> <no_of_floors> <slots_on_floor_1> <slots_on_floor_2> ...
create_parking_lot <parking_lot_id> <no_of_floors> <truck_slots_floor_1> <bike_slots_floor_1> <car_slots_floor_1> <truck_slots_floor_2> <bike_slots_floor_2> <car_slots_floor_2> ...

2. park vehicle
park_vehicle <parking_lot_id> <vehicle_type> <registration_number> <colour>

3. un-park vehicle
unpark_vehicle <parking_lot_id> <ticket_id>

4. display
display <parking_lot_id> free_count <vehicle_type>
display <parking_lot_id> free_slots <vehicle_type>
display <parking_lot_id> occupied_slots <vehicle_type>
 */

/*
https://workat.tech/machine-coding/practice/design-parking-lot-qm6hwq4wkhp8
The solution provided is complete LLD of ParkingLot including the optional requirements also adhering design
principles and patterns.

Problem Statement
A parking lot is an area where cars can be parked for a certain amount of time. A parking lot can have
multiple floors with each floor having a different number of slots and each slot being suitable for
different types of vehicles.

For this problem, we have to design the next generation parking lot system which can manage a parking lot
without any human intervention.

Requirements
Create a command-line application for the parking lot system with the following requirements.
The functions that the parking lot system can do:
Create the parking lot.
Add floors to the parking lot.
Add a parking lot slot to any of the floors.
Given a vehicle, it finds the first available slot, books it, creates a ticket, parks the vehicle, and finally returns the ticket.
Unparks a vehicle given the ticket id.
Displays the number of free slots per floor for a specific vehicle type.
Displays all the free slots per floor for a specific vehicle type.
Displays all the occupied slots per floor for a specific vehicle type.
Details about the Vehicles:
Every vehicle will have a type, registration number, and color.
Different Types of Vehicles:
Car
Bike
Truck
Details about the Parking Slots:
Each type of slot can park a specific type of vehicle.
No other vehicle should be allowed by the system.
Finding the first available slot should be based on:
The slot should be of the same type as the vehicle.
The slot should be on the lowest possible floor in the parking lot.
The slot should have the lowest possible slot number on the floor.
Numbered serially from 1 to n for each floor where n is the number of parking slots on that floor.
Details about the Parking Lot Floors:
Numbered serially from 1 to n where n is the number of floors.
Might contain one or more parking lot slots of different types.
We will assume that the first slot on each floor will be for a truck, the next 2 for bikes, and all the other slots for cars.
Details about the Tickets:
The ticket id would be of the following format:
<parking_lot_id>_<floor_no>_<slot_no>
Example: PR1234_2_5 (denotes 5th slot of 2nd floor of parking lot PR1234)
We can assume that there will only be 1 parking lot. The ID of that parking lot is PR1234.

Expectations
Make sure that you have a working and demonstrable code
Make sure that the code is functionally correct
Code should be modular and readable
Separation of concern should be addressed
Please do not write everything in a single file (if not coding in C/C++)
Code should easily accommodate new requirements and minimal changes
There should be a main method from where the code could be easily testable
[Optional] Write unit tests, if possible
No need to create a GUI
Optional Requirements
Please do these only if you’ve time left. You can write your code such that these could be accommodated without changing your code much.

Keep the code extensible to add additional types of vehicles and slot types.
Keep the code extensible to allow a different strategy of finding the first available slot.
Keep the code extensible to allow any other type of command.
Keep the code extensible to allow multiple parking lots. You can assume that the input/output format can be changed for that.
Keep the system thread-safe to allow concurrent requests.
 */
