package com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.broker;

import com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.MetricsCollector;
import com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.storage.Message;
import com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.storage.MessageStore;
import com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.subs.SubsAcknowledger;
import com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.subs.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @author anju
 * @created on 05/01/25 and 7:49 PM
 */
public class PushBasedDeliveryStrategy implements DeliveryStrategy{

    Map<String, List<Subscriber>> topicSubscriber;
    MessageStore messageStore; // inmemory message store
    SubsAcknowledger subsAcknowledger;
    ExecutorService executorService;

    @Override
    public Boolean deliver(String topic) {
        // trigger message delivery to topic
        List<Message> messages = messageStore.getMessage(topic);

        for (Subscriber subscriber : topicSubscriber.getOrDefault(topic, new ArrayList<>())) {
            int lastIndex = subsAcknowledger.getLastIndex(topic, subscriber);
            for(int i=lastIndex+1; i<messages.size(); i++){
                Message message = messageStore.getMessage(topic).get(i);
                executorService.submit(()-> {
                    try {
                        subscriber.consume(message);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                });
                subsAcknowledger.acknowledge(topic, subscriber, i);
            }
        }

        return true;
    }
}
