package com.machineCode.cabBookingLiner.repository;

import com.machineCode.cabBookingLiner.model.RideUser;

import java.util.Optional;

/**
 * @author anju
 * @created on 06/05/25 and 12:17 PM
 */
public interface UserRepository {
    void addUser(RideUser user);
    Optional<RideUser> findById(String userId);
    void updateUser(RideUser user);
}
