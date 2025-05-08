package com.machineCode.cabBookingLiner.service;

import com.machineCode.cabBookingLiner.repository.*;
import com.machineCode.cabBookingLiner.service.facade.CabBookingFacade;

/**
 * @author anju
 * @created on 06/05/25 and 12:42 PM
 */
public class CabBookingFacadeFactory {

    public static CabBookingFacade createService(double farePerUnit) {

        // create repos
        CabRepository cabRepo = new InMemoryCabRepository();
        UserRepository userRepo = new InMemUserRepo();
        TripRepository tripRepo = new InMemoryTripRepo();


        // Create services
        UserService userService = new UserService(userRepo);
        CabService cabService = new CabService(cabRepo);
        TripService tripService = new TripService(tripRepo, userService, cabService);
        return new CabBookingFacade(userService, cabService, tripService);
    }
}
