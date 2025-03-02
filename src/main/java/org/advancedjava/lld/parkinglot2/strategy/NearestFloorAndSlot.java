package org.advancedjava.lld.parkinglot2.strategy;

import org.advancedjava.lld.parkinglot2.manager.FloorManager;
import org.advancedjava.lld.parkinglot2.model.Slot;
import org.advancedjava.lld.parkinglot2.manager.SlotManager;
import org.advancedjava.lld.parkinglot2.model.Vehicle;
import org.advancedjava.util.Pair;

import java.util.Map;
import java.util.Optional;

public class NearestFloorAndSlot implements ParkingStrategy {
    @Override
    public Optional<Pair<Integer, Slot>> findSlot(FloorManager floorManager, Vehicle vehicle) {
        for (Map.Entry<Integer, SlotManager> k : floorManager.getFloorSlotsMap().entrySet()) {
            SlotManager slotManager = k.getValue();
            Slot slot = slotManager.findSlotBasedOnVehicleType(vehicle.getVehicleType());
            if (slot != null) {
                return Optional.of(new Pair<>(k.getKey(), slot));
            }
        }
        return Optional.empty();
    }
}
