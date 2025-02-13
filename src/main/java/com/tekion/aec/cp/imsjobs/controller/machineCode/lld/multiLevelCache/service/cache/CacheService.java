package com.tekion.aec.cp.imsjobs.controller.machineCode.lld.multiLevelCache.service.cache;

import com.tekion.aec.cp.imsjobs.controller.machineCode.lld.multiLevelCache.service.eviction.EvictionData;

/**
 * @author anju
 * @created on 03/01/25 and 3:27 PM
 */

public interface CacheService<K, V> {

    public V get(K key);
    public EvictionData add(K key, V value);

}
