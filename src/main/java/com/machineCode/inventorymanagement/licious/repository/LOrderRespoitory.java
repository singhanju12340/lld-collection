package com.machineCode.inventorymanagement.licious.repository;

import com.machineCode.inventorymanagement.licious.model.LOrder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anju
 * @created on 26/04/25 and 4:08 PM
 */
public class LOrderRespoitory {
    private static Map<String, LOrder> orders = new HashMap<>();

    public void addOrder(LOrder order) {
        orders.put(order.getOrderId(), order);
    }

    public LOrder getOrder(String orderId) {
        return orders.get(orderId);
    }

    public void removeOrder(String orderId) {
        orders.remove(orderId);
    }

    public Map<String, LOrder> getOrders() {
        return orders;
    }

    public void updateOrder(LOrder order) {
        orders.put(order.getOrderId(), order);
    }


    private static LOrderRespoitory lOrderRespoitory;

    private LOrderRespoitory() {
        orders = new HashMap<>();
    }

    public static LOrderRespoitory getInstance() {
        if (lOrderRespoitory == null) {
            lOrderRespoitory = new LOrderRespoitory();
        }
        return lOrderRespoitory;
    }
}