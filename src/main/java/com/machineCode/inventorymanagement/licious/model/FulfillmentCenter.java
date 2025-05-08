package com.machineCode.inventorymanagement.licious.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anju
 * @created on 26/04/25 and 4:05 PM
 */

@Data
public class FulfillmentCenter {
    private String id;
    private Location address;
    private Map<String, Integer> inventory;

    public FulfillmentCenter(Map<String, Integer> inventory, Location location) {
            this.id = "FulfillmentCenter" + System.currentTimeMillis();
            this.address = location;
            this.inventory = new HashMap<>(inventory);
    }


}
