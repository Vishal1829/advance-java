package org.advancedjava.lld.parkinglot;

import java.util.Scanner;

public class EmptySlotCommand implements Command {
    private final ParkingLot parkingLot;
    private final Scanner sc;

    public EmptySlotCommand(ParkingLot parkingLot, Scanner sc) {
        this.parkingLot = parkingLot;
        this.sc = sc;
    }

    @Override
    public void execute() {
        System.out.println("Enter the slot number: ");
        int slotNo = sc.nextInt();
        System.out.println(parkingLot.unPark(slotNo));
    }
}

