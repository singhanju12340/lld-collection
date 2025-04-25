package com.machineCode.eCommerceAppImproved.model;

import com.machineCode.eCommerceApp.model.Address;
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
