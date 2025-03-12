package com.machineCode.inmemory_cache_writePolicy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anju
 * @created on 12/03/25 and 11:05 PM
 */
public class PersistenceStorage<K, V> {
    public Map<K,V> backUpCacheEntries;
    private static  PersistenceStorage persistenceStorage;

    PersistenceStorage(){
        backUpCacheEntries = new ConcurrentHashMap<>();
    }

    public static PersistenceStorage getInstance(){
        if(persistenceStorage == null){
            persistenceStorage = new PersistenceStorage();
        }
        return persistenceStorage;
    }

    public void write(K key, V value){
        backUpCacheEntries.put(key, value);
    }

    public V get(K key){
        return backUpCacheEntries.get(key);
    }


}
