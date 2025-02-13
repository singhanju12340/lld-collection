package com.machineCode.pubSubsWithoutPersistence;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author anju
 * @created on 05/01/25 and 3:41 PM
 */
public class MetricsCollector {
        private final AtomicInteger messagePublished;
        private final AtomicInteger messageDelivered;
        private final AtomicInteger messageFailed;

        private static MetricsCollector matricCollector;

    private MetricsCollector() {
        this.messagePublished = new AtomicInteger(0);
        this.messageDelivered = new AtomicInteger(0);
        this.messageFailed = new AtomicInteger(0);
    }

    // Singleton design pattern
    public static MetricsCollector getInstance(){
        if(matricCollector == null)
            return new MetricsCollector();
        return matricCollector;
    }

    public AtomicInteger getMessagePublished() {
        return messagePublished;
    }

    public AtomicInteger getMessageDelivered() {
        return messageDelivered;
    }

    public AtomicInteger getMessageFailed() {
        return messageFailed;
    }

    public void incrementPublished(){
        messagePublished.incrementAndGet();
    }

    public void incrementDelivered(){
        messageDelivered.incrementAndGet();
    }

    public void incrementMessageFailed(){
        messageFailed.incrementAndGet();
    }

}
