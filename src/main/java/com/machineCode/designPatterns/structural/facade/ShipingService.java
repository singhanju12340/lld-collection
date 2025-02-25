package com.machineCode.designPatterns.structural.facade;

/**
 * @author anju
 * @created on 25/02/25 and 1:55 PM
 */
public class ShipingService {
    
    public void shipProduct(String productId, int quantity, String address) {
        System.out.println("Shipping " + quantity + " of product " + productId + " to address " + address);
    }
}
