package com.machineCode.cabBookingLiner.model;

import lombok.Data;

/**
 * @author anju
 * @created on 06/05/25 and 12:15 PM
 */

@Data
public class RideUser {
    private String id;
    private Trip lastTrip;


    public RideUser(String id) {
        this.id = id;
    }
}
