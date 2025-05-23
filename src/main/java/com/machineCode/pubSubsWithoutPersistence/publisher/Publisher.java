package com.machineCode.pubSubsWithoutPersistence.publisher;

import com.machineCode.pubSubsWithoutPersistence.storage.Message;

/**
 * @author anju
 * @created on 05/01/25 and 2:41 PM
 */
public interface Publisher{

    public void publish(String topic, Message message) throws Exception;
}
