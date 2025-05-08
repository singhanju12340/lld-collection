package com.machineCode.inventorymanagement.licious.utils;

import com.machineCode.inventorymanagement.licious.model.Location;

import java.util.Random;

/**
 * @author anju
 * @created on 26/04/25 and 4:38 PM
 */
public class LocationService {

    public static int getDeliveryTime(Location source, Location destination) {
        // use google api to get the time
        return new Random().nextInt(100); // time in minute
    }


}
