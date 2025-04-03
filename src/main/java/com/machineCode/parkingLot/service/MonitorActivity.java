package com.machineCode.parkingLot.service;

import com.machineCode.parkingLot.models.Slot;

/**
 * @author anju
 * @created on 19/03/25 and 3:59 PM
 */
public interface MonitorActivity {
    void logEntry(Slot slot);
    void logExit(Slot slot);
}
