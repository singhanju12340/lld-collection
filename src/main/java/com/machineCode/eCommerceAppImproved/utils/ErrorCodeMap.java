package com.machineCode.eCommerceAppImproved.utils;

import com.machineCode.eCommerceAppImproved.model.ErrorCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anju
 * @created on 23/04/25 and 7:30 PM
 */
public class ErrorCodeMap {
    public static Map<ErrorCode, String> errorCodeStringMap = new HashMap<>();

    static {
        errorCodeStringMap.put(ErrorCode.IN_SUFFICIENT_INVENTORY, "Insufficient inventory available");
        errorCodeStringMap.put(ErrorCode.ORDER_FAILED, "Your order failed due to txn issue");
        errorCodeStringMap.put(ErrorCode.PINCODE_UNSERVICEABLE, "Pin invalid");
        

    }

}
