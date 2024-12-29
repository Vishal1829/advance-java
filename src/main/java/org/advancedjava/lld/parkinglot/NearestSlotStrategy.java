package org.advancedjava.lld.parkinglot;

import java.util.List;
import java.util.Optional;

public class NearestSlotStrategy implements ParkingStrategy {
    @Override
    public Optional<Slot> findSlot(List<Slot> slots) {
        return slots.stream()
                .filter(slot -> slot.getStatus() == SlotStatus.FREE)
                .findFirst();
    }
}

