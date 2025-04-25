package com.machineCode.loggerSystem.service;

import com.machineCode.loggerSystem.model.LogLevel;

import java.util.Arrays;

/**
 * @author anju
 * @created on 24/04/25 and 7:32 PM
 */
public  class BaseLogger {
    public static volatile int level=2;

    public String getLevelName(int order){
        return Arrays.stream(LogLevel.values())
                .filter(logLevel -> logLevel.getOrder() == order)
                .map(LogLevel::getLevelName)
                .findFirst()
                .orElse("Unknown");
    }


    public void logMessage(int messagelevel, String message, LogAppendHandler logSinkHandler) {
        if (this.level <= messagelevel) {
            write(messagelevel, message, logSinkHandler);
            return; // do not need to print message in all the chain level
        }
    }

    public  void write(Integer level, String message, LogAppendHandler logSinkHandler){
        logSinkHandler.notifyLogSinks(level,getLevelName(level)+" : "+message);
    }

}
