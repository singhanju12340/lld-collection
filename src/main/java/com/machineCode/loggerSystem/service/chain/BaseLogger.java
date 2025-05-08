package com.machineCode.loggerSystem.service.chain;

import com.machineCode.loggerSystem.model.LogLevel;
import com.machineCode.loggerSystem.service.LogAppendHandler;

import java.util.Arrays;

import static com.machineCode.loggerSystem.service.LogDataManager.systemLevel;

/**
 * @author anju
 * @created on 24/04/25 and 7:32 PM
 */

public abstract class BaseLogger {
    private BaseLogger nextLogger;
    protected int level;

    public String getLevelName(int order){
        return Arrays.stream(LogLevel.values())
                .filter(logLevel -> logLevel.getOrder() == order)
                .map(LogLevel::getLevelName)
                .findFirst()
                .orElse("Unknown");
    }

    public void setNext(BaseLogger nextLogger) {
        this.nextLogger = nextLogger;
    }


    public void logMessage(int messagelevel, String message, LogAppendHandler logSinkHandler) {
        if(systemLevel > messagelevel){
            return;
        }
        if (this.level == messagelevel) {
            write(messagelevel, message, logSinkHandler);
        } else if(nextLogger!=null){
            nextLogger.logMessage(messagelevel, message, logSinkHandler);
        }
    }

    public  void write(Integer level, String message, LogAppendHandler logSinkHandler){
        logSinkHandler.notifyLogSinks(level,getLevelName(level)+" : "+message);
    }

}
