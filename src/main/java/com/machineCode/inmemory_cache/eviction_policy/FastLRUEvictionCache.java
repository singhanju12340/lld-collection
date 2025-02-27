//package com.machineCode.inmemory_cache.eviction_policy;
//
//
//import com.machineCode.inmemory_cache.FastLRUCache;
//
//
///**
// * @author anju
// * @created on 25/02/25 and 6:44 PM
// */
//public class FastLRUEvictionCache<K,V> implements FastCacheEvictionPolicy<K>{
//    // DS to keep data for accessing and updating w.r.t least recently used
//    FastLRUCache cache;
//
//    public FastLRUEvictionCache() {
//        this.cache = cache;
//    }
//
//    @Override
//    public void evictionKey() {
//        // get first key ion the linked hashmap
//         cache.cacheEntries.keySet().iterator().next();
//    }
//
//
//}
