package com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.subs;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anju
 * @created on 05/01/25 and 2:01 PM
 */
public class SubsAcknowledger {

    Map<String, Map<Subscriber, Integer>> topicSubscriberIndexTracker;

    public SubsAcknowledger() {
        this.topicSubscriberIndexTracker = new ConcurrentHashMap<>();
    }

    public void acknowledge(String topic, Subscriber subscriber , int lastIndex){
        topicSubscriberIndexTracker.putIfAbsent(topic, new HashMap<>());
        topicSubscriberIndexTracker.get(topic).put(subscriber, lastIndex);
    }

    public int getLastIndex(String topic, Subscriber subscriber){
        if(!topicSubscriberIndexTracker.containsKey(topic))
            return -1;
        return topicSubscriberIndexTracker.get(topic).get(subscriber);
    }

}
