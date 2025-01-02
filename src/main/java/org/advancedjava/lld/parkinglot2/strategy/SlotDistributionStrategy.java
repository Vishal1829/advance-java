package org.advancedjava.lld.parkinglot2.strategy;

import org.advancedjava.lld.parkinglot2.model.VehicleType;

import java.util.Map;

public interface SlotDistributionStrategy {
    Map<VehicleType, Integer> getDistribution(int floorNumber, int numSlots);
}
