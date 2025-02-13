package com.tekion.aec.cp.imsjobs.controller.machineCode.keyValueStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anju
 * @created on 15/01/25 and 11:19 PM
 */
public class StorageManager<K, V> {

    ConcurrentHashMap<K, V> keyValueStore;

    public StorageManager() {
        this.keyValueStore = new ConcurrentHashMap<>();
    }

    public void put(K key, V value) {
        keyValueStore.put(key, value);
    }

    public V get(K key) {
        return keyValueStore.get(key);
    }

    public void remove(K key) {
        keyValueStore.remove(key);
    }







}
