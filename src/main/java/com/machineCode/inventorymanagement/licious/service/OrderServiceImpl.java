package com.machineCode.inventorymanagement.licious.service;

import com.machineCode.inventorymanagement.licious.exception.LiciousOrderException;
import com.machineCode.inventorymanagement.licious.model.LOrder;
import com.machineCode.inventorymanagement.licious.repository.LOrderRespoitory;

import static com.machineCode.inventorymanagement.licious.LiciousDataManager.initFullfillmentCenterService;
import static com.machineCode.inventorymanagement.licious.model.OrderStatus.*;

/**
 * @author anju
 * @created on 26/04/25 and 4:21 PM
 */
public class OrderServiceImpl implements OrderService{
    LOrderRespoitory lOrderRespoitory;
    FulfillmentService fulfillmentService;

    public OrderServiceImpl() {
        this.lOrderRespoitory = LOrderRespoitory.getInstance();
        this.fulfillmentService = initFullfillmentCenterService();
    }

//    @Override
//    public boolean placeOrder(LOrder order) {
//        try{
//            lOrderRespoitory.addOrder(order);
//            fulfillmentService.fulfillOrder(order);
//
//            order.setOrderStatus(SUCCESS.toString());
//
//            lOrderRespoitory.updateOrder(order);
//        }catch (LiciousOrderException e){
//            order.setOrderStatus(FAILED.toString());
//            lOrderRespoitory.updateOrder(order);
//            // handle exception
//            // mark order to failed
//            // send notification to user
//            // send notification to fulfillment center
//            return false;
//        }
//
//        // create order entry
//        // and mark order to pending
//        // check fullfillment center if success
//        // mark order to success
//        return false;
//    }


    @Override
    public boolean placeOrder(LOrder order) {
        lOrderRespoitory.addOrder(order);
        return false;
    }

    @Override
    public void cancelOrder(LOrder orderId) {

    }
}
