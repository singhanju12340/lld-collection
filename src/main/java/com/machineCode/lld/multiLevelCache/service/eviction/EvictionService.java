package com.machineCode.lld.multiLevelCache.service.eviction;

/**
 * @author anju
 * @created on 03/01/25 and 7:29 PM
 */
public interface EvictionService<K> {

    K getEvictionKey();
    void updateOnAccess(K key);

    void updateOnInsert(K key);

}
