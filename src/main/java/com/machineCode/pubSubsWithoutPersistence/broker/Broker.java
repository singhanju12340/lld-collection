package com.machineCode.pubSubsWithoutPersistence.broker;

import com.machineCode.pubSubsWithoutPersistence.storage.Message;
import com.machineCode.pubSubsWithoutPersistence.pubSubExceptions.SubscriberNotFoundException;
import com.machineCode.pubSubsWithoutPersistence.pubSubExceptions.TopicNotFoundException;
import com.machineCode.pubSubsWithoutPersistence.subs.Subscriber;

/**
 * @author anju
 * @created on 05/01/25 and 12:38 AM
 */
public interface Broker {

    public void subscribe(String topic, Subscriber subscriber);
//    public void publish(String topic, Message message) throws Exception;
    public void unSubscribe(String topic, Subscriber subscriber) throws SubscriberNotFoundException;

    void addMessage(String topic, Message message) throws TopicNotFoundException;


}
