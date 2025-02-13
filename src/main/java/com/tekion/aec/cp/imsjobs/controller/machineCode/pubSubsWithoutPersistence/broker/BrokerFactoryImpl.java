package com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.broker;

import com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.MetricsCollector;
import com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.storage.MessageStoreInMemory;

/**
 * @author anju
 * @created on 05/01/25 and 7:29 PM
 */
public class BrokerFactoryImpl extends BrokerFactory{
    @Override
    public Broker createBroker(String type) {
        if (type.equalsIgnoreCase("persistent")) {
            return new BrokerWithInMemory(new MessageStoreInMemory(), MetricsCollector.getInstance(), new PullBasedDeliveryStrategy());
        } else if (type.equalsIgnoreCase("simple")) {
            return new BrokerWithoutMemoryImpl();
        }
        throw new IllegalArgumentException("Unknown broker type: " + type);
    }
}
