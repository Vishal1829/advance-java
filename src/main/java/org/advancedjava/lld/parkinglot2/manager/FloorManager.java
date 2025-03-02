package org.advancedjava.lld.parkinglot2.manager;

import lombok.Getter;
import org.advancedjava.lld.parkinglot2.model.VehicleType;
import org.advancedjava.lld.parkinglot2.strategy.SlotDistributionStrategy;

import java.util.HashMap;
import java.util.Map;

@Getter
public class FloorManager {
    private final int noOfFloors;
    private final Map<Integer, SlotManager> floorSlotsMap;

    public FloorManager(int noOfFloors) {
        this.noOfFloors = noOfFloors;
        floorSlotsMap = new HashMap<>();
    }

    public void addFloor(int floorNumber, int numSlots, SlotDistributionStrategy distributionStrategy) {
        floorSlotsMap.put(floorNumber, new SlotManager(floorNumber, numSlots, distributionStrategy));
    }

    public void displayFreeSlotsCountPerFloor(VehicleType vehicleType) {
        for (Map.Entry<Integer, SlotManager> entry : floorSlotsMap.entrySet()) {
            int floorNumber = entry.getKey();
            SlotManager slotManager = entry.getValue();
            System.out.println("No. of free slots for " + vehicleType + " on Floor " + floorNumber
                    + ": " + slotManager.getFreeSlotsCount(vehicleType));
        }
    }

    public void displayAllFreeSlotsPerFloor(VehicleType vehicleType) {
        for (Map.Entry<Integer, SlotManager> entry : floorSlotsMap.entrySet()) {
            int floorNumber = entry.getKey();
            SlotManager slotManager = entry.getValue();
            System.out.println("Free slots for " + vehicleType + " on Floor " + floorNumber
                    + ": " + slotManager.getFreeSlotsList(vehicleType));
        }
    }

    public void displayAllOccupiedSlotsPerFloor(VehicleType vehicleType) {
        for (Map.Entry<Integer, SlotManager> entry : floorSlotsMap.entrySet()) {
            int floorNumber = entry.getKey();
            SlotManager slotManager = entry.getValue();
            System.out.println("Occupied slots for " + vehicleType + " on Floor " + floorNumber
                    + ": " + slotManager.getOccupiedSlotsList(vehicleType));
        }
    }
}
