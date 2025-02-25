package com.machineCode.designPatterns.structural.facade;

/**
 * @author anju
 * @created on 25/02/25 and 1:55 PM
 */
public class InventoryService {

    public boolean checkAvailability(String productId, int quantity) {
        System.out.println("Checking inventory for product " + productId + " with quantity " + quantity);
        // Simulate availability check
        return true;
    }

    public void reserveProduct(String productId, int quantity) {
        System.out.println("Reserving " + quantity + " of product " + productId);
    }
}
