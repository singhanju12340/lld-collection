package com.machineCode.parkingLot.service;


import com.machineCode.parkingLot.models.BookedSlot;
import com.machineCode.parkingLot.models.Slot;
import com.machineCode.parkingLot.models.Vehicle;
import com.machineCode.parkingLot.models.VehicleType;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anju
 * @created on 28/02/25 and 1:39 PM
 */
public class ParkingServiceImpl implements ParkingService{
    List<Slot> slots;
    BookingChargesService chargesService;
    Map<String, BookedSlot> bookingHistory = new HashMap<>();

    private Slot checkAvailableSlot(VehicleType type){
        return new Slot("1",VehicleType.TWO_WHEELER, true, "1");
    }

    @Override
    public BookedSlot  park(Vehicle vehicle) {
    //check available
        //mark slot booked
        // insert booked slot with current time and vehicle details
        Slot newSlot = checkAvailableSlot(vehicle.getType());
        BookedSlot bookedSlot = null;
        if(null !=newSlot){
            newSlot.setAvailable(false);
             bookedSlot = new BookedSlot(
                    "1", newSlot, vehicle, Instant.now().toEpochMilli(), null
            );
            // bookedSlot saved in DB
            bookingHistory.put(bookedSlot.getBookingId(), bookedSlot);
            // print
        }else{
            System.out.println("Not available");
        }
        return bookedSlot;
    }

    @Override
    public double exit(String bookingID ) {
        BookedSlot slot = bookingHistory.get(bookingID);
        if(null != slot){
            slot.getSlot().setAvailable(true);
            slot.setExitTime(Instant.now().toEpochMilli());
            return chargesService.calculate(slot);
        }else{
            System.out.println("Invalid booking");
            throw new RuntimeException("Invalid booking");
        }

    }
}
