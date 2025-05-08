package com.machineCode.inventorymanagement.licious.service.chain;

import com.machineCode.inventorymanagement.licious.model.LOrder;
import com.machineCode.inventorymanagement.licious.repository.LOrderRespoitory;

import static com.machineCode.inventorymanagement.licious.model.OrderStatus.SUCCESS;

/**
 * @author anju
 * @created on 26/04/25 and 5:23 PM
 */
public class ProcessSuccess extends ProcessOrder{
    LOrderRespoitory respoitory;

    public ProcessSuccess() {
        this.respoitory = LOrderRespoitory.getInstance();
    }

    @Override
    public void process(LOrder order) {
        System.out.println("Processing order...Fulfill");
        order.setOrderStatus(SUCCESS.toString());
        respoitory.updateOrder(order);

        setNext(new NotifyUser());
        nextOrderProcessor.process(order);
    }

}
