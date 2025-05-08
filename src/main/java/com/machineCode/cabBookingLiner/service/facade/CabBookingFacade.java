package com.machineCode.cabBookingLiner.service.facade;

import com.machineCode.cabBookingLiner.model.Cab;
import com.machineCode.cabBookingLiner.model.Location;
import com.machineCode.cabBookingLiner.model.RideUser;
import com.machineCode.cabBookingLiner.model.Trip;
import com.machineCode.cabBookingLiner.service.TripService;
import com.machineCode.cabBookingLiner.service.CabService;
import com.machineCode.cabBookingLiner.service.UserService;

import java.util.List;
import java.util.Optional;

/**
 * @author anju
 * @created on 06/05/25 and 1:07 PM
 */
public class CabBookingFacade {
    private final UserService userService;
    private final CabService cabService;
    private final TripService tripService;


    public CabBookingFacade(UserService userService, CabService cabService, TripService tripService) {
        this.userService = userService;
        this.cabService = cabService;
        this.tripService = tripService;
    }

    public RideUser registerUser(String userId) {
        return userService.registerUser(userId);
    }

    public Cab registerCab(String cabId, Location location) {
        return cabService.registerCab(cabId, location);
    }

    public Optional<Trip> bookCab(String userId, Location pickupLocation, int searchRadius) {
        return tripService.bookCab(userId, pickupLocation, searchRadius);
    }

    public boolean endTrip(String tripId, Location dropLocation, double tip) {
        return tripService.endTrip(tripId, dropLocation, tip);
    }

    public double getCabEarnings(String cabId) {
        return tripService.getCabTotalEarnings(cabId);
    }

    public double getCabTips(String cabId) {
        return tripService.calculateCabTips(cabId);
    }

    public List<Trip> getUserTrips(String userId) {
        return tripService.getUserTrips(userId);
    }
}
