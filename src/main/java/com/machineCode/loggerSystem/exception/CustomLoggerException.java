package com.machineCode.loggerSystem.exception;

import com.machineCode.loggerSystem.utils.ErrorCode;

/**
 * @author anju
 * @created on 01/02/25 and 11:27 AM
 */
public class CustomLoggerException extends RuntimeException{
    private String errorCode;
    private String message;

    public CustomLoggerException(String errorCode, String message) {
        super(message);
    }
}
