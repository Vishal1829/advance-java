package org.advancedjava.lld.parkinglot2;

import java.util.Arrays;

public class CreateParkingLotCommand implements Command {
    private final ParkingLotRegistry parkingLotRegistry;
    private final String parkingLotId;
    private final int noOfFloors;
    private final int[] slotsPerFloor;
    private final SlotDistributionStrategy distributionStrategy;

    public CreateParkingLotCommand(ParkingLotRegistry parkingLotRegistry, String parkingLotId, int noOfFloors,
                                   int[] slotsPerFloor, SlotDistributionStrategy distributionStrategy) {
        this.parkingLotRegistry = parkingLotRegistry;
        this.parkingLotId = parkingLotId;
        this.noOfFloors = noOfFloors;
        this.slotsPerFloor = slotsPerFloor;
        this.distributionStrategy = distributionStrategy;
    }

    @Override
    public void execute() {

        ParkingLot parkingLot = new ParkingLot(parkingLotId, noOfFloors, slotsPerFloor, distributionStrategy);
        parkingLotRegistry.addParkingLot(parkingLotId, parkingLot);
        System.out.println("Created parking lot " + parkingLotId + " with " + noOfFloors
                + " floors and " + Arrays.toString(slotsPerFloor) + " slots per floor.");
    }
}
