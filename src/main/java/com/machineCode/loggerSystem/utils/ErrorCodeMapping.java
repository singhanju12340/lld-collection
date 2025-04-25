package com.machineCode.loggerSystem.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anju
 * @created on 24/04/25 and 7:29 PM
 */
public class ErrorCodeMapping {
    public static Map<String, String> errorMessage = new HashMap<>();

    static {
        errorMessage.put(ErrorCode.ERROR_CODE_100, "Error code 100: Invalid input");
    }
}
