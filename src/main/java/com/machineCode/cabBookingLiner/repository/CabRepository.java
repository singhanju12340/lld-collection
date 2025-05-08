package com.machineCode.cabBookingLiner.repository;

import com.machineCode.cabBookingLiner.model.Cab;
import com.machineCode.cabBookingLiner.model.Location;
import com.machineCode.cabBookingLiner.model.Trip;

import java.util.List;
import java.util.Optional;

/**
 * @author anju
 * @created on 06/05/25 and 12:15 PM
 */
public interface CabRepository {

    public void addCab(Cab cab);
    Optional<Cab> findById(String cabId);
    List<Cab> findAvailableCabsWithinRadius(Location location, int radius);
    void updateCab(Cab cab) throws Exception;


}
