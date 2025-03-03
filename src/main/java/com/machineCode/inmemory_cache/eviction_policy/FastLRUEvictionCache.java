package com.machineCode.inmemory_cache.eviction_policy;


import com.machineCode.inmemory_cache.CacheKey;

import java.time.Instant;
import java.util.LinkedHashMap;


/**
 * @author anju
 * @created on 25/02/25 and 6:44 PM
 */
public class FastLRUEvictionCache<K,V> implements FastCacheEvictionPolicy<K>{
    // DS to keep data for accessing and updating w.r.t least recently used
    LinkedHashMap<CacheKey<K>, Boolean> cacheEvictionData;

    public LinkedHashMap<CacheKey<K>, Boolean> getCacheEvictionData() {
        return cacheEvictionData;
    }

    public FastLRUEvictionCache() {
        this.cacheEvictionData = new LinkedHashMap<>(){

        };
    }

    @Override
    public K getEvictKey() {
        // get first key ion the linked hashmap
        CacheKey<K> key = cacheEvictionData.keySet().iterator().next();
        cacheEvictionData.remove(key);
        return key.getKey();

    }

    @Override
    public void updateOnAccess(K key) {
        CacheKey<K> cacheKey = new CacheKey<>();
        cacheKey.setKey(key);
        cacheKey.setLastAccessedTime(Instant.now().toEpochMilli());
        cacheEvictionData.put(cacheKey, true);
    }

    @Override
    public void updateOnInsert(K key) {
        CacheKey<K> cacheKey = new CacheKey<>();
        cacheKey.setKey(key);
        cacheKey.setLastAccessedTime(Instant.now().toEpochMilli());
        cacheEvictionData.put(cacheKey, true);

    }


}
