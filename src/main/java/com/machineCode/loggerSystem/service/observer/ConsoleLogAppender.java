package com.machineCode.loggerSystem.service.observer;

import com.machineCode.loggerSystem.service.logPattern.Pattern;

/**
 * @author anju
 * @created on 24/04/25 and 7:36 PM
 */
public class ConsoleLogAppender implements LogAppender {
    Pattern pattern;

    public ConsoleLogAppender(Pattern pattern) {
        this.pattern = pattern;
    }

    public void append(String message) {
        System.out.println("Console Log: " + pattern.format(message));
    }

}
