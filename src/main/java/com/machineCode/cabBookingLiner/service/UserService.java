package com.machineCode.cabBookingLiner.service;

import com.machineCode.cabBookingLiner.model.RideUser;
import com.machineCode.cabBookingLiner.model.Trip;
import com.machineCode.cabBookingLiner.repository.UserRepository;

import java.util.Optional;

/**
 * @author anju
 * @created on 06/05/25 and 12:56 PM
 */
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RideUser registerUser(String userId) {
        RideUser user = new RideUser(userId);
        userRepository.addUser(user);
        return user;
    }

    public Optional<RideUser> getUser(String userId) {
        return userRepository.findById(userId);
    }

    public void updateUserLastTrip(String userId, Trip trip) {
        userRepository.findById(userId).ifPresent(user -> {
            user.setLastTrip(trip);
            userRepository.updateUser(user);
        });
    }
}
