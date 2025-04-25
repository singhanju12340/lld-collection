package com.machineCode.loggerSystem.service.observer;

/**
 * @author anju
 * @created on 24/04/25 and 7:36 PM
 */
public class ConsoleLogObserver implements LogObserver {

    public void log(String message) {
        System.out.println("Console Log: " + message);
    }

}
