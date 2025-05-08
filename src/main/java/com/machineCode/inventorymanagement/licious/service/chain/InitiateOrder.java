package com.machineCode.inventorymanagement.licious.service.chain;

import com.machineCode.inventorymanagement.licious.model.LOrder;
import com.machineCode.inventorymanagement.licious.service.OrderService;

/**
 * @author anju
 * @created on 26/04/25 and 5:23 PM
 */
public class InitiateOrder extends ProcessOrder{
    OrderService orderService;

    public InitiateOrder(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void process(LOrder order) {
        System.out.println("Processing order...Initiate");
        orderService.placeOrder(order);
        setNext(new FullFillOrder());
        nextOrderProcessor.process(order);
    }
}
