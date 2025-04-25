package com.machineCode.loggerSystem.model;

import lombok.Data;

/**
 * @author anju
 * @created on 25/04/25 and 3:06 PM
 */
@Data
public class LogMessage {
    private int level;
    private String message;
    private String className;
    private String methodName;
    private String threadName;
}
