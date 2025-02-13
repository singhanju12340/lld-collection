package com.machineCode.pubSubsWithoutPersistence.storage;

/**
 * @author anju
 * @created on 05/01/25 and 12:32 AM
 */
public class Message {
    private String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
