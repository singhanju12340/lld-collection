package com.machineCode.inventorymanagement.licious;

import com.machineCode.inventorymanagement.licious.model.LOrder;
import com.machineCode.inventorymanagement.licious.model.Location;
import com.machineCode.inventorymanagement.licious.service.OrderService;
import com.machineCode.inventorymanagement.licious.service.OrderServiceImpl;
import com.machineCode.inventorymanagement.licious.service.chain.InitiateOrder;
import com.machineCode.inventorymanagement.licious.service.chain.ProcessOrder;

import static com.machineCode.inventorymanagement.licious.LiciousDataManager.getOrderService;

/**
 * @author anju
 * @created on 26/04/25 and 4:28 PM
 */
public class OrderDriver {

    private static LOrder createOrder1(){
        LOrder order = new LOrder();
        order.setOrderId("1");
        order.setProductId("Chicken");
        order.setQuantity(2);
        order.setOrderStatus("Pending");
        order.setDeliveryAddress(new Location(123242L, 2132423L));
        return order;
    }

    public static void main(String[] args) {
        ProcessOrder orderState = new InitiateOrder(getOrderService());
        LOrder order = createOrder1();

        orderState.process(order);
    }
}
