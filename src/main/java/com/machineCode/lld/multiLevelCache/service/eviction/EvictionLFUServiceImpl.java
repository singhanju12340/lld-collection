package com.machineCode.lld.multiLevelCache.service.eviction;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author anju
 * @created on 03/01/25 and 7:35 PM
 */
public class EvictionLFUServiceImpl<K> implements EvictionService<K>{

    PriorityQueue<K> minHeap;
    Map<K, Integer> frequencyMap;

    public EvictionLFUServiceImpl() {
        frequencyMap = new HashMap<>();
        minHeap = new PriorityQueue<>( (a,b)->frequencyMap.get(a)- frequencyMap.get(b));
    }

    @Override
    public K getEvictionKey() {
        return minHeap.peek();
    }

    @Override
    public void updateOnAccess(K key) {
        frequencyMap.put(key, frequencyMap.get(key)+1 );
        minHeap.remove(key);
        // reorder min heap to keep data with least frequency after updating frequency count for current key
        minHeap.add(key);
    }

    @Override
    public void updateOnInsert(K key) {
        frequencyMap.put(key, 1 );
        minHeap.add(key);
    }
}
