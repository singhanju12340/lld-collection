package com.machineCode.eCommerceAppImproved.service.observer;

import com.machineCode.eCommerceAppImproved.model.Order;

/**
 * @author anju
 * @created on 24/04/25 and 12:37 PM
 */
public interface OrderObserver {
    public void update(Order order);
}
