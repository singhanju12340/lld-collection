package com.machineCode.parkingLot.service;

import com.machineCode.parkingLot.models.Slot;
import com.machineCode.parkingLot.models.Terminal;

/**
 * @author anju
 * @created on 19/03/25 and 3:32 PM
 */
public interface ParkingAssignmentStrategy {
    void bookParkingSlot(Terminal terminal);
    void releaseParkingSlot(Slot slot);
}
