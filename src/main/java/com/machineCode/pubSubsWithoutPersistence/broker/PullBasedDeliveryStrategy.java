package com.machineCode.pubSubsWithoutPersistence.broker;

/**
 * @author anju
 * @created on 05/01/25 and 7:49 PM
 */
public class PullBasedDeliveryStrategy implements DeliveryStrategy{

    @Override
    public Boolean deliver(String topic) {
        // store message and let the subscriber pull the message
        return true;
    }
}
