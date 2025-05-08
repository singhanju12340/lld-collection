package com.machineCode.inventorymanagement.licious.exception;

/**
 * @author anju
 * @created on 26/04/25 and 4:14 PM
 */
public class LiciousOrderException extends Exception{
    String code;
    String message;

    public LiciousOrderException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
