package interview.inmemory_cache_writePolicy;





import interview.inmemory_cache_writePolicy.eviction_policy.FastCacheEvictionPolicy;
import interview.inmemory_cache_writePolicy.eviction_policy.FastLRUEvictionCache;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author anju
 * @created on 25/02/25 and 6:43 PM
 */
public class FastLRUCache<K,V> implements FastCache<K,V> {

     public Map<K,V> cacheEntries;

    int maxCacheSize;
    int ttl; // in milli sec

    private final ScheduledExecutorService cleaner = Executors.newSingleThreadScheduledExecutor();

    private static FastLRUCache fastLRUCache;

    FastCacheEvictionPolicy<K> fastLRUEvictionCache;



    private FastLRUCache( int maxCacheSize, int ttl) {
        this.cacheEntries = new ConcurrentHashMap<K,V>();
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
//            backUpCacheEntries.put(oldKey, cacheEntries.get(oldKey));
            cacheEntries.remove(oldKey);
        }
        cacheEntries.put(key, value);
        fastLRUEvictionCache.updateOnInsert(key);
    }

    @Override
    public V get(K key) {
        V value = cacheEntries.get(key);
        if(value == null){
             return null;
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


    public void removeExpiredKeys(){
        Set<CacheKey<K>> keys = fastLRUEvictionCache.getCacheEntries();

        for (CacheKey<K> key : keys) {
            if (isExpired(key)) {
                System.out.println("removed key: " + key.getKey());
                cacheEntries.remove(key.getKey()); // remove from primary store
                fastLRUEvictionCache.remove(key.getKey());
            }
        }
    }
}
