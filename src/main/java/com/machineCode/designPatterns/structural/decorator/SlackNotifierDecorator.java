package com.machineCode.designPatterns.structural.decorator;

/**
 * @author anju
 * @created on 25/02/25 and 1:26 PM
 */
public class SlackNotifierDecorator extends NotifierDecorator{

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void sendNotification(String message) {
// First, delegate to the wrapped notification.
        super.sendNotification(message);
        // Then add email-specific functionality.
        sendSlack(message);
    }


    private void sendSlack(String message) {
        System.out.println("Sending slack notification: " + message);
        // Add actual email sending logic here.
    }
}
