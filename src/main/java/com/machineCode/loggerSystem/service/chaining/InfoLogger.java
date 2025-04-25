package com.machineCode.loggerSystem.service.chaining;

import com.machineCode.loggerSystem.service.LogSinkHandler;

/**
 * @author anju
 * @created on 24/04/25 and 7:46 PM
 */
public class InfoLogger extends BaseLogger {
    int level;
    BaseLogger nextLogger;

    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    public void write(Integer level, String message, LogSinkHandler logSinkHandler) {
        logSinkHandler.notifyLogSinks(level,getLevelName(level)+ " : "+message);
    }

}
