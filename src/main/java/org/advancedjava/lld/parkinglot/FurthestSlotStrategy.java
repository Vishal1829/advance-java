package org.advancedjava.lld.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FurthestSlotStrategy implements ParkingStrategy {
    @Override
    public Optional<Slot> findSlot(List<Slot> slots) {
        // Find the furthest free slot by looking for the slot with the highest number
        return slots.stream()
                .filter(slot -> slot.getStatus() == SlotStatus.FREE)
                .max(Comparator.comparingInt(Slot::getSlotNo));
    }
}

