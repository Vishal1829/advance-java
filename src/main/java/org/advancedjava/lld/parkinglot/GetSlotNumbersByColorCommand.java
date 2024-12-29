package org.advancedjava.lld.parkinglot;

import java.util.Scanner;

public class GetSlotNumbersByColorCommand implements Command {
    private final ParkingLot parkingLot;
    private final Scanner sc;

    public GetSlotNumbersByColorCommand(ParkingLot parkingLot, Scanner sc) {
        this.parkingLot = parkingLot;
        this.sc = sc;
    }

    @Override
    public void execute() {
        System.out.println("Enter the car color: ");
        String color = sc.next();
        parkingLot.getSlotNumbersByColor(Color.valueOf(color.toUpperCase()))
                .forEach(System.out::println);
    }
}

