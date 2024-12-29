package org.advancedjava.lld.parkinglot;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<Slot> findSlot(List<Slot> slots);
}


//import java.util.List;
//
//public class ParkingStrategy {
//    public String park(List<Slot> slots, Car car) {
//        for (Slot slot : slots) {
//            if (slot.getStatus() == SlotStatus.FREE) {
//                slot.setCar(car);
//                slot.setStatus(SlotStatus.BOOKED);
//                return "Car with registrationNumber " + car.getRegNo() + " is parked at slot number " + slot.getSlotNo();
//            }
//        }
//        return "All slots are booked";
//    }
//
//    public String unPark(List<Slot> slots, int slotNo) {
//        for (Slot slot : slots) {
//            if (slot.getSlotNo() == slotNo && slot.getCar() != null) {
//                slot.setCar(null);
//                slot.setStatus(SlotStatus.FREE);
//                return "Slot : " + slotNo + " is available now";
//            }
//        }
//        return "SlotNumber" + slotNo + " already available";
//    }
//}
