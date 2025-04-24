package com.machineCode.eCommerceApp.model;

import lombok.Data;

import java.util.List;

/**
 * @author anju
 * @created on 23/04/25 and 7:21 PM
 */

@Data
public class AmazonUser {
    private final String name;
    private final String id;
    private Address addresses; // can be  a list

    public AmazonUser(String name, String id, Address addresses) {
        this.name = name;
        this.id = id;
        this.addresses = addresses;
    }
}
