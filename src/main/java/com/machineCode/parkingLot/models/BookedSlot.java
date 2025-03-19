package com.machineCode.parkingLot.models;

/**
 * @author anju
 * @created on 28/02/25 and 1:28 PM
 */
public class BookedSlot {
    String bookingId;
    Slot slot;
    Vehicle vehicle;
    Long bookingTime;
    Long exitTime; // add exit time at the time

    public BookedSlot(String bookingId, Slot slot, Vehicle vehicle, Long bookingTime, Long exitTime) {
        this.bookingId = bookingId;
        this.slot = slot;
        this.vehicle = vehicle;
        this.bookingTime = bookingTime;
        this.exitTime = exitTime;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Long bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Long getExitTime() {
        return exitTime;
    }

    public void setExitTime(Long exitTime) {
        this.exitTime = exitTime;
    }
}
