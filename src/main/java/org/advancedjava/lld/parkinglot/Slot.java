package org.advancedjava.lld.parkinglot;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Slot {
    private int slotNo;
    @Setter
    private SlotStatus status;
    @Setter
    private Car car;

    public Slot(int slotNo) {
        this.slotNo = slotNo;
        this.status = SlotStatus.FREE;
    }
}
