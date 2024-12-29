package org.advancedjava.lld.parkinglot;

import java.util.List;
import java.util.Optional;

public class ParkingLot {
    private static volatile ParkingLot instance;
    private final SlotManager slotManager;
    private final ParkingStrategy parkingStrategy;

    // Private constructor
    private ParkingLot(int capacity, ParkingStrategy parkingStrategy) {
        this.slotManager = new SlotManager(capacity);
        this.parkingStrategy = parkingStrategy;
    }

    // Double-Checked Locking Singleton Implementation
    public static ParkingLot getInstance(int capacity, ParkingStrategy parkingStrategy) {
        if (instance == null) { // First check (no synchronization)
            synchronized (ParkingLot.class) { // Lock the class
                if (instance == null) { // Second check (inside synchronized block)
                    instance = new ParkingLot(capacity, parkingStrategy);
                }
            }
        }
        return instance;
    }

    public String park(Car car) {
        Optional<Slot> optionalSlot = parkingStrategy.findSlot(slotManager.getSlots());
        if (optionalSlot.isPresent()) {
            return slotManager.bookSlot(optionalSlot.get(), car);
        } else {
            return "All slots are booked.";
        }
    }

    public String unPark(int slotNo) {
        return slotManager.freeSlot(slotNo);
    }

    public List<String> getRegistrationNumbersByColor(Color color) {
        return slotManager.getRegistrationNumbersByColor(color);
    }

    public int getSlotNumberByRegNo(String regNo) {
        return slotManager.getSlotNumberByRegNo(regNo);
    }

    public List<Integer> getSlotNumbersByColor(Color color) {
        return slotManager.getSlotNumbersByColor(color);
    }

}


//public class ParkingLot {
//    private int capacity;
//    private List<Slot> slots;
//    private ParkingStrategy parkingStrategy;
//
//    public ParkingLot(int capacity) {
//        this.capacity = capacity;
//        this.slots = IntStream.range(1, capacity + 1)
//                .mapToObj(i -> new Slot(i))
//                .collect(Collectors.toList());
//        this.parkingStrategy = new ParkingStrategy();
//    }
//
//    public String park(Car car) {
//        return parkingStrategy.park(slots, car);
//    }
//
//    public String unPark(int slotNo) {
//        return parkingStrategy.unPark(slots, slotNo);
//    }
//
//    public List<String> getRegNosFromColor(Color color) {
//        return slots.stream().map(Slot::getCar)
//                .filter(Objects::nonNull)
//                .filter(car -> car.getColor() == color)
//                .map(Car::getRegNo)
//                .collect(Collectors.toList());
//    }
//
//    public int getSlotNoFromRegNo(String regNo) {
//        return slots.stream()
//                .filter(slot -> slot.getCar() != null)
//                .filter(slot -> regNo.equals(slot.getCar().getRegNo()))
//                .map(Slot::getSlotNo)
//                .findFirst()
//                .orElse(-1);
//    }
//
//    public List<Integer> getSlotNosFromColor(Color color) {
//        return slots.stream().filter(slot -> slot.getCar() != null)
//                .filter(slot -> slot.getCar().getColor() == color)
//                .map(Slot::getSlotNo)
//                .collect(Collectors.toList());
//    }
//}
