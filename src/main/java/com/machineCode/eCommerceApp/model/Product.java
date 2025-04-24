package com.machineCode.eCommerceApp.model;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author anju
 * @created on 23/04/25 and 7:14 PM
 */

@Data
public class Product {
    private final String id;
    private final String name;
    private Integer quantity;
    private final Address address;

    public Product(String id, String name, Integer quantity, Address address) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.address = address;
    }
}
