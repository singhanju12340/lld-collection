package com.machineCode.inventorymanagement.licious.service;

import com.machineCode.inventorymanagement.licious.exception.LiciousOrderException;
import com.machineCode.inventorymanagement.licious.model.LOrder;

/**
 * @author anju
 * @created on 26/04/25 and 4:05 PM
 */
public interface FulfillmentService {

    public boolean canfullfill(LOrder orderId);
    public void fulfillOrder(LOrder orderId) throws LiciousOrderException;
}
