package com.machineCode.cabBookingLiner.model;

import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author anju
 * @created on 06/05/25 and 12:12 PM
 */
@Data
public class Cab {
    private final String id;
    private Location location;
    private boolean isAvailable;
    private Trip lastTrip;
    private Lock lock;

    public Cab(String id, Location location) {
        this.id = id;
        this.location = location;
        this.isAvailable = true;
        this.lock = new ReentrantLock();
    }

}
