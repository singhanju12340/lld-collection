package com.machineCode.inventorymanagement.licious.model;

import lombok.Data;

/**
 * @author anju
 * @created on 26/04/25 and 4:02 PM
 */

@Data
public class LOrder {
    private String orderId;
    private String orderStatus;
    private String orderDate;
    private String deliveryDate;
    private String paymentMode;
    private Location deliveryAddress;
    private String productId;
    private int quantity;



    // Getters and Setters
}
