package interview.inmemory_cache_writePolicy.eviction_policy;


import interview.inmemory_cache_writePolicy.CacheKey;

import java.util.Set;

/**
 * @author anju
 * @created on 25/02/25 and 6:41 PM
 */
public interface FastCacheEvictionPolicy<K> {
    K getEvictKey();

    void updateOnAccess(K key);

    void updateOnInsert(K key);

    public Set<CacheKey<K>> getCacheEntries();

    K remove(K key);



}
