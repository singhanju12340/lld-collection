package com.machineCode.eCommerceApp.model;

import lombok.Data;

/**
 * @author anju
 * @created on 23/04/25 and 7:20 PM
 */

@Data
public class Address {
    private final String id;
    private final String line1;
    private final String line2;
    private final String pincode;
    private final String lat;
    private final String lang;
    private String isPrimary;
}
