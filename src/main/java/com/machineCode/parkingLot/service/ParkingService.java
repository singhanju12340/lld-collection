package com.machineCode.parkingLot.service;

import com.machineCode.parkingLot.models.BookedSlot;
import com.machineCode.parkingLot.models.Vehicle;


/**
 * @author anju
 * @created on 28/02/25 and 1:34 PM
 */
public interface ParkingService {

    public BookedSlot park(Vehicle vehicle);
    public double exit(String bookedSlotId);

}
