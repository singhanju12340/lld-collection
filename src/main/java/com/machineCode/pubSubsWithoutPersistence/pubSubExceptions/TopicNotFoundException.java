package com.machineCode.pubSubsWithoutPersistence.pubSubExceptions;

/**
 * @author anju
 * @created on 05/01/25 and 3:28 PM
 */
public class TopicNotFoundException extends RuntimeException {
    public TopicNotFoundException(String topic) {
        super("Topic '" + topic + "' not found.");
    }
}
