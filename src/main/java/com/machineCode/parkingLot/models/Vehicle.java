package com.machineCode.parkingLot.models;

/**
 * @author anju
 * @created on 28/02/25 and 1:24 PM
 */
public class Vehicle {
    String number;
    VehicleType type;

    public Vehicle(String number, VehicleType type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
