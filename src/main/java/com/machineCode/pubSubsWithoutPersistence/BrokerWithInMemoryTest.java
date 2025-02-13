package com.machineCode.pubSubsWithoutPersistence;

import com.machineCode.pubSubsWithoutPersistence.broker.BrokerWithInMemory;
import com.machineCode.pubSubsWithoutPersistence.storage.Message;
import com.machineCode.pubSubsWithoutPersistence.subs.Subscriber;
import com.machineCode.pubSubsWithoutPersistence.subs.SubscriberImpl;
import com.machineCode.pubSubsWithoutPersistence.publisher.PublisherImpl;

/**
 * @author anju
 * @created on 05/01/25 and 1:48 PM
 */
public class BrokerWithInMemoryTest {

    public static void main(String[] args) {
        String topic  = "A";
        String topic2  = "B";

        BrokerWithInMemory broker = new BrokerWithInMemory();
        PublisherImpl publisher = new PublisherImpl(broker);


        publisher.publish(topic, new Message("my message 1"));

        Subscriber s1 = new SubscriberImpl("1");
        broker.subscribe(topic, s1);

    }

}
