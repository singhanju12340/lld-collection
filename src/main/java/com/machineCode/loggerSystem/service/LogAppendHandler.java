package com.machineCode.loggerSystem.service;

import com.machineCode.loggerSystem.model.LogLevel;
import com.machineCode.loggerSystem.service.observer.LogAppender;
import org.glassfish.grizzly.compression.lzma.impl.Base;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author anju
 * @created on 24/04/25 and 7:37 PM
 */
public class LogAppendHandler {
    Map<Integer, Set<LogAppender>> logSinks = new HashMap<>();

    public void registerLogAppender(int logLevel, LogAppender logObserver) {
        Set<LogLevel> logLevelSet = Arrays.stream(LogLevel.values())
                .filter(levels -> levels.getOrder()>=logLevel)
                .collect(Collectors.toSet());

        // add appender in all the log level who has priority above to current level
        for (LogLevel level : logLevelSet) {
            logSinks.computeIfAbsent(level.getOrder(), k -> new HashSet<>()).add(logObserver);
        }
    }

    public void unregisterLogAppender(int logLevel, LogAppender logObserver) {
        Set<LogAppender> observers = logSinks.get(logLevel);
        if (observers != null) {
            observers.remove(logObserver);
        }
    }


    // apend message to all the applicable appender observer
    public void notifyLogSinks(int messageLogLevel, String message) {
        //TODO instead of fetching list of appender everytime, create concreate list while adding appender

        Set<LogAppender> observers = logSinks.get(messageLogLevel);
        if (observers != null) {
            for (LogAppender observer : observers) {
                observer.append(message);
            }
        }
    }
}
