package com.machineCode.pubSubsWithoutPersistence.storage;

import com.machineCode.pubSubsWithoutPersistence.pubSubExceptions.TopicNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anju
 * @created on 05/01/25 and 12:41 AM
 */
public class MessageStoreInMemory implements MessageStore{

    private final Map<String, List<Message>> topicMessages;

    public MessageStoreInMemory() {
        this.topicMessages = new HashMap<>();
    }

    public void addMessage(String topic, Message message){
        topicMessages.putIfAbsent(topic, new ArrayList<>());
        topicMessages.get(topic).add(message);
    }

    public List<Message> getMessage(String topic) throws TopicNotFoundException {
        if(topicMessages.containsKey(topic)){
            return topicMessages.get(topic);
        }
        throw new TopicNotFoundException("Topic does not exist, topic name: "+topic);
    }

    public List<Message> getUndeliveredMessages(String topic, int lastDeliveredIndex){
        List<Message> allMessages = topicMessages.getOrDefault(topic, new ArrayList<>());
        return allMessages.subList(lastDeliveredIndex+1, allMessages.size());
    }


}
