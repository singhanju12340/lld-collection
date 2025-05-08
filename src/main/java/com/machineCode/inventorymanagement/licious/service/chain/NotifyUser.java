package com.machineCode.inventorymanagement.licious.service.chain;

import com.machineCode.inventorymanagement.licious.model.LOrder;
import com.machineCode.inventorymanagement.licious.repository.LOrderRespoitory;

import static com.machineCode.inventorymanagement.licious.model.OrderStatus.SUCCESS;

/**
 * @author anju
 * @created on 26/04/25 and 5:25 PM
 */
public class NotifyUser extends ProcessOrder{
    LOrderRespoitory respoitory;

    public NotifyUser() {
        this.respoitory = LOrderRespoitory.getInstance();
    }

    @Override
    public void process(LOrder order) {
        if(null!=respoitory.getOrder(order.getOrderId()))
        {
            System.out.println("Notifying user about order status: " + order.getOrderStatus());
        }
        setNext(null);
    }
}
