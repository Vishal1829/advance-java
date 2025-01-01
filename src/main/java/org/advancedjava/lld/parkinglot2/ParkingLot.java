package org.advancedjava.lld.parkinglot2;

import lombok.Getter;

public class ParkingLot {
    @Getter
    public String parkingLotId;
    private FloorManager floorManager;
    private ParkingStrategy parkingStrategy;
    private TicketManager ticketManager;

    public ParkingLot(String parkingLotId, int noOfFloors, int noOfSlotsPerFloor,
                      SlotDistributionStrategy distributionStrategy) {
        initialize(parkingLotId, noOfFloors, noOfSlotsPerFloor, distributionStrategy);
    }

    private void initialize(String parkingLotId, int noOfFloors, int noOfSlotsPerFloor,
                           SlotDistributionStrategy distributionStrategy) {
        this.parkingLotId = parkingLotId;
        this.floorManager = new FloorManager(noOfFloors);
        this.parkingStrategy = new NearestFloorAndSlot();
        this.ticketManager = new TicketManager(parkingLotId);

        // Add floors and slots to the parking lot
        for (int i = 1; i <= noOfFloors; i++) {
            floorManager.addFloor(i, noOfSlotsPerFloor, distributionStrategy);
        }
    }

    public String parkVehicle(Vehicle vehicle) {
        return parkingStrategy.findSlot(floorManager, vehicle).map(pair -> {
            int floorNumber = pair.getFirst();
            Slot slot = pair.getSecond();
            floorManager.getFloorSlotsMap().get(floorNumber).bookSlot(slot, vehicle);
            return ticketManager.createTicket(slot, floorNumber);
        }).orElse("No available slot found for the vehicle");
    }

    public void unParkVehicle(String ticketId) {
        if (ticketManager.getTicketMap().get(ticketId) != null) {
            int floorNumber = ticketManager.getTicketMap().get(ticketId).getFloorNumber();
            Slot slot = ticketManager.getTicketMap().get(ticketId).getSlot();
            floorManager.getFloorSlotsMap().get(floorNumber).unBookSlot(slot);
            ticketManager.removeTicket(ticketId);
        }
        else {
            System.out.println("Invalid ticketId provided!!");
        }
    }

    public void displayFreeSlotsCountPerFloor(VehicleType vehicleType) {
        floorManager.displayFreeSlotsCountPerFloor(vehicleType);
    }

    public void displayFreeSlotsListPerFloor(VehicleType vehicleType) {
        floorManager.displayAllFreeSlotsPerFloor(vehicleType);
    }

    public void displayOccupiedSlotsListPerFloor(VehicleType vehicleType) {
        floorManager.displayAllOccupiedSlotsPerFloor(vehicleType);
    }
}