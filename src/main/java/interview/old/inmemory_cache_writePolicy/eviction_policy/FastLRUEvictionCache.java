package interview.old.inmemory_cache_writePolicy.eviction_policy;




import interview.old.inmemory_cache_writePolicy.CacheKey;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Set;


/**
 * @author anju
 * @created on 25/02/25 and 6:44 PM
 */
public class FastLRUEvictionCache<K> implements FastCacheEvictionPolicy<K> {
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

    @Override
    public Set<CacheKey<K>> getCacheEntries() {
        return cacheEvictionData.keySet();

    }

    @Override
    public K remove(K key) {
        for (CacheKey<K> CurrentKey:cacheEvictionData.keySet()) {
            if(CurrentKey.getKey().equals(key))
                cacheEvictionData.remove(CurrentKey);
        }

        return key;
    }



}
