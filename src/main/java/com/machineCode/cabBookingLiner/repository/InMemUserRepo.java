package com.machineCode.cabBookingLiner.repository;

import com.machineCode.cabBookingLiner.model.RideUser;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anju
 * @created on 06/05/25 and 12:24 PM
 */
public class InMemUserRepo implements UserRepository{
    private final Map<String, RideUser> users = new ConcurrentHashMap<>();

    @Override
    public void addUser(RideUser user) {
        users.put(user.getId(), user);

    }

    @Override
    public Optional<RideUser> findById(String userId) {
        return Optional.ofNullable(users.get(userId));
    }

    @Override
    public void updateUser(RideUser user) {
        users.put(user.getId(), user);
    }
}
