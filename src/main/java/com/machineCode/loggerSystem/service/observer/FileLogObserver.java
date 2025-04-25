package com.machineCode.loggerSystem.service.observer;

/**
 * @author anju
 * @created on 24/04/25 and 8:26 PM
 */
public class FileLogObserver implements LogObserver{
    @Override
    public void log(String message) {
        System.out.println("File Log: " + message);
    }
}
