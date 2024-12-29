package org.advancedjava.lld.parkinglot;

import java.util.Scanner;

public class ParkCarCommand implements Command {
    private final ParkingLot parkingLot;
    private final Scanner sc;

    public ParkCarCommand(ParkingLot parkingLot, Scanner sc) {
        this.parkingLot = parkingLot;
        this.sc = sc;
    }

    @Override
    public void execute() {
        System.out.println("Enter the car details: ");
        String registrationNumber = sc.next();
        String color = sc.next();
        System.out.println(parkingLot.park(new Car(registrationNumber, Color.valueOf(color.toUpperCase()))));
    }
}

