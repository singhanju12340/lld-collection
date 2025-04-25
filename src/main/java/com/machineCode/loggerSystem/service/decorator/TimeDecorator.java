package com.machineCode.loggerSystem.service.decorator;

import com.machineCode.loggerSystem.service.LogService;

import java.time.Instant;

/**
 * @author anju
 * @created on 24/04/25 and 8:55 PM
 */
public class TimeDecorator implements LogService {
    private LogService decoratedLogger;

    public TimeDecorator(LogService logger){
        this.decoratedLogger = logger;
    }

    @Override
    public void info(String message){
        decoratedLogger.info(Instant.now().toString()+" : "+message);
    }

    @Override
    public void debug(String message) {
        decoratedLogger.debug(Instant.now().toString()+" : "+message);
    }

    @Override
    public void warn(String message) {
        decoratedLogger.warn(Instant.now().toString()+" : "+message);
    }

    @Override
    public void error(String message) {
        decoratedLogger.error(Instant.now().toString()+" : "+message);
    }

}
