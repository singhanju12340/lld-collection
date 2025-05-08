package com.machineCode.loggerSystem.service.impl;

import com.machineCode.loggerSystem.model.LogLevel;
import com.machineCode.loggerSystem.service.LogDataManager;
import com.machineCode.loggerSystem.service.LogService;
import com.machineCode.loggerSystem.service.LogAppendHandler;
import com.machineCode.loggerSystem.service.chain.BaseLogger;

/**
 * @author anju
 * @created on 01/02/25 and 11:02 AM
 */

public class Logger implements LogService {
    private static Logger logger;
    private volatile static BaseLogger baseLogger;
    private volatile static LogAppendHandler logSinkHandler;



    public static Logger getInstance() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    // Initialize the logger and other components here
                    baseLogger = LogDataManager.doChaining();
                    logSinkHandler = LogDataManager.addObservers();
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    @Override
    public void info(String message) {

        baseLogger.logMessage(LogLevel.INFO.getOrder(), message, logSinkHandler);
    }

    @Override
    public void debug(String message) {
        baseLogger.logMessage(LogLevel.DEBUG.getOrder(), message, logSinkHandler);
    }

    @Override
    public void warn(String message) {
        baseLogger.logMessage(LogLevel.WARN.getOrder(), message, logSinkHandler);
    }

    @Override
    public void error(String message) {
        baseLogger.logMessage(LogLevel.ERROR.getOrder(), message, logSinkHandler);
    }

}
