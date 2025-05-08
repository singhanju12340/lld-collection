package com.machineCode.cabBookingLiner.service;

import com.machineCode.cabBookingLiner.model.Cab;
import com.machineCode.cabBookingLiner.model.Location;
import com.machineCode.cabBookingLiner.repository.CabRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author anju
 * @created on 06/05/25 and 12:57 PM
 */
public class CabService {
    private final CabRepository cabRepository;

    public CabService(CabRepository cabRepository) {
        this.cabRepository = cabRepository;
    }


    public Cab registerCab(String cabId, Location location) {
        Cab cab = new Cab(cabId, location);
        cabRepository.addCab(cab);
        return cab;
    }

    public Optional<Cab> getCab(String cabId) {
        return cabRepository.findById(cabId);
    }

    public List<Cab> findAvailableCabsWithinRadius(Location location, int radius) {
        return cabRepository.findAvailableCabsWithinRadius(location, radius);
    }

    public void updateCabAvailability(String cabId, boolean available, Location newLocation) {
        cabRepository.findById(cabId).ifPresent(cab -> {
            cab.setAvailable(available);
            if (newLocation != null) {
                cab.setLocation(newLocation);
            }
            try {
                cabRepository.updateCab(cab);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


}
