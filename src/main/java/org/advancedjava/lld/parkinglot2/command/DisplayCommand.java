package org.advancedjava.lld.parkinglot2.command;

import org.advancedjava.lld.parkinglot2.ParkingLot;
import org.advancedjava.lld.parkinglot2.ParkingLotRegistry;
import org.advancedjava.lld.parkinglot2.model.VehicleType;

public class DisplayCommand implements Command {
    private final ParkingLotRegistry parkingLotRegistry;
    private final String parkingLotId;
    private final String displayType;
    private final String vehicleType;

    public DisplayCommand(ParkingLotRegistry parkingLotRegistry, String parkingLotId,
                          String displayType, String vehicleType) {
        this.parkingLotRegistry = parkingLotRegistry;
        this.parkingLotId = parkingLotId;
        this.displayType = displayType;
        this.vehicleType = vehicleType;
    }

    @Override
    public void execute() {
        ParkingLot parkingLot = parkingLotRegistry.getParkingLot(parkingLotId);
        switch (displayType) {
            case "free_count" -> parkingLot.displayFreeSlotsCountPerFloor(VehicleType.valueOf(vehicleType));
            case "free_slots" -> parkingLot.displayFreeSlotsListPerFloor(VehicleType.valueOf(vehicleType));
            case "occupied_slots" -> parkingLot.displayOccupiedSlotsListPerFloor(VehicleType.valueOf(vehicleType));
            default -> System.out.println("Invalid display type");
        }
    }
}
