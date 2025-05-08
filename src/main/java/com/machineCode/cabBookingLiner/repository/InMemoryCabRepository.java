package com.machineCode.cabBookingLiner.repository;

import com.machineCode.cabBookingLiner.model.Cab;
import com.machineCode.cabBookingLiner.model.Location;
import com.machineCode.cabBookingLiner.model.Trip;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author anju
 * @created on 06/05/25 and 12:18 PM
 */
public class InMemoryCabRepository implements CabRepository{
    private final Map<String, Cab> cabs = new ConcurrentHashMap<>();

    @Override
    public void addCab(Cab cab) {
        cabs.put(cab.getId(), cab);
    }

    @Override
    public Optional<Cab> findById(String cabId) {
        return Optional.ofNullable(cabs.get(cabId));
    }

    @Override
    public List<Cab> findAvailableCabsWithinRadius(Location location, int radius) {
        return cabs.values().stream()
                .filter(cab -> cab.isAvailable() &&
                        cab.getLocation().distance(location) <= radius)
                .sorted(Comparator.comparingInt(cab ->
                        cab.getLocation().distance(location)))
                .collect(Collectors.toList());
    }

    @Override
    public void updateCab(Cab cab) throws Exception {
        if(!cabs.containsKey(cab.getId())){
            throw  new Exception("invalid cab to update");
        }else{
            cabs.put(cab.getId(), cab);
        }
    }



}
