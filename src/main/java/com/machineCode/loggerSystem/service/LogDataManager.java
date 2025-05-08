package com.machineCode.loggerSystem.service;

import com.machineCode.loggerSystem.service.chain.*;
import com.machineCode.loggerSystem.service.observer.AppenderFactory;
import com.machineCode.loggerSystem.service.observer.FileLogAyncAppender;
import com.machineCode.loggerSystem.service.observer.LogAppender;
import com.machineCode.loggerSystem.utils.AppenderConfig;

import static com.machineCode.loggerSystem.model.LogLevel.*;

/**
 * @author anju
 * @created on 24/04/25 and 7:45 PM
 */
public class LogDataManager {
    public static volatile int systemLevel=2;

    public static BaseLogger doChaining() {
        BaseLogger infoLogger = new InfoLogger();
        BaseLogger debugLogger = new DebugLogger();
        BaseLogger warnLogger = new WarnLogger();
        BaseLogger errorLogger = new ErrorLogger();

        debugLogger.setNext(infoLogger);
        infoLogger.setNext(warnLogger);
        warnLogger.setNext(errorLogger);
        return debugLogger;
    }


    public static LogAppendHandler addObservers(){
        LogAppendHandler logSinkHandler = new LogAppendHandler();

        //console appender config
        AppenderConfig consoleLoggerConfig = new AppenderConfig();
        consoleLoggerConfig.setType("ConsoleAppender");

        // file appender config
        AppenderConfig fileLoggerConfig = new AppenderConfig();
        fileLoggerConfig.setFilePath("abc.log");
        fileLoggerConfig.setType("FileAppender");
        fileLoggerConfig.setName("Async File Appender");

        AppenderFactory factory = new   AppenderFactory();

        LogAppender consoleLogAppender = factory.createAppender(consoleLoggerConfig);
        LogAppender fileLogAppender = factory.createAppender(fileLoggerConfig);


        logSinkHandler.registerLogAppender(INFO.getOrder(),consoleLogAppender);
//        logSinkHandler.registerLogAppender(INFO.getOrder(),fileLogAppender);

        logSinkHandler.registerLogAppender(WARN.getOrder(),consoleLogAppender);
        logSinkHandler.registerLogAppender(WARN.getOrder(),fileLogAppender);

        logSinkHandler.registerLogAppender(ERROR.getOrder(),consoleLogAppender);
        logSinkHandler.registerLogAppender(DEBUG.getOrder(),fileLogAppender);


        logSinkHandler.registerLogAppender(4,fileLogAppender);

        return logSinkHandler;
    }

}
