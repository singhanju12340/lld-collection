package com.machineCode.eCommerceAppImproved.service.observer;

import com.machineCode.eCommerceAppImproved.model.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 24/04/25 and 12:40 PM
 */
public class OrderObserverHandler {
    private static List<OrderObserver> obervers= new ArrayList<>();

    public void addObserverver(OrderObserver orderObserver){
        obervers.add(orderObserver);
    }

    public void notify(Order order){
        for(OrderObserver ob: obervers){
            ob.update(order);
        }
    }
}
