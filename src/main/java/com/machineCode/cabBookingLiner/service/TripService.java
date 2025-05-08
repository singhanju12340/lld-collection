package com.machineCode.cabBookingLiner.service;

import com.machineCode.cabBookingLiner.model.Cab;
import com.machineCode.cabBookingLiner.model.Location;
import com.machineCode.cabBookingLiner.model.RideUser;
import com.machineCode.cabBookingLiner.model.Trip;
import com.machineCode.cabBookingLiner.repository.TripRepository;
import com.machineCode.cabBookingLiner.util.Constant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.locks.Lock;

/**
 * @author anju
 * @created on 06/05/25 and 12:27 PM
 */
public class TripService {
    private final TripRepository tripRepository;

    private final UserService userService;
    private final CabService cabService;

    private final double farePerUnit = Constant.contantFare;

    public TripService(TripRepository tripRepository, UserService userService, CabService cabService) {
        this.tripRepository = tripRepository;
        this.userService = userService;
        this.cabService = cabService;
    }


    public Optional<Trip> bookCab(String userId, Location pickupLocation, int searchRadius) {
        Optional<RideUser> userOpt = userService.getUser(userId);
        if (userOpt.isEmpty()) {
            System.out.println("Invalid user ");
            return Optional.empty();
        }
// find nearest cab
        List<Cab> availableCabs = cabService.findAvailableCabsWithinRadius(pickupLocation, searchRadius);
        if (availableCabs.isEmpty()) {
            return Optional.empty();
        }

        Cab nearestCab = availableCabs.get(0);
        Lock cabLock = nearestCab.getLock();

        try {
            cabLock.lock();

            // Double check availability after acquiring lock
            if (!nearestCab.isAvailable()) {
                return Optional.empty();
            }

            // Mark cab as unavailable
            nearestCab.setAvailable(false);
            cabService.updateCabAvailability(nearestCab.getId(), nearestCab.isAvailable(), null);

            // Create trip (fare will be calculated when trip ends)
            String tripId = UUID.randomUUID().toString();
            Trip trip = new Trip(tripId, nearestCab.getId(), userId,
                    pickupLocation, null, 0, 0);

            tripRepository.addTrip(trip);
            return Optional.of(trip);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            cabLock.unlock();
        }
    }

    public boolean endTrip(String tripId, Location dropLocation, double tip) {
        Optional<Trip> tripOpt = tripRepository.findById(tripId);
        if (tripOpt.isEmpty()) {
            return false;
        }

        Trip trip = tripOpt.get();
        Optional<Cab> cabOpt = cabService.getCab(trip.getDriverId());
        Optional<RideUser> userOpt = userService.getUser(trip.getPassengerId());

        if (cabOpt.isEmpty() || userOpt.isEmpty()) {
            return false;
        }

        Cab cab = cabOpt.get();
        RideUser user = userOpt.get();
        Lock cabLock = cab.getLock();
        try {
            cabLock.lock();

            // Calculate fare
            int distance = trip.getStartPoint().distance(dropLocation);
            double fare = distance * farePerUnit;
            trip.endTrip();

            // For simplicity, assuming we can update
            trip.setDropPoint(dropLocation);
            trip.setFare(fare);
            trip.setTip(tip);

            cab.setAvailable(true);
            cab.setLocation(dropLocation);

            user.setLastTrip(trip);
            // Persist changes
            tripRepository.updateTrip(trip);
            cabService.updateCabAvailability(cab.getId(), cab.isAvailable(), cab.getLocation());
            userService.updateUserLastTrip(user.getId(), trip);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            cabLock.unlock();
        }
    }

    public List<Trip> getCabTrips(String cabId) {
        return tripRepository.findTripsByCabId(cabId);
    }



    public double getCabTotalEarnings(String cabId) {
        return tripRepository.findTripsByCabId(cabId).stream()
                .mapToDouble(Trip::getFare)
                .sum();
    }

    public List<Trip> getUserTrips(String userId) {
        return tripRepository.findTripsByUserId(userId);
    }



    public double calculateCabTips(String cabId) {
        return tripRepository.findTripsByCabId(cabId).stream()
                .mapToDouble(Trip::getTip)
                .sum();
    }


}
