package com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.broker;

/**
 * @author anju
 * @created on 05/01/25 and 7:48 PM
 */
public interface DeliveryStrategy {
    public Boolean deliver(String topic);
}
