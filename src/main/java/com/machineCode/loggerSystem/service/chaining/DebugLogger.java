package com.machineCode.loggerSystem.service.chaining;

import com.machineCode.loggerSystem.service.LogSinkHandler;

/**
 * @author anju
 * @created on 24/04/25 and 7:47 PM
 */
public class DebugLogger extends BaseLogger {

    int level;
    BaseLogger nextLogger;

    public DebugLogger(int level) {
        this.level = level;
    }



    @Override
    public void write(Integer level, String message, LogSinkHandler logSinkHandler) {
        logSinkHandler.notifyLogSinks(level,getLevelName(level)+" : "+message);
    }


}

