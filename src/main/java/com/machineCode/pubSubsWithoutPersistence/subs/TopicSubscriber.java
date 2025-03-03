package com.machineCode.pubSubsWithoutPersistence.subs;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author anju
 * @created on 03/03/25 and 11:15 PM
 */
public class TopicSubscriber {
    private AtomicInteger offset;
    private final Subscriber subscriber;

    public TopicSubscriber(final Subscriber subscriber) {
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }

   public int updateOffset(){
       return offset.incrementAndGet();
   }

    public int getOffset(){
        return offset.get();
    }
}
