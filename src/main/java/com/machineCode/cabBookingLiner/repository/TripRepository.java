package com.machineCode.cabBookingLiner.repository;

import com.machineCode.cabBookingLiner.model.Trip;

import java.util.List;
import java.util.Optional;

/**
 * @author anju
 * @created on 06/05/25 and 12:17 PM
 */
public interface TripRepository {
    void addTrip(Trip trip);
    Optional<Trip> findById(String tripId);
    List<Trip> findTripsByCabId(String cabId);
    List<Trip> findTripsByUserId(String userId);
    void updateTrip(Trip trip);
}
