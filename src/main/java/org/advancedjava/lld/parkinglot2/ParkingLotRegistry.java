package org.advancedjava.lld.parkinglot2;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRegistry {
    private static volatile ParkingLotRegistry parkingLotRegistryInstance;
    private final Map<String, ParkingLot> parkingLots = new HashMap<>();

    private ParkingLotRegistry() {

    }

    public static ParkingLotRegistry getInstance() {
        if (parkingLotRegistryInstance == null) {
            synchronized (ParkingLotRegistry.class) {
                if (parkingLotRegistryInstance == null) {
                    parkingLotRegistryInstance = new ParkingLotRegistry();
                }
            }
        }
        return parkingLotRegistryInstance;
    }

    public void addParkingLot(String parkingLotId, ParkingLot parkingLot) {
        parkingLots.put(parkingLotId, parkingLot);
    }

    public ParkingLot getParkingLot(String parkingLotId) {
        ParkingLot parkingLot = parkingLots.get(parkingLotId);
        if (parkingLot == null) {
            throw new IllegalStateException("Parking lot with ID " + parkingLotId + " does not exist.");
        }
        return parkingLot;
    }

    public boolean containsParkingLot(String parkingLotId) {
        return parkingLots.containsKey(parkingLotId);
    }
}
