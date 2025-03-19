package com.machineCode.parkingLot.service;

import com.machineCode.parkingLot.models.BookedSlot;


/**
 * @author anju
 * @created on 28/02/25 and 1:40 PM
 */
public interface BookingChargesService {
    public double calculate( BookedSlot bookedSlot);
}
