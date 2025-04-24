package com.machineCode.eCommerceApp.utils;

import java.util.UUID;

/**
 * @author anju
 * @created on 23/04/25 and 7:32 PM
 */
public class EcommUtil {
    public static String generateId(){
        return UUID.randomUUID().toString(); // details about that
    }
}
