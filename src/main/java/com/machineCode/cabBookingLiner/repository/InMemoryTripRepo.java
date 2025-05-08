package com.machineCode.cabBookingLiner.repository;

import com.machineCode.cabBookingLiner.model.Trip;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anju
 * @created on 06/05/25 and 12:24 PM
 */
public class InMemoryTripRepo implements TripRepository{
    private final Map<String, Trip> trips = new ConcurrentHashMap<>();
    private final Map<String, List<Trip>> cabTrips = new ConcurrentHashMap<>();
    private final Map<String, List<Trip>> userTrips = new ConcurrentHashMap<>();



    @Override
    public void addTrip(Trip trip) {
        trips.put(trip.getId(), trip);
        cabTrips.computeIfAbsent(trip.getDriverId(), k-> new ArrayList<>()).add(trip);
        userTrips.computeIfAbsent(trip.getPassengerId(), k-> new ArrayList<>()).add(trip);
    }

    @Override
    public Optional<Trip> findById(String tripId) {
        return Optional.ofNullable(trips.get(tripId));
    }

    @Override
    public List<Trip> findTripsByCabId(String cabId) {
        return cabTrips.getOrDefault(cabId, Collections.emptyList());
    }

    @Override
    public List<Trip> findTripsByUserId(String userId) {
        return userTrips.getOrDefault(userId, Collections.emptyList());
    }

    @Override
    public void updateTrip(Trip trip) {
        trips.put(trip.getId(), trip);

    }




}
