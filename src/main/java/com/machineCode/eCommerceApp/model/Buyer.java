package com.machineCode.eCommerceApp.model;

import lombok.Data;

/**
 * @author anju
 * @created on 23/04/25 and 7:18 PM
 */

@Data
public class Buyer {
    private String userId;
    private final Address address;
}
