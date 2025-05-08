package com.machineCode.cabBookingLiner;

import com.machineCode.cabBookingLiner.model.Cab;
import com.machineCode.cabBookingLiner.model.Location;
import com.machineCode.cabBookingLiner.model.RideUser;
import com.machineCode.cabBookingLiner.model.Trip;
import com.machineCode.cabBookingLiner.service.CabBookingFacadeFactory;
import com.machineCode.cabBookingLiner.service.TripService;
import com.machineCode.cabBookingLiner.service.facade.CabBookingFacade;

import java.util.Optional;

/**
 * @author anju
 * @created on 06/05/25 and 12:46 PM
 */
public class CabMain {
    public static void main(String[] args) {
        CabBookingFacade cabBookingFacade = CabBookingFacadeFactory.createService(10.0);

        cabBookingFacade.registerCab("cab1", new Location(10));
        cabBookingFacade.registerCab("cab2", new Location(10));

        cabBookingFacade.registerUser("user1");

        Optional<Trip> tripOpt = cabBookingFacade.bookCab("user1", new Location(15), 10);

        if (tripOpt.isPresent()) {
            Trip trip = tripOpt.get();

            // End trip
            cabBookingFacade.endTrip(trip.getId(), new Location(25), 5.0);

            // Get cab earnings
            double earnings = cabBookingFacade.getCabEarnings(trip.getDriverId());
            System.out.println("Cab earnings: " + earnings);
        }


    }
}
