package com.machineCode.inventorymanagement.licious;

import com.machineCode.inventorymanagement.licious.model.FulfillmentCenter;
import com.machineCode.inventorymanagement.licious.model.Location;
import com.machineCode.inventorymanagement.licious.repository.FullfillmenetRepository;
import com.machineCode.inventorymanagement.licious.service.FulfillmentService;
import com.machineCode.inventorymanagement.licious.service.FullfillmentServiceImpl;
import com.machineCode.inventorymanagement.licious.service.OrderService;
import com.machineCode.inventorymanagement.licious.service.OrderServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anju
 * @created on 26/04/25 and 4:21 PM
 */
public class LiciousDataManager {
    public static FulfillmentService initFullfillmentCenterService() {
        FullfillmenetRepository fullfillmenetRepository = new FullfillmenetRepository();



        fullfillmenetRepository.addFulfillmentCenter(new FulfillmentCenter(
                Map.of("Fish", 100, "Chicken", 100, "Mutton", 100),
                new Location(34223L, 23423L)
        ));

        fullfillmenetRepository.addFulfillmentCenter(new FulfillmentCenter(
                Map.of("Fish", 0, "Chicken", 5, "Mutton", 1),
                new Location(342L, 223L)
        ));


        FulfillmentService fullfillmentCenterService = new FullfillmentServiceImpl(fullfillmenetRepository);
        return fullfillmentCenterService;
    }

    public static OrderService getOrderService() {
        return new OrderServiceImpl();
    }


}
