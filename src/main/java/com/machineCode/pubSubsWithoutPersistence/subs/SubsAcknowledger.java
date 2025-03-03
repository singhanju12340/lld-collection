package com.machineCode.pubSubsWithoutPersistence.subs;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anju
 * @created on 05/01/25 and 2:01 PM
 */
public class SubsAcknowledger {

    Map<String, TopicSubscriber> topicSubscriberIndexTracker;

    public SubsAcknowledger() {
        this.topicSubscriberIndexTracker = new ConcurrentHashMap<>();
    }

    public void acknowledge(String topic, Subscriber subscriber){
        topicSubscriberIndexTracker.putIfAbsent(topic, new TopicSubscriber(subscriber));
        topicSubscriberIndexTracker.get(topic).updateOffset();
    }

    public int getLastIndex(String topic, Subscriber subscriber){
        if(!topicSubscriberIndexTracker.containsKey(topic))
            return -1;
        return topicSubscriberIndexTracker.get(topic).updateOffset();
    }

}
