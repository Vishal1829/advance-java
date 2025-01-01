package org.advancedjava.lld.parkinglot2;


import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

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
                        int noOfSlotsPerFloor = Integer.parseInt(tokens[3]);

                        if (noOfSlotsPerFloor < 4) {
                            System.out.println("Please provide slot number greater than or equal to 4..");
                            continue;
                        }
                        SlotDistributionStrategy distributionStrategy;
                        if (tokens.length > 4) {
                            if (Integer.parseInt(tokens[4]) + Integer.parseInt(tokens[5]) +
                                    Integer.parseInt(tokens[6]) != noOfSlotsPerFloor) {
                                System.out.println("Invalid distribution lots provided.");
                                continue;
                            }
                            // Custom distribution provided
                            Map<VehicleType, Integer> customDistribution = new EnumMap<>(VehicleType.class);
                            customDistribution.put(VehicleType.TRUCK, Integer.parseInt(tokens[4]));
                            customDistribution.put(VehicleType.BIKE, Integer.parseInt(tokens[5]));
                            customDistribution.put(VehicleType.CAR, Integer.parseInt(tokens[6]));
                            distributionStrategy = new CustomSlotDistributionStrategy(customDistribution);
                        } else {
                            // Use default distribution
                            distributionStrategy = new DefaultSlotDistributionStrategy();
                        }
                        invoker.executeCommand(commandFactory.createCreateParkingLotCommand(parkingLotId,
                                noOfFloors, noOfSlotsPerFloor, distributionStrategy));
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
