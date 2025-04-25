package com.machineCode.loggerSystem.exception;

import com.machineCode.loggerSystem.utils.ErrorCode;

/**
 * @author anju
 * @created on 01/02/25 and 11:27 AM
 */
public class CustomLoggerException extends RuntimeException{
    private ErrorCode errorCode;
    private String message;

    public CustomLoggerException(ErrorCode errorCode, String message) {
        super(message);
    }
}
