package com.machineCode.loggerSystem.service;

import com.machineCode.loggerSystem.service.observer.AppenderFactory;
import com.machineCode.loggerSystem.service.observer.LogAppender;
import com.machineCode.loggerSystem.utils.AppenderConfig;

/**
 * @author anju
 * @created on 24/04/25 and 7:45 PM
 */
public class LogManager {


    public static LogAppendHandler addObservers(){
        BaseLogger.level = 2;


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


//        logSinkHandler.registerLogAppender(INFO.getOrder(),consoleLogAppender);

        logSinkHandler.registerLogAppender(BaseLogger.level,consoleLogAppender);


        logSinkHandler.registerLogAppender(4,fileLogAppender);

        return logSinkHandler;
    }

}
