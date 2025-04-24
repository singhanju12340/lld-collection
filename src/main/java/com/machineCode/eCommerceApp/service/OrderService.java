package com.machineCode.eCommerceApp.service;

import com.machineCode.eCommerceApp.model.Order;

/**
 * @author anju
 * @created on 23/04/25 and 9:23 PM
 */
public interface OrderService {

    public Order getOrder(String orderId);

    public Order placeOrder(Order order);
}
