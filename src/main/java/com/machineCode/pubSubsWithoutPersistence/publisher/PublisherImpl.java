package com.machineCode.pubSubsWithoutPersistence.publisher;

import com.machineCode.pubSubsWithoutPersistence.broker.Broker;
import com.machineCode.pubSubsWithoutPersistence.storage.Message;

/**
 * @author anju
 * @created on 05/01/25 and 2:42 PM
 */
public class PublisherImpl implements Publisher{

    private final Broker broker;

    public PublisherImpl(Broker broker) {
        this.broker = broker;
    }

    @Override
    public void publish(String topic, Message message){
        broker.addMessage(topic, message);
    }
}
