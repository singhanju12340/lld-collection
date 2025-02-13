package com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.broker;

import com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.storage.Message;
import com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.subs.Subscriber;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author anju
 * @created on 05/01/25 and 12:45 AM
 */
public class BrokerWithoutMemoryImpl implements Broker {
    private Map<String, List<Subscriber>> topicSubscriber;
    private Map<String, Queue<Message>> topicMessages;
    private ExecutorService executorService;


    public BrokerWithoutMemoryImpl() {
        this.topicSubscriber = new ConcurrentHashMap<>();
        this.topicMessages = new ConcurrentHashMap<>();
        this.executorService = Executors.newCachedThreadPool();
    }

    @Override
    public void subscribe(String topic, Subscriber subscriber) {
        topicSubscriber.putIfAbsent(topic, new ArrayList<>());
        topicSubscriber.get(topic).add(subscriber);
    }

    @Override
    public void addMessage(String topic, Message message) {
        topicMessages.putIfAbsent(topic, new LinkedList<>());
        topicMessages.get(topic).add(message);

        deliverMessage(topic);
    }

    @Override
    public void unSubscribe(String topic, Subscriber subscriber) {
        if(topicSubscriber.containsKey(topic)) {
            topicSubscriber.get(topic).remove(subscriber);
        }
    }


    public void deliverMessage(String topic){
        if(!topicSubscriber.containsKey(topic)) return;//throw new Exception("No subscriber for given topic, ");

        List<Subscriber> subscriberList = topicSubscriber.get(topic);

        Queue<Message> messageQueue = topicMessages.get(topic);

        while (!messageQueue.isEmpty()){
           Message message = messageQueue.poll();
            for ( Subscriber subscriber: subscriberList) {
                executorService.submit(()->subscriber.consume(message));
            }
        }
    }
}
