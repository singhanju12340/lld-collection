package com.machineCode.inventorymanagement.licious.model;

import lombok.Data;

/**
 * @author anju
 * @created on 26/04/25 and 4:04 PM
 */

@Data
public class Location {
    long lat;
    long lon;

    public Location(long lat, long lon) {
        this.lat = lat;
        this.lon = lon;
    }
}
