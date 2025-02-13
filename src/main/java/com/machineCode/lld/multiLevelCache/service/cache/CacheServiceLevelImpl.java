package com.machineCode.lld.multiLevelCache.service.cache;

import com.machineCode.lld.multiLevelCache.service.eviction.EvictionData;
import com.machineCode.lld.multiLevelCache.service.eviction.EvictionService;

import java.util.Map;

/**
 * @author anju
 * @created on 03/01/25 and 7:28 PM
 */
public class CacheServiceLevelImpl<K, V> implements CacheService<K, V> {

    Map<K,V> dataStore;
    Integer capacity;
    EvictionService<K> evictionService;
    String levelName;

    public CacheServiceLevelImpl(Map<K, V> dataStore, Integer capacity, EvictionService<K> evictionService, String levelName) {
        this.dataStore = dataStore;
        this.capacity = capacity;
        this.evictionService  = evictionService;
        this.levelName = levelName;
    }


    @Override
    public V get(K key) {
        if(!dataStore.containsKey(key)) return null;
        evictionService.updateOnAccess(key);
        return dataStore.get(key);
    }

    @Override
    public EvictionData add(K key, V value) {
        EvictionData evictionData = null;
        if(dataStore.size() == capacity){
            K evictKey = evictionService.getEvictionKey();
            V evictValue = dataStore.remove(evictKey);
            evictionService.updateOnAccess(evictKey); // Handle eviction in policy
            evictionData =  new EvictionData(evictKey, evictValue);
//            propagateEviction(evictKey, evictValue);
        }
        dataStore.put(key, value);
        evictionService.updateOnInsert(key);
        return evictionData;
    }




}
