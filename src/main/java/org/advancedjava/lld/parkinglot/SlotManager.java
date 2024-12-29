package org.advancedjava.lld.parkinglot;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SlotManager {
    private final List<Slot> slots;

    public SlotManager(int capacity) {
        this.slots = IntStream.range(1, capacity + 1)
                .mapToObj(Slot::new)
                .collect(Collectors.toList());
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public String bookSlot(Slot slot, Car car) {
        if (slot != null && slot.getStatus() == SlotStatus.FREE) {
            slot.setCar(car);
            slot.setStatus(SlotStatus.BOOKED);
            return "Slot " + slot.getSlotNo() + " is now booked for car with registration number: " + car.getRegNo();
        }
        return "All Slots are already booked.";
    }

    public String freeSlot(int slotNo) {
        Slot slot = slots.stream()
                .filter(s -> s.getSlotNo() == slotNo && s.getStatus() == SlotStatus.BOOKED)
                .findFirst()
                .orElse(null);
        if (slot != null) {
            slot.setCar(null);
            slot.setStatus(SlotStatus.FREE);
            return "Slot " + slotNo + " is now available.";
        }
        return "Slot " + slotNo + " is not booked.";
    }

    // 1. Registration numbers of all cars of a particular colour
    public List<String> getRegistrationNumbersByColor(Color color) {
        return slots.stream()
                .filter(slot -> slot.getStatus() == SlotStatus.BOOKED)
                .map(Slot::getCar)
                .filter(car -> car.getColor() == color)
                .map(Car::getRegNo)
                .collect(Collectors.toList());
    }

    // 2. Slot number in which a car with a given registration number is placed
    public int getSlotNumberByRegNo(String regNo) {
        return slots.stream()
                .filter(slot -> slot.getStatus() == SlotStatus.BOOKED)
                .filter(slot -> slot.getCar().getRegNo().equals(regNo))
                .map(Slot::getSlotNo)
                .findFirst()
                .orElse(-1); // Return -1 if no slot found
    }

    // 3. Slot numbers of all slots where a car of a particular colour is parked
    public List<Integer> getSlotNumbersByColor(Color color) {
        return slots.stream()
                .filter(slot -> slot.getStatus() == SlotStatus.BOOKED)
                .filter(slot -> slot.getCar().getColor() == color)
                .map(Slot::getSlotNo)
                .collect(Collectors.toList());
    }
}


//public class SlotManager {
//    private final List<Slot> slots;
//
//    public SlotManager(int capacity) {
//        this.slots = IntStream.range(1, capacity + 1)
//                .mapToObj(Slot::new)
//                .collect(Collectors.toList());
//    }
//
//    /**
//     * Fetch slot by its number.
//     *
//     * @param slotNo The slot number.
//     * @return The Slot if found, or null if not found.
//     */
//    public Slot getSlot(int slotNo) {
//        return slots.stream()
//                .filter(slot -> slot.getSlotNo() == slotNo)
//                .findFirst()
//                .orElse(null);
//    }
//
//    /**
//     * Fetch all available (free) slots.
//     *
//     * @return List of free slots.
//     */
//    public List<Slot> getAvailableSlots() {
//        return slots.stream()
//                .filter(slot -> slot.getStatus() == SlotStatus.FREE)
//                .collect(Collectors.toList());
//    }
//
//    /**
//     * Mark a specific slot as booked with the given car.
//     *
//     * @param slotNo The slot number to be booked.
//     * @param car    The car to assign to the slot.
//     * @return Success or failure message.
//     */
//    public String bookSlot(int slotNo, Car car) {
//        Optional<Slot> slotOptional = slots.stream()
//                .filter(slot -> slot.getSlotNo() == slotNo && slot.getStatus() == SlotStatus.FREE)
//                .findFirst();
//
//        if (slotOptional.isPresent()) {
//            Slot slot = slotOptional.get();
//            slot.setCar(car);
//            slot.setStatus(SlotStatus.BOOKED);
//            return "Slot " + slotNo + " is now booked for car with registration number: " + car.getRegNo();
//        } else {
//            return "Slot " + slotNo + " is not available.";
//        }
//    }
//
//    /**
//     * Mark a specific slot as free.
//     *
//     * @param slotNo The slot number to be freed.
//     * @return Success or failure message.
//     */
//    public String freeSlot(int slotNo) {
//        Slot slot = getSlot(slotNo);
//        if (slot != null && slot.getStatus() == SlotStatus.BOOKED) {
//            slot.setCar(null);
//            slot.setStatus(SlotStatus.FREE);
//            return "Slot " + slotNo + " is now free.";
//        } else {
//            return "Slot " + slotNo + " is already free or does not exist.";
//        }
//    }
//
//    /**
//     * Get all slots currently occupied by cars of a specific color.
//     *
//     * @param color The color of cars to search for.
//     * @return List of occupied slots with the specified car color.
//     */
//    public List<Slot> getSlotsByCarColor(Color color) {
//        return slots.stream()
//                .filter(slot -> slot.getCar() != null && slot.getCar().getColor() == color)
//                .collect(Collectors.toList());
//    }
//
//    /**
//     * Get the slot where a car with a specific registration number is parked.
//     *
//     * @param regNo The registration number of the car.
//     * @return The Slot if found, or null if not found.
//     */
//    public Slot getSlotByCarRegNo(String regNo) {
//        return slots.stream()
//                .filter(slot -> slot.getCar() != null && regNo.equals(slot.getCar().getRegNo()))
//                .findFirst()
//                .orElse(null);
//    }
//}

