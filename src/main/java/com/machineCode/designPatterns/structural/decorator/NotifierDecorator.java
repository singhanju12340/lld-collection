package com.machineCode.designPatterns.structural.decorator;

/**
 * @author anju
 * @created on 25/02/25 and 1:37 PM
 */
public abstract class NotifierDecorator implements Notifier{
    Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void sendNotification(String message) {
        notifier.sendNotification(message);
    }
}
