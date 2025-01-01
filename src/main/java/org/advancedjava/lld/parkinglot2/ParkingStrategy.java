package org.advancedjava.lld.parkinglot2;

import org.advancedjava.util.Pair;

import java.util.Optional;

public interface ParkingStrategy {
    Optional<Pair<Integer, Slot>> findSlot(FloorManager floorManager, Vehicle vehicle);
}
