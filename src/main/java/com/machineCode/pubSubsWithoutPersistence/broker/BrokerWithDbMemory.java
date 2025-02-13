package com.machineCode.pubSubsWithoutPersistence.broker;

import com.machineCode.pubSubsWithoutPersistence.storage.Message;
import com.machineCode.pubSubsWithoutPersistence.subs.Subscriber;

/**
 * @author anju
 * @created on 05/01/25 and 1:48 PM
 */
public class BrokerWithDbMemory implements Broker {
    @Override
    public void subscribe(String topic, Subscriber subscriber) {

    }


    @Override
    public void unSubscribe(String topic, Subscriber subscriber) {

    }

    @Override
    public void addMessage(String topic, Message message) {

    }
}
