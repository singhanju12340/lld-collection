package com.machineCode.lld.multiLevelCache.service.eviction;
import java.util.LinkedHashMap;

/**
 * @author anju
 * @created on 03/01/25 and 7:35 PM
 */
public class EvictionLRUServiceImpl<K> implements EvictionService<K>{

    LinkedHashMap<K, Boolean> linkedHashMap = new LinkedHashMap<>(10, 0.75f ,true); // enable access = true, maintains accecss order

    @Override
    public K getEvictionKey() {
        // get first key ion the linked hashmap
        return linkedHashMap.keySet().iterator().next();
    }

    @Override
    public void updateOnAccess(K key) {
        linkedHashMap.put(key, true);

    }

    @Override
    public void updateOnInsert(K key) {
        linkedHashMap.put(key, true);
    }

}
