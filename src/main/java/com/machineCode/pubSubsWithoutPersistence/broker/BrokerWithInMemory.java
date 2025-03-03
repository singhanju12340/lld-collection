package com.machineCode.pubSubsWithoutPersistence.broker;

import com.machineCode.pubSubsWithoutPersistence.subs.SubsAcknowledger;
import com.machineCode.pubSubsWithoutPersistence.MetricsCollector;
import com.machineCode.pubSubsWithoutPersistence.storage.Message;
import com.machineCode.pubSubsWithoutPersistence.pubSubExceptions.SubscriberNotFoundException;
import com.machineCode.pubSubsWithoutPersistence.pubSubExceptions.TopicNotFoundException;
import com.machineCode.pubSubsWithoutPersistence.storage.MessageStore;
import com.machineCode.pubSubsWithoutPersistence.storage.MessageStoreInMemory;
import com.machineCode.pubSubsWithoutPersistence.subs.Subscriber;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author anju
 * @created on 05/01/25 and 12:45 AM
 */

public class BrokerWithInMemory implements Broker {
    Map<String, List<Subscriber>> topicSubscriber;
    MessageStore messageStore; // inmemory message store
    SubsAcknowledger subsAcknowledger;
    ExecutorService executorService;
    MetricsCollector metricsCollector;
    DeliveryStrategy deliveryStrategy;

    public BrokerWithInMemory() {
        this.topicSubscriber = new ConcurrentHashMap<>();
        this.subsAcknowledger = new SubsAcknowledger();
        messageStore = new MessageStoreInMemory();
        executorService = Executors.newCachedThreadPool();
        metricsCollector = MetricsCollector.getInstance();
        this.deliveryStrategy = new PullBasedDeliveryStrategy();
    }

    public BrokerWithInMemory(MessageStore messageStore, MetricsCollector metricsCollector, DeliveryStrategy deliveryStrategy) {
        this.topicSubscriber = new ConcurrentHashMap<>();
        this.subsAcknowledger = new SubsAcknowledger();
        this.messageStore = messageStore;
        executorService = Executors.newCachedThreadPool();
        this.metricsCollector = metricsCollector;
        this.deliveryStrategy = deliveryStrategy;
    }

    @Override
    public void subscribe(String topic, Subscriber subscriber) {
        topicSubscriber.putIfAbsent(topic, new ArrayList<>());
        topicSubscriber.get(topic).add(subscriber);


        //add topic details in subscriber initial index
        int lastUnreadIndex = subsAcknowledger.getLastIndex(topic, subscriber);
        for (Message message :messageStore.getMessage(topic)) {
            subscriber.consume(message);
            subsAcknowledger.acknowledge(topic, subscriber);
        }
    }

    @Override
    public void addMessage(String topic, Message message) throws TopicNotFoundException {
        validateInputs(topic, message);
        messageStore.addMessage(topic, message);
        metricsCollector.incrementPublished();
        deliver(topic);
    }

    private void validateInputs(String topic, Message object) {
        if (topic == null || topic.isEmpty()) {
            throw new IllegalArgumentException("Topic cannot be null or empty");
        }
        if (object == null) {
            throw new IllegalArgumentException("Input object cannot be null");
        }
    }

    private void deliver(String topic) throws TopicNotFoundException {
        Boolean status = deliveryStrategy.deliver(topic);
        if(status)
            metricsCollector.incrementDelivered();
        else
            metricsCollector.incrementMessageFailed();
    }

    @Override
    public void unSubscribe(String topic, Subscriber subscriber) {
        if(topicSubscriber.containsKey(topic)){
            topicSubscriber.get(topic).remove(subscriber);
        }
        throw new SubscriberNotFoundException("No subscriber found for given topic: " +topic +" ,Subscriber: "+ subscriber );
    }



}
