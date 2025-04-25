package com.machineCode.loggerSystem.service.impl;

import com.machineCode.loggerSystem.model.LogLevel;
import com.machineCode.loggerSystem.service.LogManager;
import com.machineCode.loggerSystem.service.LogService;
import com.machineCode.loggerSystem.service.LogSinkHandler;
import com.machineCode.loggerSystem.service.chaining.BaseLogger;
import com.machineCode.loggerSystem.service.decorator.TimeDecorator;

/**
 * @author anju
 * @created on 01/02/25 and 11:02 AM
 */

public class Logger implements LogService {
    private static Logger logger;
    private volatile static BaseLogger chainOfLogger;
    private volatile static LogSinkHandler logSinkHandler;
    private static LogService decoratedLogger;

    private Logger() {
        // private constructor to prevent instantiation
        LogService logService = new LogService() {
            @Override
            public void info(String message) {
                chainOfLogger.logMessage(LogLevel.INFO.getOrder(), message, logSinkHandler);
            }

            @Override
            public void debug(String message) {
                chainOfLogger.logMessage(LogLevel.DEBUG.getOrder(), message, logSinkHandler);
            }

            @Override
            public void warn(String message) {
                chainOfLogger.logMessage(LogLevel.WARN.getOrder(), message, logSinkHandler);
            }

            @Override
            public void error(String message) {
                chainOfLogger.logMessage(LogLevel.ERROR.getOrder(), message, logSinkHandler);
            }
        };

        decoratedLogger = new TimeDecorator(logService);
    }

    public static Logger getInstance() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    // Initialize the logger and other components here
                    chainOfLogger = LogManager.dologChaining();
                    logSinkHandler = LogManager.addObservers();
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    @Override
    public void info(String message) {
        decoratedLogger.info(message);
    }

    @Override
    public void debug(String message) {
        decoratedLogger.debug(message);
    }

    @Override
    public void warn(String message) {
        decoratedLogger.warn(message);
    }

    @Override
    public void error(String message) {
        decoratedLogger.error(message);
    }
}
