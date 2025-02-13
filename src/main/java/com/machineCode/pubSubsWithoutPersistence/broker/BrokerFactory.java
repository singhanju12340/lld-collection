package com.machineCode.pubSubsWithoutPersistence.broker;

/**
 * @author anju
 * @created on 05/01/25 and 7:28 PM
 */
public abstract class BrokerFactory {
    public abstract Broker createBroker(String type);

}
