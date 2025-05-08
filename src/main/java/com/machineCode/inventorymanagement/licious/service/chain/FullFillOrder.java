package com.machineCode.inventorymanagement.licious.service.chain;

import com.machineCode.inventorymanagement.licious.exception.LiciousOrderException;
import com.machineCode.inventorymanagement.licious.model.LOrder;
import com.machineCode.inventorymanagement.licious.service.FulfillmentService;

import static com.machineCode.inventorymanagement.licious.LiciousDataManager.initFullfillmentCenterService;

/**
 * @author anju
 * @created on 26/04/25 and 5:27 PM
 */
public class FullFillOrder extends ProcessOrder{

    FulfillmentService  fulfillmentService;

    public FullFillOrder() {
        this.fulfillmentService = initFullfillmentCenterService();
    }

    @Override
    public void process(LOrder order) {
        try{
            System.out.println("Processing order...Fulfill");
            fulfillmentService.fulfillOrder(order);
            setNext(new ProcessSuccess());
            nextOrderProcessor.process(order);
        }catch (LiciousOrderException e){
            setNext(new ProcessFail());
            nextOrderProcessor.process(order);
        }
    }
}
