package com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.publisher;

import com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.storage.Message;
import com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.broker.Broker;

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
