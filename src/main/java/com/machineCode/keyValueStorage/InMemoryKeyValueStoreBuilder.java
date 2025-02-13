package com.machineCode.keyValueStorage;

import java.util.concurrent.Executors;

/**
 * @author anju
 * @created on 15/01/25 and 11:30 PM
 */
public class InMemoryKeyValueStoreBuilder<K, V> {

    TTLManager<K> ttlManager;
    StorageManager<K, V> storageManager;
    CacheCleanerScheduler scheduler;

    public InMemoryKeyValueStoreBuilder setTtlManager(TTLManager<K> ttlManager) {
        this.ttlManager = ttlManager;
        return this;
    }

    public InMemoryKeyValueStoreBuilder setStorageManager(StorageManager<K, V> storageManager) {
        this.storageManager = storageManager;
        return this;
    }

    public InMemoryKeyValueStoreBuilder setScheduler() {
        this.scheduler = new CacheCleanerScheduler(Executors.newSingleThreadScheduledExecutor());
        return this;
    }



    public InMemoryKeyValueStoreImpl build(){
        return new InMemoryKeyValueStoreImpl(ttlManager, storageManager, scheduler);
    }
}
