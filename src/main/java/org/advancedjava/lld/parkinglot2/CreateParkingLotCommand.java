package org.advancedjava.lld.parkinglot2;

public class CreateParkingLotCommand implements Command {
    private final ParkingLotRegistry parkingLotRegistry;
    private final String parkingLotId;
    private final int noOfFloors;
    private final int noOfSlotsPerFloor;
    private final SlotDistributionStrategy distributionStrategy;

    public CreateParkingLotCommand(ParkingLotRegistry parkingLotRegistry, String parkingLotId, int noOfFloors,
                                   int noOfSlotsPerFloor, SlotDistributionStrategy distributionStrategy) {
        this.parkingLotRegistry = parkingLotRegistry;
        this.parkingLotId = parkingLotId;
        this.noOfFloors = noOfFloors;
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
        this.distributionStrategy = distributionStrategy;
    }

    @Override
    public void execute() {

        ParkingLot parkingLot = new ParkingLot(parkingLotId, noOfFloors, noOfSlotsPerFloor, distributionStrategy);
        parkingLotRegistry.addParkingLot(parkingLotId, parkingLot);
        System.out.println("Created parking lot " + parkingLotId + " with " + noOfFloors
                + " floors and " + noOfSlotsPerFloor + " slots per floor.");
    }
}
