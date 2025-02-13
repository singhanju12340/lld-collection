package com.tekion.aec.cp.imsjobs.controller.machineCode.consistanceHashing;

/**
 * @author anju
 * @created on 13/01/25 and 7:43 PM
 */
public interface ConsistenceHashingService {

    void addNode(String ipAddress);

    void removeNode(String ipAddress);


    String searchNode(String key);

}
