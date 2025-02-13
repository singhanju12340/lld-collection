package com.machineCode.pubSubsWithoutPersistence.subs;

import com.machineCode.pubSubsWithoutPersistence.storage.Message;

/**
 * @author anju
 * @created on 05/01/25 and 7:40 PM
 */

//Decorator pattern

public class SubscriberImplDecorator implements Subscriber{
    private final SubscriberImpl wrappedSubscriber;

    public SubscriberImplDecorator(SubscriberImpl wrappedSubscriber) {
        this.wrappedSubscriber = wrappedSubscriber;
    }


    @Override
    public void consume(Message message) {
        System.out.println("Logging: Delivering message to " + wrappedSubscriber.getId());
        wrappedSubscriber.consume(message);
    }

    @Override
    public String getId() {
        return wrappedSubscriber.getId();
    }
}
