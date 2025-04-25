package com.machineCode.loggerSystem.service.decorator;

import com.machineCode.loggerSystem.service.LogService;

import static com.machineCode.loggerSystem.model.LogLevel.*;

/**
 * @author anju
 * @created on 24/04/25 and 9:04 PM
 */
public class LogLevelDecorator implements LogService{
    private LogService decoratedLogger;

    public LogLevelDecorator(LogService logService){
        this.decoratedLogger = logService;
    }

    @Override
    public void info(String message){
        decoratedLogger.info(INFO.getLevelName()+" : "+message);
    }

    @Override
    public void error(String message){
        decoratedLogger.error(ERROR.getLevelName()+" : "+message);
    }

    @Override
    public void debug(String message){
        decoratedLogger.debug(DEBUG.getLevelName()+" : "+message);
    }

    @Override
    public void warn(String message){
        decoratedLogger.warn(WARN.getLevelName()+" : "+message);
    }
}
