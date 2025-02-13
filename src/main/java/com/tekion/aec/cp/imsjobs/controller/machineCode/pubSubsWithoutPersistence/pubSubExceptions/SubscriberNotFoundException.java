package com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.pubSubExceptions;

/**
 * @author anju
 * @created on 05/01/25 and 3:28 PM
 */
public class SubscriberNotFoundException extends RuntimeException {
    public SubscriberNotFoundException(String subscriberId) {
        super("Subscriber with ID '" + subscriberId + "' not found.");
    }
}
