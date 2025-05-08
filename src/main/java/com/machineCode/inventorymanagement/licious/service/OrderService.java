package com.machineCode.inventorymanagement.licious.service;

import com.machineCode.inventorymanagement.licious.model.LOrder;

/**
 * @author anju
 * @created on 26/04/25 and 4:02 PM
 */
public interface OrderService {
    public boolean placeOrder(LOrder order);
    public void cancelOrder(LOrder orderId);

}
