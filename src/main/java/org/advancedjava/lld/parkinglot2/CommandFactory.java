package org.advancedjava.lld.parkinglot2;

public class CommandFactory {
    private static volatile CommandFactory commandFactoryInstance;
    private final ParkingLotRegistry parkingLotRegistry;

    private CommandFactory(ParkingLotRegistry parkingLotRegistry) {
        this.parkingLotRegistry = parkingLotRegistry;
    }

    public static CommandFactory getInstance(ParkingLotRegistry parkingLotRegistry) {
        if (commandFactoryInstance == null) {
            synchronized (CommandFactory.class) {
                if (commandFactoryInstance == null) {
                    commandFactoryInstance = new CommandFactory(parkingLotRegistry);
                }
            }
        }
        return commandFactoryInstance;
    }

    public Command createCreateParkingLotCommand(String parkingLotId, int noOfFloors, int noOfSlotsPerFloor,
                                                 SlotDistributionStrategy distributionStrategy) {
        return new CreateParkingLotCommand(parkingLotRegistry, parkingLotId, noOfFloors, noOfSlotsPerFloor, distributionStrategy);
    }

    public Command createParkVehicleCommand(String parkingLotId, String vehicleType, String regNo, String color) {
        return new ParkVehicleCommand(parkingLotRegistry, parkingLotId, vehicleType, regNo, color);
    }

    public Command createUnparkVehicleCommand(String parkingLotId, String ticketId) {
        return new UnparkVehicleCommand(parkingLotRegistry, parkingLotId, ticketId);
    }

    public Command createDisplayCommand(String parkingLotId, String displayType, String vehicleType) {
        return new DisplayCommand(parkingLotRegistry, parkingLotId, displayType, vehicleType);
    }

    public Command createExitCommand() {
        return new ExitCommand();
    }

//    public Command createFindVehicleCommand(String regNo) {
//        validateParkingLot();
//        return new FindVehicleCommand(parkingLot, regNo);
//    }

//    private void validateParkingLot() {
//        if (parkingLot == null) {
//            throw new IllegalStateException("Please create a parking lot first.");
//        }
//    }
}
