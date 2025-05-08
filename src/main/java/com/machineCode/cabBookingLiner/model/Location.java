package com.machineCode.cabBookingLiner.model;

import lombok.Data;

/**
 * @author anju
 * @created on 06/05/25 and 12:13 PM
 */

@Data
public class Location {
    private int x;

    public Location(int loc){
        this.x = loc;
    }

    public int distance(Location destination){
        return Math.abs(this.x-destination.x);
    }
}
