package org.advancedjava.lld.parkinglot2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Slot {
    private final int slotNumber;
    @Setter
    private Vehicle vehicle;
    @Setter
    private SlotStatus status;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.vehicle = null;
        this.status = SlotStatus.FREE;
    }
}
