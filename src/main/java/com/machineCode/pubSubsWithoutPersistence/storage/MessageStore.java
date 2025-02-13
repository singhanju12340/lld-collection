package com.machineCode.pubSubsWithoutPersistence.storage;

import java.util.List;

/**
 * @author anju
 * @created on 05/01/25 and 2:25 PM
 */
public interface MessageStore {

    public void addMessage(String topic, Message message);

    public List<Message> getMessage(String topic);

    public List<Message> getUndeliveredMessages(String topic, int lastDeliveredIndex);
}
