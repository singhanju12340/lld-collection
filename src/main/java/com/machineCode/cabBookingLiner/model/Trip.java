package com.machineCode.cabBookingLiner.model;

import lombok.Data;

import java.util.Date;

/**
 * @author anju
 * @created on 06/05/25 and 10:34 AM
 */
@Data
public class Trip {
    private final String id;
    private final String driverId;
    private final String passengerId;
    private final Location startPoint;
    private Location dropPoint;
    private double fare;
    private double tip;
    private final Date startTime;
    private Date endTime;

    public Trip(String id, String cabId, String userId, Location startLocation,
                Location endLocation, double fare, double tip) {
        this.id = id;
        this.driverId = cabId;
        this.passengerId = userId;
        this.startPoint = startLocation;
        this.dropPoint = endLocation;
        this.fare = fare;
        this.tip = tip;
        this.startTime = new Date();
    }

    public void endTrip() {
        this.endTime = new Date();
    }
}
