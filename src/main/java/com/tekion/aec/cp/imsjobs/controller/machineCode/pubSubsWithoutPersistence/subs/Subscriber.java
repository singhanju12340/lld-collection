package com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.subs;

import com.tekion.aec.cp.imsjobs.controller.machineCode.pubSubsWithoutPersistence.storage.Message;

/**
 * @author anju
 * @created on 05/01/25 and 12:35 AM
 */
public interface Subscriber {

    public void consume(Message message);

    public String getId();
}
