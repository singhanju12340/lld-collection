package com.machineCode.designPatterns.structural.decorator;

/**
 * @author anju
 * @created on 25/02/25 and 1:35 PM
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        // Create a basic notification.
        Notifier basicNotification = new BaseSystemConsoleNotifier();

        // Decorate with email notifications.
        Notifier emailNotification = new SMSNotifierDecorator(basicNotification);

        // Decorate further with SMS notifications.
        Notifier smsAndSlackNotification = new SlackNotifierDecorator(emailNotification);

        // When we call send(), all layers (basic, email, and SMS) will be invoked.
        smsAndSlackNotification.sendNotification("Your flight is delayed by 15 minutes.");

        // You can also use only one decorator:
        emailNotification.sendNotification("Your check-in is complete.");
    }
}
