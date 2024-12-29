package org.advancedjava.lld.parkinglot;

import java.util.Scanner;

public class GetSlotByRegistrationNumberCommand implements Command {
    private final ParkingLot parkingLot;
    private final Scanner sc;

    public GetSlotByRegistrationNumberCommand(ParkingLot parkingLot, Scanner sc) {
        this.parkingLot = parkingLot;
        this.sc = sc;
    }

    @Override
    public void execute() {
        System.out.println("Enter the car registration number: ");
        String regNo = sc.next();
        System.out.println("Slot no : " + parkingLot.getSlotNumberByRegNo(regNo));
    }
}

