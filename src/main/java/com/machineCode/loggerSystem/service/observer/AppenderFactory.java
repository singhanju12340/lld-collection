package com.machineCode.loggerSystem.service.observer;

import com.machineCode.loggerSystem.service.pattern.TimeLevelPattern;
import com.machineCode.loggerSystem.utils.AppenderConfig;

/**
 * @author anju
 * @created on 25/04/25 and 3:10 PM
 */
public class AppenderFactory {
    public static LogAppender createAppender(AppenderConfig config) {
        switch (config.getType()) {
            case "ConsoleAppender":
                return new ConsoleLogAppender(new TimeLevelPattern());
            case "FileAppender":
                return new FileLogAyncAppender( config.getFilePath(), new TimeLevelPattern());
            default:
                throw new IllegalArgumentException("Unknown Appender type: " + config.getType());
        }
    }
}
