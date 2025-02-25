package com.machineCode.designPatterns.structural.decorator;

/**
 * @author anju
 * @created on 25/02/25 and 1:26 PM
 */
public class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);

    }

    @Override
    public void sendNotification(String message) {
// First, delegate to the wrapped notification.
        super.sendNotification(message);
        // Then add email-specific functionality.
        sendSMS(message);
    }


    private void sendSMS(String message) {
        System.out.println("Sending SMS notification: " + message);
        // Add actual email sending logic here.
    }
}
