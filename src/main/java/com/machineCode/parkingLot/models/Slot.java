package com.machineCode.parkingLot.models;

/**
 * @author anju
 * @created on 28/02/25 and 1:24 PM
 */
public class Slot {
    String id;
    VehicleType type;
    boolean available;
    String floor = "1";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Slot(String id, VehicleType type, boolean available, String floor) {
        this.id = id;
        this.type = type;
        this.available = available;
        this.floor = floor;
    }
}
