package com.tekion.aec.cp.imsjobs.controller.machineCode.keyValueStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anju
 * @created on 15/01/25 and 10:54 PM
 */
public class InMemoryKeyValueStoreImpl<K, V> implements InMemoryKeyValueStore<K, V>{

    TTLManager<K> ttlManager;
    StorageManager<K, V> storageManager;
    CacheCleanerScheduler cacheCleanerScheduler;

    public InMemoryKeyValueStoreImpl(TTLManager<K> ttlManager, StorageManager<K, V> storageManager, CacheCleanerScheduler cacheCleanerScheduler) {
        this.ttlManager = ttlManager;
        this.storageManager = storageManager;
        this.cacheCleanerScheduler = cacheCleanerScheduler;
    }

    @Override
    public void put(K key, V value) {
        storageManager.put(key, value);
        ttlManager.addTtlEntry(key, ttlManager.TTL);
    }

    @Override
    public V get(K key) {
        return storageManager.get(key);
    }

    @Override
    public void remove(K key) {
        storageManager.remove(key);
        ttlManager.removeKey(key);
    }

    @Override
    public void removeLatestExpired() {
        K key = ttlManager.getExpiredKey();
        ttlManager.removeKey(key);
    }


    public synchronized void removeExpired(){
        System.out.println("Scheduler ran removeExpired");
        List<K> keys = ttlManager.getExpiredKeys();
        for (K key:keys) {
            System.out.println("keys "+ key);
            ttlManager.removeKey(key);
            storageManager.remove(key);
        }
    }

    public void shutdown() {
        cacheCleanerScheduler.shutDown();
    }

    public void schedule() {
        cacheCleanerScheduler.createScheduler(this::removeExpired);
    }


    // add bulk save and get
    @Override
    public void putAll(Map<K , V > entries) {
        for (Map.Entry<K , V > entry: entries.entrySet()) {
            storageManager.put(entry.getKey(), entry.getValue());
            ttlManager.addTtlEntry(entry.getKey(), ttlManager.TTL);
        }
    }

    @Override
    public Map<K, V> getAll(List<K> key) {
         Map<K, V> result = new HashMap<>();
            for (K k: key) {
                result.put(k, storageManager.get(k));
            }
            return result;
    }


}
