package com.machineCode.parkingLot.models.payment;

import com.machineCode.parkingLot.models.VehicleType;

/**
 * @author anju
 * @created on 19/03/25 and 3:57 PM
 */
public interface BookingChargeCalculator {
    void calculate(Long startTime, long endTime, VehicleType type);
}
