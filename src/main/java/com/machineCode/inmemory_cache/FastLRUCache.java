package com.machineCode.inmemory_cache;



import com.machineCode.inmemory_cache.eviction_policy.FastLRUEvictionCache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author anju
 * @created on 25/02/25 and 6:43 PM
 */
public class FastLRUCache<K,V> implements FastCache<K,V>  {

     public Map<K,V> cacheEntries;

    int maxCacheSize;
    int ttl; // in milli sec

    private final ScheduledExecutorService cleaner = Executors.newSingleThreadScheduledExecutor();

    private static FastLRUCache fastLRUCache;

    public Map<K,V>  backUpCacheEntries;
    FastLRUEvictionCache<K,V> fastLRUEvictionCache;



    private FastLRUCache( int maxCacheSize, int ttl) {
        this.cacheEntries = new LinkedHashMap<K, V>(maxCacheSize, 0.75f, true);
        this.backUpCacheEntries = new LinkedHashMap<K, V>(maxCacheSize, 0.75f, true);
        this.maxCacheSize = maxCacheSize;
        this.ttl = ttl;
        cleaner.scheduleAtFixedRate(this::removeExpiredKeys, ttl, ttl, TimeUnit.MILLISECONDS);
        this.fastLRUEvictionCache = new FastLRUEvictionCache<>();
    }

    public static FastLRUCache getInstance(){
        if(fastLRUCache == null){
            fastLRUCache = new FastLRUCache(Configs.cacheSize, Configs.TTL);
        }
        return fastLRUCache;
    }



    @Override
    public synchronized void put(K key, V value) {
        if(cacheEntries.size() >= maxCacheSize){
            K oldKey = fastLRUEvictionCache.getEvictKey();
            backUpCacheEntries.put(oldKey, cacheEntries.get(oldKey));
            cacheEntries.remove(oldKey);
        }
        cacheEntries.put(key, value);
        fastLRUEvictionCache.updateOnInsert(key);
    }

    @Override
    public V get(K key) {
        V value = cacheEntries.get(key);
        if(value == null){
            if(backUpCacheEntries.containsKey(key))
                return backUpCacheEntries.get(key);
            else return null;
        }else{
            fastLRUEvictionCache.updateOnAccess(key);
            return value;
        }
    }

    @Override
    public synchronized void remove(K key) {
        cacheEntries.keySet().iterator().next();
    }



    private synchronized boolean isExpired(CacheKey<K> entry) {
        return (System.currentTimeMillis() - entry.getLastAccessedTime()) >= ttl;
    }


    private void removeExpiredKeys(){
        Iterator<Map.Entry<CacheKey<K>, Boolean>> iterator = fastLRUEvictionCache.getCacheEvictionData().entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<CacheKey<K>, Boolean> entry = iterator.next();
            if (isExpired(entry.getKey())) {
                System.out.println("removed key" + entry.getKey().getKey());
                backUpCacheEntries.put(entry.getKey().getKey(), cacheEntries.get(entry.getKey())); // moved to backup store
                cacheEntries.remove(entry.getKey().getKey()); // remove from primary store
                iterator.remove();
            }
        }
    }
}
