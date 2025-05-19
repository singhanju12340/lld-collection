package com.machineCode.lld.multiLevelCache.service.eviction;
import java.util.LinkedHashMap;

/**
 * @author anju
 * @created on 03/01/25 and 7:35 PM
 */
public class EvictionLRUServiceImpl<K> implements EvictionService<K>{

    LinkedHashMap<K, Boolean> linkedHashMap = new LinkedHashMap<>(10, 0.75f ,true); // enable access = true, maintains accecss order

    // removeEldestEntry can directly remove eldest entry if size is greater than 10
    // linkedHashMap is implementation of doubly linked list
    LinkedHashMap<K, Boolean> linkedHashMap2 = new LinkedHashMap<>(10, 0.75f ,true
    ){
        @Override
        protected boolean removeEldestEntry(java.util.Map.Entry<K, Boolean> eldest) {
            return size() > 10;
        }
    };

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
