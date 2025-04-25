package com.machineCode.eCommerceAppImproved.model;

import com.machineCode.eCommerceAppImproved.model.Address;
import lombok.Data;


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
    private final String type;
    private double price;

    public Product(String id, String name, Integer quantity, Address address, String type, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.address = address;
        this.type = type;
    }
}
