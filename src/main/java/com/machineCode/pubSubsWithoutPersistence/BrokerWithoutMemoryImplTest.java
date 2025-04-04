package com.machineCode.pubSubsWithoutPersistence;

import com.machineCode.pubSubsWithoutPersistence.broker.Broker;
import com.machineCode.pubSubsWithoutPersistence.broker.BrokerFactory;
import com.machineCode.pubSubsWithoutPersistence.broker.BrokerFactoryImpl;
import com.machineCode.pubSubsWithoutPersistence.storage.Message;
import com.machineCode.pubSubsWithoutPersistence.subs.Subscriber;
import com.machineCode.pubSubsWithoutPersistence.subs.SubscriberImpl;

/**
 * @author anju
 * @created on 05/01/25 and 1:06 AM
 */
public class BrokerWithoutMemoryImplTest {
    public static void main(String[] args) {

        String topic  = "A";
        String topic2  = "B";



        BrokerFactory factory = new BrokerFactoryImpl();
        Broker brokerWithoutMemory = factory.createBroker("persistent");

        Subscriber s1 = new SubscriberImpl("1");
        brokerWithoutMemory.subscribe(topic, s1);
        brokerWithoutMemory.subscribe(topic, new SubscriberImpl("2"));

        brokerWithoutMemory.subscribe(topic2, s1);

        brokerWithoutMemory.addMessage(topic, new Message("Anju"));
        brokerWithoutMemory.addMessage(topic, new Message("Manju"));
        brokerWithoutMemory.addMessage(topic, new Message("Sanju"));
        brokerWithoutMemory.addMessage(topic2, new Message("Topic 2 Sanju"));
    }
}
