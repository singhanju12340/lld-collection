package com.machineCode.lld.multiLevelCache.service.eviction;

/**
 * @author anju
 * @created on 04/01/25 and 1:15 PM
 */
public class EvictionData<K, V> {
    K key;
    V value;

    public EvictionData(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
