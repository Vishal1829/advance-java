package org.advancedjava.lld.parkinglot2.strategy;

import org.advancedjava.lld.parkinglot2.manager.FloorManager;
import org.advancedjava.lld.parkinglot2.model.Slot;
import org.advancedjava.lld.parkinglot2.model.Vehicle;
import org.advancedjava.util.Pair;

import java.util.Optional;

public interface ParkingStrategy {
    Optional<Pair<Integer, Slot>> findSlot(FloorManager floorManager, Vehicle vehicle);
}
