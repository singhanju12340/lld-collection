package com.machineCode.inmemory_cache.eviction_policy;

/**
 * @author anju
 * @created on 25/02/25 and 6:41 PM
 */
public interface FastCacheEvictionPolicy<K> {



    K getEvictKey();

    void updateOnAccess(K key);

    void updateOnInsert(K key);





}
