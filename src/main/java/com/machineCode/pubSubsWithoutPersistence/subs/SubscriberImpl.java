package com.machineCode.pubSubsWithoutPersistence.subs;

import com.machineCode.pubSubsWithoutPersistence.storage.Message;

/**
 * @author anju
 * @created on 05/01/25 and 12:36 AM
 */
public class SubscriberImpl implements Subscriber {
        String id;

    public SubscriberImpl(String name) {
        this.id = name;
    }

    @Override
    public void consume(Message message) {
        System.out.println("consumed message : "+ message.getContent() + " , subscriber: " + id);
        // do some work in consumer
    }

    @Override
    public String getId() {
        return this.id;
    }
}
