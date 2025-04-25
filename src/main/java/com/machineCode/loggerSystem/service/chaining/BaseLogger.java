package com.machineCode.loggerSystem.service.chaining;

import com.machineCode.loggerSystem.model.LogLevel;
import com.machineCode.loggerSystem.service.LogSinkHandler;

import java.util.Arrays;

/**
 * @author anju
 * @created on 24/04/25 and 7:32 PM
 */
public abstract class BaseLogger {
    public static volatile int level;

    BaseLogger nextLogger;

    public String getLevelName(int order){
        return Arrays.stream(LogLevel.values())
                .filter(logLevel -> logLevel.getOrder() == order)
                .map(LogLevel::getLevelName)
                .findFirst()
                .orElse("Unknown");
    }


    public void setNextLogger(BaseLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int messagelevel, String message, LogSinkHandler logSinkHandler) {
        if (this.level <= messagelevel) {
            write(messagelevel, message, logSinkHandler);
            return; // do not need to print message in all the chain level
        }

//Not need to go for next logger and printing in all the chain level

//        if (nextLogger != null) {
//            nextLogger.logMessage(messagelevel, message, logSinkHandler);
//        }
    }

    public abstract void write(Integer level, String message, LogSinkHandler logSinkHandler);

}
