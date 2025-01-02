package org.advancedjava.lld.parkinglot2.command;

import org.advancedjava.lld.parkinglot2.ParkingLot;
import org.advancedjava.lld.parkinglot2.ParkingLotRegistry;
import org.advancedjava.lld.parkinglot2.factory.VehicleFactory;

public class ParkVehicleCommand implements Command {
    private final ParkingLotRegistry parkingLotRegistry;
    private final String parkingLotId;
    private final String vehicleType;
    private final String regNo;
    private final String color;

    public ParkVehicleCommand(ParkingLotRegistry parkingLotRegistry, String parkingLotId, String vehicleType, String regNo, String color) {
        this.parkingLotRegistry = parkingLotRegistry;
        this.parkingLotId = parkingLotId;
        this.vehicleType = vehicleType;
        this.regNo = regNo;
        this.color = color;
    }

    @Override
    public void execute() {
        ParkingLot parkingLot = parkingLotRegistry.getParkingLot(parkingLotId);
        String ticket = parkingLot.parkVehicle(VehicleFactory.createVehicle(vehicleType, regNo, color));
        System.out.println("TicketId: " + ticket + " for vehicle: " + regNo);
    }
}
