package com.machineCode.parkingLot.service;

import com.machineCode.parkingLot.models.Slot;
import com.machineCode.parkingLot.models.Terminal;

/**
 * @author anju
 * @created on 19/03/25 and 3:37 PM
 */
public class ParkingNearToEntryStrategy implements ParkingAssignmentStrategy{
    MonitorActivity monitorActivity;
    @Override
    public void bookParkingSlot(Terminal terminal) {
        Slot newSlot = null; // allocate slot
        monitorActivity.logEntry(newSlot);
    }

    @Override
    public void releaseParkingSlot(Slot slot) {
        monitorActivity.logExit(slot);

    }
}
