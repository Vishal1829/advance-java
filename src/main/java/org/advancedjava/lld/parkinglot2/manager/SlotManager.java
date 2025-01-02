package org.advancedjava.lld.parkinglot2.manager;

import org.advancedjava.lld.parkinglot2.model.Slot;
import org.advancedjava.lld.parkinglot2.model.SlotStatus;
import org.advancedjava.lld.parkinglot2.model.Vehicle;
import org.advancedjava.lld.parkinglot2.model.VehicleType;
import org.advancedjava.lld.parkinglot2.strategy.SlotDistributionStrategy;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SlotManager {
    private final Map<VehicleType, List<Slot>> slotsMap;

    public SlotManager(int floorNumber, int numSlots, SlotDistributionStrategy distributionStrategy) {
        slotsMap = new EnumMap<>(VehicleType.class);
        initializeSlots(floorNumber, numSlots, distributionStrategy);
    }

    private void initializeSlots(int floorNumber, int numSlots, SlotDistributionStrategy distributionStrategy) {
        Map<VehicleType, Integer> distribution = distributionStrategy.getDistribution(floorNumber, numSlots);
        int slotNumber = 1;
        for (Map.Entry<VehicleType, Integer> entry : distribution.entrySet()) {
            VehicleType vehicleType = entry.getKey();
            int numSlotsForType = entry.getValue();
            slotsMap.put(vehicleType, new ArrayList<>(numSlotsForType));
            for (int i = 0; i < numSlotsForType; i++) {
//                System.out.println(vehicleType + " " + numSlotsForType + " " + slotNumber);
                slotsMap.get(vehicleType).add(new Slot(slotNumber++));
            }
        }
    }

    public Slot findSlotBasedOnVehicleType(VehicleType vehicleType) {
        return slotsMap.get(vehicleType).stream().filter(slot -> slot.getStatus() == SlotStatus.FREE)
                .findFirst().orElse(null);
    }

    public void bookSlot(Slot slot, Vehicle vehicle) {
        slot.setVehicle(vehicle);
        slot.setStatus(SlotStatus.BOOKED);
    }

    public void unBookSlot(Slot slot) {
        slotsMap.get(slot.getVehicle().getVehicleType()).stream().filter(truckSlot -> truckSlot.getSlotNumber() == slot.getSlotNumber())
                .forEach(vehicleSlot -> {
                    vehicleSlot.setStatus(SlotStatus.FREE);
                    vehicleSlot.setVehicle(null);
                });
    }

    public long getFreeSlotsCount(VehicleType vehicleType) {
        return slotsMap.get(vehicleType).stream().filter(slot -> slot.getStatus() == SlotStatus.FREE)
                .count();
    }

    public List<Integer> getFreeSlotsList(VehicleType vehicleType) {
        return slotsMap.get(vehicleType).stream().filter(slot -> slot.getStatus() == SlotStatus.FREE)
                .map(Slot::getSlotNumber).collect(Collectors.toList());
    }

    public List<Integer> getOccupiedSlotsList(VehicleType vehicleType) {
        return slotsMap.get(vehicleType).stream().filter(slot -> slot.getStatus() == SlotStatus.BOOKED)
                .map(Slot::getSlotNumber).collect(Collectors.toList());
    }
}
