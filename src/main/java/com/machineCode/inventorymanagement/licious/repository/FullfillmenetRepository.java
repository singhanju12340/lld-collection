package com.machineCode.inventorymanagement.licious.repository;

import com.machineCode.inventorymanagement.licious.model.FulfillmentCenter;
import com.machineCode.inventorymanagement.licious.model.LOrder;
import com.machineCode.inventorymanagement.licious.model.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anju
 * @created on 26/04/25 and 4:09 PM
 */
public class FullfillmenetRepository {
    Map<String, FulfillmentCenter> fulfillmentCenters = new HashMap<>();

    public void addFulfillmentCenter(FulfillmentCenter fulfillmentCenter) {
        fulfillmentCenters.put(fulfillmentCenter.getId(), fulfillmentCenter);
    }

    public void updateFulfillmentCenter(FulfillmentCenter fulfillmentCenter) {
        fulfillmentCenters.put(fulfillmentCenter.getId(), fulfillmentCenter);
    }

    public List<FulfillmentCenter> getMatchingFullfillmentCenter(String productId, int quantity, Location address) {
        List<FulfillmentCenter> allfcCenter = new ArrayList<>();
        for(FulfillmentCenter fulfillmentCenter : fulfillmentCenters.values()){

            if(fulfillmentCenter.getInventory().containsKey(productId) &&
                    fulfillmentCenter.getInventory().get(productId) >= quantity) {
                allfcCenter.add(fulfillmentCenter);
            }
        }

        // either use db which gives data sorted based on lat and long like postgress
        // order call seperate location service on the found list of fcs and fetch the best one
        return allfcCenter;
    }
}
