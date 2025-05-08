package com.machineCode.inventorymanagement.licious.service.chain;

import com.machineCode.inventorymanagement.licious.model.LOrder;

/**
 * @author anju
 * @created on 26/04/25 and 5:22 PM
 */
public abstract class ProcessOrder {
    ProcessOrder nextOrderProcessor;
    public void process(LOrder order) {
        System.out.println("Processing order...");
    }

    public void setNext(ProcessOrder processOrder) {
        if(processOrder == null) {
            System.out.println("   order processing completed");
            return;
        }
        this.nextOrderProcessor = processOrder;
        System.out.println("    Setting next process order... "+ processOrder.getClass());
    }
}
