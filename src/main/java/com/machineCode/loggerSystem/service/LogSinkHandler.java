package com.machineCode.loggerSystem.service;

import com.machineCode.loggerSystem.service.observer.LogObserver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anju
 * @created on 24/04/25 and 7:37 PM
 */
public class LogSinkHandler {
    Map<Integer, List<LogObserver>> logSinks = new HashMap<>();

    public void registerLogSink(int logLevel, LogObserver logObserver) {
        logSinks.computeIfAbsent(logLevel, k -> new java.util.ArrayList<>()).add(logObserver);
    }

    public void unregisterLogSink(int logLevel, LogObserver logObserver) {
        List<LogObserver> observers = logSinks.get(logLevel);
        if (observers != null) {
            observers.remove(logObserver);
        }
    }

    public void notifyLogSinks(int logLevel, String message) {
            List<LogObserver> observers = logSinks.get(logLevel);
            if (observers != null) {
                for (LogObserver observer : observers) {
                    observer.log(message);
                }
            }
        }
}
