package com.machineCode.pubSubsWithoutPersistence.subs;

import com.machineCode.pubSubsWithoutPersistence.storage.Message;

/**
 * @author anju
 * @created on 05/01/25 and 12:35 AM
 */
public interface Subscriber {

    public void consume(Message message);

    public String getId();
}
