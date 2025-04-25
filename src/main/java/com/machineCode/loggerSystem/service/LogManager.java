package com.machineCode.loggerSystem.service;

import com.machineCode.loggerSystem.model.LogLevel;
import com.machineCode.loggerSystem.service.chaining.*;
import com.machineCode.loggerSystem.service.decorator.TimeDecorator;
import com.machineCode.loggerSystem.service.impl.Logger;
import com.machineCode.loggerSystem.service.observer.ConsoleLogObserver;
import com.machineCode.loggerSystem.service.observer.FileLogObserver;

import static com.machineCode.loggerSystem.model.LogLevel.*;

/**
 * @author anju
 * @created on 24/04/25 and 7:45 PM
 */
public class LogManager {

//    public static BaseLogger dologChaining(){
//
//
//        BaseLogger debugLogger = new DebugLogger(DEBUG.getOrder());
//        BaseLogger infoLogger = new InfoLogger(INFO.getOrder());
//        BaseLogger errorLogger = new ErrorLogger(ERROR.getOrder());
//        BaseLogger warnLogger = new WarnLogger(WARN.getOrder());
//
//        debugLogger.setNextLogger(infoLogger);
//        infoLogger.setNextLogger(warnLogger);
//        warnLogger.setNextLogger(errorLogger);
//        errorLogger.setNextLogger(null);
//        // set system log level
//        return debugLogger; // return first logger in the chain
//    }

    public static LogSinkHandler addObservers(){
        LogSinkHandler logSinkHandler = new LogSinkHandler();
        ConsoleLogObserver consoleLogger = new ConsoleLogObserver();
        logSinkHandler.registerLogSink(INFO.getOrder(),consoleLogger);
        logSinkHandler.registerLogSink(DEBUG.getOrder(),consoleLogger);
        logSinkHandler.registerLogSink(ERROR.getOrder(),consoleLogger);
        logSinkHandler.registerLogSink(WARN.getOrder(),consoleLogger);


        FileLogObserver fileLogger = new FileLogObserver("abc.log");
        logSinkHandler.registerLogSink(INFO.getOrder(),fileLogger);
        return logSinkHandler;
    }

}
