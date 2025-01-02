package org.advancedjava.lld.parkinglot2.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Ticket {
    private final String ticketId;
    private final Slot slot;
    private final int floorNumber;

    public Ticket(String parkingLotId, Slot slot, int floorNumber) {
        this.ticketId = parkingLotId + "_" + floorNumber + "_" + slot.getSlotNumber();
        this.slot = slot;
        this.floorNumber = floorNumber;
    }
}
