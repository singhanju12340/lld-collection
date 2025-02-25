package com.machineCode.designPatterns.structural.decorator;

/**
 * @author anju
 * @created on 25/02/25 and 1:32 PM
 */
public class BaseSystemConsoleNotifier implements Notifier{
    public BaseSystemConsoleNotifier() {

    }

    @Override
    public void sendNotification(String message) {
        System.out.println("send notification");
    }
}
