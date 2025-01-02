package org.advancedjava.lld.parkinglot2.command;

import org.advancedjava.lld.parkinglot2.ParkingLot;
import org.advancedjava.lld.parkinglot2.ParkingLotRegistry;

public class UnparkVehicleCommand implements Command {
    private final ParkingLotRegistry parkingLotRegistry;
    private final String parkingLotId;
    private final String ticketId;

    public UnparkVehicleCommand(ParkingLotRegistry parkingLotRegistry, String parkingLotId, String ticketId) {
        this.parkingLotRegistry = parkingLotRegistry;
        this.parkingLotId = parkingLotId;
        this.ticketId = ticketId;
    }

    @Override
    public void execute() {
        ParkingLot parkingLot = parkingLotRegistry.getParkingLot(parkingLotId);
        parkingLot.unParkVehicle(ticketId);
        System.out.println("Unparked vehicle with ticket: " + ticketId);
    }
}
