package com.machineCode.inmemory_cache;



import java.time.Instant;
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

     public Map<K,CacheValue<V>> cacheEntries;

    int maxCacheSize;
    int ttl; // in milli sec

    private final ScheduledExecutorService cleaner = Executors.newSingleThreadScheduledExecutor();

    private static FastLRUCache fastLRUCache;

    Map<K,CacheValue<V>> backUpCacheEntries;



    private FastLRUCache( int maxCacheSize, int ttl) {
        this.cacheEntries = new LinkedHashMap<K, CacheValue<V>>(maxCacheSize, 0.75f, true);
        this.backUpCacheEntries = new LinkedHashMap<K, CacheValue<V>>(maxCacheSize, 0.75f, true);
        this.maxCacheSize = maxCacheSize;
        this.ttl = ttl;
        cleaner.scheduleAtFixedRate(this::removeExpiredKeys, ttl, ttl, TimeUnit.MILLISECONDS);
    }

    public static FastLRUCache getInstance(){
        if(fastLRUCache == null){
            fastLRUCache = new FastLRUCache(Configs.cacheSize, Configs.TTL);
        }
        return fastLRUCache;
    }



    @Override
    public synchronized void put(K key, V value) {
        if(cacheEntries.size() == maxCacheSize)
            cacheEntries.remove(cacheEntries.keySet().iterator().next());

        CacheValue<V> cacheValue = new CacheValue<>();
        cacheValue.setValue( value);
        cacheValue.setLastAccessedTime(Instant.now().toEpochMilli());
        cacheEntries.put(key, cacheValue);
    }

    @Override
    public V get(K key) {
        CacheValue<V> value = cacheEntries.get(key);
        if(value == null){
            if(backUpCacheEntries.containsKey(key))
                return backUpCacheEntries.get(key).getValue();
            else return null;
        }
        // if recently expired add it in backup cache
        if (isExpired(value)) {
            backUpCacheEntries.put(key, value);
            cacheEntries.remove(key);
            return value.getValue();
        }
        value.setLastAccessedTime(Instant.now().toEpochMilli());
        return value.getValue();
    }

    @Override
    public synchronized void remove(K key) {
        cacheEntries.keySet().iterator().next();
    }





    private synchronized boolean isExpired(CacheValue<V> entry) {
        return (System.currentTimeMillis() - entry.getLastAccessedTime()) >= ttl;
    }


    private void removeExpiredKeys(){
        Iterator<Map.Entry<K, CacheValue<V>>> iterator = cacheEntries.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<K, CacheValue<V>> entry = iterator.next();
            if (isExpired(entry.getValue())) {
                System.out.println("removed key" + entry.getValue().getValue());
                backUpCacheEntries.put(entry.getKey(), entry.getValue()); // moved to backup store
                iterator.remove();
            }
        }
    }
}
