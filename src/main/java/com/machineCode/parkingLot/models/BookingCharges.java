package com.machineCode.parkingLot.models;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anju
 * @created on 28/02/25 and 1:32 PM
 */
public class BookingCharges {
    Map<VehicleType, Double> charges;

    Double vehicleTwoWheeler = 50.0;
    Double vehicleFourWheeler = 100.0;
    Double vehicleSixWheeler = 200.0;


    public BookingCharges(Map<VehicleType, Double> charges) {
        this.charges = charges;
    }
}
