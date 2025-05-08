package com.machineCode.inventorymanagement.licious.service.chain;

import com.machineCode.inventorymanagement.licious.model.LOrder;
import com.machineCode.inventorymanagement.licious.repository.LOrderRespoitory;

import static com.machineCode.inventorymanagement.licious.model.OrderStatus.FAILED;

/**
 * @author anju
 * @created on 26/04/25 and 5:23 PM
 */
public class ProcessFail extends ProcessOrder{
    LOrderRespoitory respoitory;

    public ProcessFail() {
        this.respoitory = LOrderRespoitory.getInstance();
    }

    @Override
    public void process(LOrder order) {
        System.out.println("Processing order...FAILED");
        order.setOrderStatus(FAILED.toString());
        respoitory.updateOrder(order);

        setNext(new NotifyUser());
        nextOrderProcessor.process(order);
    }
}
